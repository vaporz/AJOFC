
package org.jofc.builder;

import org.apache.commons.lang.StringUtils;
import org.jofc.bean.ChartTable;
import org.jofc.enums.Chart;
import org.jofc.enums.ORDER;
import org.jofc.itf.ChartTableItem;
import org.jofc.itf.JOFCDataCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 继承这个抽象类，并按注释实现两个抽象方法即可在页面上显示图和表格，支持升序，降序或不排序<br>
 * 详细使用方法见wiki：<br>
 * http://todo
 * 
 * @author 张啸 (zhangxiao@xiaomi.com):
 * @version 创建时间：2011-6-24 下午06:34:39
 * @param <T>
 */
public class ChartTableDirector<T extends ChartTableItem> {

    private ChartTableBuilder<T> chartTableBuilder;

    private ChartTable ct = new ChartTable();

    private JOFCDataCache cache = null;

    private int itemLimit = 0;

    private boolean isSumUpByColumn = true;

    public ChartTableDirector(ChartTableBuilder<T> chartTableBuilder) {
        this.chartTableBuilder = chartTableBuilder;
    }

    protected Map<String, Object> context = new HashMap<String, Object>();

    /**
     * 子类的执行入口必须调用这个方法
     * 
     * @param tableSize 表格的“长度”，比如对每个项目列出多少天的数据
     * @param order 排序方式
     * @param chartType 图的类型，可用的是折线图，饼图
     * @param isShowItemByColumn 是否在“列”上列出表项（比如在“列”上列出项目，在“行”上列出时间日期的表格）
     * @param isShowChartByColumn 按组取数据绘图时，按行取还是按列取，例如折线图中，true表示每一列数据为一条线，false表示每一行数据为一条线
     */
    public ChartTable build(Chart chartType, int tableSize, ORDER order, boolean isShowItemByColumn, boolean isShowChartByColumn) {
        long start = System.currentTimeMillis();
        List<T> itemList = new ArrayList<T>();
        chartTableBuilder.setItemList(itemList, context);
        if (itemLimit == 0) {
            setItemLimit(itemList.size());
        }
        itemList = chartTableBuilder.sortItemList(itemList, order, itemLimit);

        int rowNum = isShowItemByColumn ? itemList.size() : tableSize;
        int colNum = isShowItemByColumn ? tableSize + 1 : itemList.size() + 1;
        String[] itemNames = chartTableBuilder.getItemNames(itemList);
        String[] sideNames = chartTableBuilder.getSideNames(tableSize, context);
        String[] rowNames = isShowItemByColumn ? itemNames : sideNames;
        String[] colNames = isShowItemByColumn ? sideNames : itemNames;
        ChartTableItem[][] tableData = chartTableBuilder.getTableData(rowNum, colNum, isShowItemByColumn, itemList, context);

        ct.setRowNum(rowNum);
        ct.setColNum(colNum);
        ct.setRowNames(rowNames);
        ct.setColNames(chartTableBuilder.getCornerName(context), colNames);
        ct.setTableData(tableData);
        ct.setChartType(chartType);
        ct.setShowChartByColumn(isShowChartByColumn);
        ct.setSumData(chartTableBuilder.sumUp(isSumUpByColumn(), tableData.clone()));
        ct.generateChartJson(null);
        long finish = System.currentTimeMillis();
        ct.setTimeCost(finish - start);

        return ct;
    }

    private static ExecutorService pool = Executors.newFixedThreadPool(20);

