
package org.jofc.builder;

import org.jofc.enums.ORDER;
import org.jofc.itf.ChartTableItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * 封装了生成图表的过程，只需要继承这个类，并根据自己的实际情况实现3个很简单的抽象方法即可
 * 
 * @author 张啸 (zhangxiao@xiaomi.com):
 * @version 创建时间：2011-6-27 下午08:03:05
 */
public abstract class ChartTableBuilder<T extends ChartTableItem> {

    /**
     * 返回表项名数组
     * 
     * @param offset
     * @param colNum
     * @return
     */
    protected String[] getItemNames(List<T> itemList) {
        int listSize = itemList.size();
        String[] result = new String[listSize];
        for (int i = 0; i < listSize; i++) {
            result[i] = itemList.get(i).getItemName();
        }
        return result;
    }

    /**
     * 按照对象T的getValue方法返回的值排序，如果有重复的value，则通过treeMap排序，否则使用冒泡排序
     * 
     * @param map
     * @return
     */
    protected List<T> sortItemList(List<T> list, ORDER order, int itemLimit) {
        List<T> result = new ArrayList<T>();
        if (order != ORDER.NONE) {
            Map<T, Double> map = new HashMap<T, Double>();

            TreeMap<Double, T> treeMap = new TreeMap<Double, T>();
            boolean duplicated = false;
            for (T item : list) {
                if (treeMap.get(item.getItemData().doubleValue()) != null) {
                    duplicated = true;
                } else {
                    treeMap.put(item.getItemData().doubleValue(), item);
                }
                map.put(item, item.getItemData().doubleValue());
            }

            if (duplicated) {// 如果有重复的value值，则需要用冒泡排序
                bubbleSort(map, order, result);
            } else {// 如果没有重复的value值，就可以直接用treeMap排序
                if (order == ORDER.DESC) {
                    for (Double key : treeMap.descendingKeySet()) {
                        result.add(treeMap.get(key));
                    }
                } else if (order == ORDER.ASC) {
                    for (Entry<Double, T> entry : treeMap.entrySet()) {
                        result.add(entry.getValue());
                    }
                }
            }
        } else {
            result = list;
        }
        if (result.size() > itemLimit) {
            result.subList(itemLimit, result.size()).clear();
        }

        return result;
    }

    /**
     * 冒泡排序，因为表项一般不会太多，效率不会有问题
     * 
     * @param map
     * @param order
     * @param result
     */
    private void bubbleSort(Map<T, Double> map, ORDER order, List<T> result) {
        while (map.size() > 0) {
            Double temp = null;
            T tempItem = null;
            for (Entry<T, Double> item : map.entrySet()) {
                Double data = item.getValue();
                temp = temp == null ? data : temp;
                if ((order == ORDER.DESC && data.doubleValue() >= temp.doubleValue())// NL
                        || // NL
                        (order == ORDER.ASC && data.doubleValue() <= temp.doubleValue())) {
                    temp = data;
                    tempItem = item.getKey();
                }
            }
            result.add(tempItem);
            map.remove(tempItem);
        }
    }

    /**
     * 对表格中的数据按行或按列算总数
     * 
     * @param isSumUpByColumn true表示按列汇总，false表示按行汇总
     * @param tableData
     * @return
     */
    protected ChartTableItem[] sumUp(boolean isSumUpByColumn, ChartTableItem[][] tableData) {
        int rowNum = tableData.length;
        if (rowNum == 0) {
            return new ChartTableItem[0];
        }
        int colNum = tableData[0].length;
        ChartTableItem[] result = null;
        if (isSumUpByColumn) {
            result = new ChartTableItem[colNum];
            for (int i = 0; i < colNum; i++) {
                double sum = 0;
                for (int j = 0; j < rowNum; j++) {
                    sum += tableData[j][i].getItemData().doubleValue();
                }
                result[i] = tableData[0][0].getInstance();
                result[i].setItemData(sum);
            }
        } else {
            result = new ChartTableItem[rowNum];
            for (int i = 0; i < rowNum; i++) {
                double sum = 0;
                for (int j = 0; j < colNum; j++) {
                    sum += tableData[i][j].getItemData().doubleValue();
                }
                result[i] = tableData[0][0].getInstance();
                result[i].setItemData(sum);
            }
        }
        return result;
    }

    /**
     * 根据表项列表（List<T> itemList），逐行查询数据
     * 
     * @param x
     * @param y
     * @param isShowItemByColumn
     * @param itemList
     * @param context
     * @return
     */
    protected ChartTableItem[][] getTableData(int x, int y, boolean isShowItemByColumn, List<T> itemList, Map<String, Object> context) {
        int colNum = y - 1;
        ChartTableItem[][] result = new ChartTableItem[x][colNum];
        if (isShowItemByColumn) {
            for (int i = 0; i < x; i++) {
                result[i] = getData(colNum, itemList.get(i), context);
            }
        } else {
            for (int i = 0; i < colNum; i++) {
                ChartTableItem[] temp = getData(x, itemList.get(i), context);
                for (int j = 0; j < x; j++) {// NOSONAR
                    result[j][i] = temp[j];// NOSONAR
                }// NOSONAR
            }
        }
        return result;
    }

    /**
     * 返回表格左上角上的文字
     * 
     * @return
     */
    protected String getCornerName(Map<String, Object> context) {
        return "";
    }

    /**
     * 返回除了表项外的另一个表格方向上的名字数组，常见的是时间日期
     * 
     * @param offset
     * @param colNum
     * @return
     */
    protected abstract String[] getSideNames(int tableSize, Map<String, Object> context);

    /**
     * 设置包含了表项信息的对象的列表
     * 
     * @param map
     * @return
     */
    protected abstract void setItemList(List<T> list, Map<String, Object> context);

    /**
     * 根据对象T中的信息，得到tableSize条查询结果，返回一个数组
     * 
     * @param offset
     * @param tableSize
     * @param obj
     * @return
     */
    protected abstract ChartTableItem[] getData(int tableSize, T obj, Map<String, Object> context);
}