    /**
     * 异步提交一个的查询，同时可以设置超时时间，如果在超时时间内结束查询，返回被填充数据的ChartTable对象，<br>
     * 如果在超时时间内未结束查询，返回null。<br>
     * 可以通过{@link ChartTableDirector#isRunning(String)}方法来查看查询任务是否结束
     * 
     * @param dataKey 查询任务的标识，建议为每个查询任务指定一个标识，当一个任务在超时时间内未完成时，之后的程序中可以用这个标识来查询任务是否已经结束
     * @param timeout 超时时间
     * @param chartType 图表类型
     * @param tableSize 表格的“长度”，比如对每个项目列出多少天的数据
     * @param order 排序方式
     * @param isShowItemByColumn 是否在“列”上列出表项（比如在“列”上列出项目，在“行”上列出时间日期的表格）
     * @param isShowChartByColumn 按组取数据绘图时，按行取还是按列取，例如折线图中，true表示每一列数据为一条线，false表示每一行数据为一条线
     * @return 如果查询在超时时间内结束查询，返回true，否则返回false
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public ChartTable submitQueryTask(String dataKey, long timeout, Chart chartType, int tableSize, ORDER order,
        boolean isShowItemByColumn, boolean isShowChartByColumn) throws InterruptedException, ExecutionException {
        setRunning(dataKey, true);
        boolean finish = false;
        Future<?> f = pool.submit(new QueryTask(dataKey, this, chartType, tableSize, order, true, cache));
        try {
            f.get(timeout, TimeUnit.SECONDS);
            finish = true;
        } catch (TimeoutException e) {
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e) {
            throw e;
        }
        if (finish) {
            return ct;
        } else {
            return null;
        }
    }

    /**
     * 得到外部缓存的引用
     * 
     * @return
     */
    public JOFCDataCache getCache() {
        return cache;
    }

    /**
     * 设置外部缓存
     * 
     * @param cache 表示外部缓存策略，传入一个实现了接口{@link JOFCDataCache}的类的引用
     */
    public void setCache(JOFCDataCache cache) {
        this.cache = cache;
    }

    /**
     * 记录所有任务的执行状态
     */
    private static Map<String, AtomicBoolean> isRunningMap = new Hashtable<String, AtomicBoolean>();

    private static void setRunning(String key, boolean isRunning) {
        if (!StringUtils.isEmpty(key)) {
            isRunningMap.put(key, new AtomicBoolean(isRunning));
        }
    }

    /**
     * 返回查询任务“key”的执行状态
     * 
     * @param key
     * @return true表示仍在执行，false表示已执行结束
     */
    public static boolean isRunning(String key) {
        return isRunningMap.get(key) == null ? false : isRunningMap.get(key).get();
    }

    /**
     * 清除所有执行状态记录
     */
    public static void clearRunningMap() {
        isRunningMap.clear();
    }

    private static Map<String, ChartTable> queryTableCache = new HashMap<String, ChartTable>();

    /**
     * 从外部缓存和本地内存中把键为key的数据清除
     * 
     * @param key
     * @param cache
     */
    public static void deleteQueryResult(String key, JOFCDataCache cache) {
        if (!StringUtils.isEmpty(key)) {
            queryTableCache.remove(key);
            cache.deleteQueryResultFromCache(key);
        }
    }

    /**
     * 为了防止外部缓存过期和本地服务器重启时丢失结果数据，将本地缓存和外部缓存结合使用<br>
     * 外部缓存可以是Memcached等，通过getQueryResultFromCache和setQueryResultFromCache方法来应用你的缓存方式
     * 
     * @param key
     * @return
     */
    public static ChartTable getQueryResult(String key, JOFCDataCache cache) {
        ChartTable ct = getQueryResultFromCache(key, cache);// 先从外部缓存取
        if (ct == null) {// 取不到，则从本地取
            ct = queryTableCache.get(key);
            if (ct != null) {// 取到了，放到外部缓存中
                putQueryResultFromCache(key, ct, cache);
            }
        }
        return ct;
    }

    /**
     * 将含有查询结果的对象ct分别放到本地缓存和外部缓存中
     * 
     * @param key
     * @param ct
     * @param cache
     */
    public static void setQueryResult(String key, ChartTable ct, JOFCDataCache cache) {
        if (!StringUtils.isEmpty(key)) {
            queryTableCache.put(key, ct);
            putQueryResultFromCache(key, ct, cache);
        }
    }

    /**
     * 从外部cache取出结果数据，外部cache可以是Memcached，磁盘文件等分布式或持久化的存储方式<br>
     * 通俗的说，至少应该是不是使得数据在web服务器重启时丢失的存储方式<br>
     * ps:cache对象一般用单例即可，不需要每次都new一个
     * 
     * @param key
     * @return
     */
    public static ChartTable getQueryResultFromCache(String key, JOFCDataCache cache) {
        if (cache == null) {
            return null;
        }
        return cache.getQueryResultFromCache(key);
    }

    /**
     * 将数据放到外部缓存中
     * 
     * @param key
     * @return
     */
    public static void putQueryResultFromCache(String key, ChartTable ct, JOFCDataCache cache) {
        if (cache == null) {
            return;
        }
        cache.putQueryResultInCache(key, ct);
    }

    private class QueryTask implements Runnable {
        String dataKey;
        ChartTableDirector<T> director;
        Chart chartType;
        int tableSize;
        ORDER order;
        boolean isShowItemByColumn;
        boolean isShowChartByColumn;
        JOFCDataCache cache;

        @Override
        public void run() {
            this.director.build(chartType, tableSize, order, isShowItemByColumn, isShowChartByColumn);
            setQueryResult(dataKey, ct, cache);
            setRunning(dataKey, false);
        }

        public QueryTask(String dataKey, ChartTableDirector<T> director, Chart chartType, int tableSize, ORDER order,
                         boolean isShowItemByColumn, JOFCDataCache cache) {
            this.dataKey = dataKey;
            this.director = director;
            this.chartType = chartType;
            this.tableSize = tableSize;
            this.order = order;
            this.isShowItemByColumn = isShowItemByColumn;
            if (chartType == Chart.PIE) {
                this.isShowChartByColumn = true;
            } else {
                this.isShowChartByColumn = false;
            }
            this.cache = cache;
        }

    }

    /**
     * 将一对参数存入上下文传递给后面的逻辑用
     * 
     * @param key
     * @param value
     */
    public void setContext(String key, Object value) {
        context.put(key, value);
    }

    /**
     * 从上下文中取出前面的代码中设置的值
     * 
     * @param key
     * @return
     */
    public Object getContext(String key) {
        return context.get(key);
    }

    /**
     * 返回饼图的半径，单位是像素，默认值是180
     * 
     * @return
     */
    public int getPieRadius() {
        return ct.getPieRadius();
    }

    /**
     * 设置饼图的半径，单位是像素
     * 
     * @param pieRadius
     */
    public void setPieRadius(int pieRadius) {
        ct.setPieRadius(pieRadius);
    }

    /**
     * 返回显示图例的个数，-1表示全部都显示
     * 
     * @return
     */
    public int getLegendNum() {
        return ct.getLegendNum();
    }

    /**
     * 设置显示图例的个数，-1表示全部都显示
     * 
     * @param legendNum
     */
    public void setLegendNum(int legendNum) {
        ct.setLegendNum(legendNum);
    }

    /**
     * 设置是否显示图形
     * 
     * @param showChart
     * @return
     */
    public void setShowChart(boolean showChart) {
        ct.setShowChart(showChart);
    }

    public boolean isShowChart() {
        return ct.isShowChart();
    }

    public boolean isShowTable() {
        return ct.isShowTable();
    }

    /**
     * 设置是否显示表格
     * 
     * @param showTable
     */
    public void setShowTable(boolean showTable) {
        ct.setShowTable(showTable);
    }

    /**
     * 是否左右翻转图形
     * 
     * @param reverseChart
     * @return
     */
    public void setReverseChart(boolean reverseChart) {
        ct.setReverseChart(reverseChart);
    }

    /**
     * 返回饼图的块数
     * 
     * @param pieSliceNum
     */
    public int getPieSliceNum() {
        return ct.getPieSliceNum();
    }

    /**
     * 设置饼图的块数
     * 
     * @param pieSliceNum
     */
    public void setPieSliceNum(int pieSliceNum) {
        ct.setPieSliceNum(pieSliceNum);
    }

    /**
     * 是否按列方向对数据汇总求和
     * 
     * @return
     */
    public boolean isSumUpByColumn() {
        return isSumUpByColumn;
    }

    /**
     * 设置是否按列方向对数据汇总求和
     * 
     * @param isSumUpByColumn
     */
    public void setSumUpByColumn(boolean isSumUpByColumn) {
        this.isSumUpByColumn = isSumUpByColumn;
    }

    /**
     * 数据显示的项数
     * 
     * @return
     */
    public int getItemLimit() {
        return itemLimit;
    }

    /**
     * 设置数据显示的项数
     * 
     * @param itemLimit
     */
    public void setItemLimit(int itemLimit) {
        this.itemLimit = itemLimit;
    }

    /**
     * 得到折线图中折线最大数量
     * 
     * @return
     */
    public int getMaxLineNum() {
        return ct.getMaxLineNum();
    }

    /**
     * 设置折线图中折线最大数量
     * 
     * @param maxLineNum
     */
    public void setMaxLineNum(int maxLineNum) {
        ct.setMaxLineNum(maxLineNum);
    }

}
