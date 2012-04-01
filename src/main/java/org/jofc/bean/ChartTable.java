
package org.jofc.bean;

import org.apache.commons.lang.StringUtils;
import org.jofc.attribute.chart.element.value.PieValue;
import org.jofc.enums.Chart;
import org.jofc.enums.PieAnimates;
import org.jofc.facade.JChart;
import org.jofc.facade.JLineChart;
import org.jofc.facade.JPieChart;
import org.jofc.itf.ChartTableItem;
import org.jofc.util.JOFCUtils;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 每个页面对应一个ChartTable对象，页面通过这个对象展示内容<br>
 * 实现了序列化接口，以备以后需要。将来如果需要缓存页面内容，缓存ChartTable对象即可。
 * 
 * @author 张啸 (zhangxiao@xiaomi.com):
 * @version 创建时间：2011-6-9 下午02:40:19
 */
public class ChartTable implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String title = "";// 页面标题
    private int colNum = 0;// 表格列数
    private int rowNum = 0;// 除表头外，表格其他行的行数，也就是总行数减一
    private String[] colNames = {};// 表头列名
    private ChartTableItem[][] tableData = {};// 表格数据
    private String[] rowNames = {};// 表格行的行名
    private boolean showChart = true;// 是否显示图
    private boolean showTable = true;// 是否显示表
    private boolean reverseChart = false;// 将图形左右翻转
    private Chart chartType = Chart.LINE;// 图表类型，默认是折线图
    private boolean isShowChartByColumn = true;// 按组取数据绘图时，按行取还是按列取
    private ChartTableItem[] sumData = {};// 合计数据
    private long timeCost = 0;// 查询耗时（单位：ms）
    private int pieSliceNum;// 饼图的块数
    private int legendNum = -1;// 图例的个数，-1表示全部都显示
    private int pieRadius = 180;// 饼图的半径，单位是像素
    private int maxLineNum = 50;// 折线最大数量
    private String cacheColNames = null;
    private String cacheRowNames = null;
    private String cacheTableData = null;
    private String cacheTableDataHints = null;
    private String cacheSumData = null;

    /**
     * 得到折线图中折线最大数量
     * 
     * @return
     */
    public int getMaxLineNum() {
        return maxLineNum;
    }

    /**
     * 设置折线图中折线最大数量
     * 
     * @param maxLineNum
     */
    public void setMaxLineNum(int maxLineNum) {
        this.maxLineNum = maxLineNum;
    }

    /**
     * 返回饼图的半径，单位是像素，默认值是180
     * 
     * @return
     */
    public int getPieRadius() {
        return pieRadius;
    }

    /**
     * 设置饼图的半径，单位是像素
     * 
     * @param pieRadius
     */
    public void setPieRadius(int pieRadius) {
        this.pieRadius = pieRadius;
    }

    /**
     * 返回显示图例的个数，-1表示全部都显示
     * 
     * @return
     */
    public int getLegendNum() {
        return legendNum;
    }

    /**
     * 设置显示图例的个数，-1表示全部都显示
     * 
     * @param legendNum
     */
    public void setLegendNum(int legendNum) {
        this.legendNum = legendNum;
    }

    public int getPieSliceNum() {
        return pieSliceNum;
    }

    public void setPieSliceNum(int pieSliceNum) {
        this.pieSliceNum = pieSliceNum;
    }

    private static String[] colors = {
        "#FF359A", "#0080FF", "#B9B973", "#8e236b", "#006400", "#ff0000", "#0000ff", "#ff00ff", "#ff7f50", "#00ffff", "#CC66FF", "#FF66FF",
        "#5E005E", "#006030", "#844200", "#484891", "#3A006F", "#007500", "#A23400", "#6C3365", "#7D7DFF", "#82D900", "#808040", "#820041",
        "#003E3E", "#C6A300", "#336666", "#984B4B", "#EA0000", "#000000", "#000079", "#467500", "#613030", "#4D0000", "#003D79", "#424200",
        "#00CACA", "#81C0C0", "#FF00FF", "#02F78E", "#FF9224", "#A6A6D2", "#9F35FF", "#B766AD", "#8c7853", "#000000", "#a52a2a", "#b22222",
        "#8B2500", "#838B8B", "#68228B", "#292929", "#CC0033", "#FF6600", "#99FF66", "#bddd22", "#3b2e7e", "#003371", "#ffb3a7", "#ed5736",
        "#a98175", "#9b4400", "#100000", "#6666FF", "#33FF00", "#CC0000"
    };

    public boolean isShowChartByColumn() {
        return isShowChartByColumn;
    }

    public void setShowChartByColumn(boolean isShowChartByColumn) {
        this.isShowChartByColumn = isShowChartByColumn;
    }

    public Chart getChartType() {
        return chartType;
    }

    public ChartTable setChartType(Chart chartType) {
        this.chartType = chartType;
        return this;
    }

    public ChartTable setReverseChart(boolean reverseChart) {
        this.reverseChart = reverseChart;
        return this;
    }

    public boolean isShowChart() {
        return showChart;
    }

    public ChartTable setShowChart(boolean showChart) {
        this.showChart = showChart;
        return this;
    }

    public boolean isShowTable() {
        return showTable;
    }

    public ChartTable setShowTable(boolean showTable) {
        this.showTable = showTable;
        return this;
    }

    public String getChartJson() {
        return chartJson;
    }

    public String generateChartJson(JChart chart) {
        if (chartType.value == Chart.LINE.value) {
            chartJson = getLineChartJson((JLineChart) chart);
        } else if (chartType.value == Chart.PIE.value) {
            chartJson = getPieChartJson((JPieChart) chart);
        }

        return chartJson;
    }

    private String chartJson = "";

    private String getLineChartJson(JLineChart chart) {// NOSONAR
        if (tableData.length == 0) {
            return "";
        }
        String result = "";
        int colorsNum = colors.length;
        boolean findData = false;
        JLineChart line = null;
        if (chart == null) {
            line = new JLineChart();
        } else {
            line = chart;
        }
        if (isShowChartByColumn) {
            for (int i = 0; i < colNum - 1 && i < maxLineNum; i++) {
                if (reverseChart) {
                    ChartTableItem[] temp = new ChartTableItem[rowNum];
                    for (int j = 0; j < rowNum; j++) {
                        temp[rowNum - 1 - j] = tableData[j][i];
                    }
                    line.addLine(temp);
                } else {
                    ChartTableItem[] temp = new ChartTableItem[rowNum];
                    for (int j = 0; j < rowNum; j++) {
                        temp[j] = tableData[j][i];
                    }
                    line.addLine(temp);
                }
                findData = true;
            }
        } else {
            for (int i = 0; i < tableData.length && i < maxLineNum; i++) {
                if (tableData[i].length > 0) {
                    if (reverseChart) {
                        ChartTableItem[] temp = new ChartTableItem[colNum - 1];
                        for (int j = 0; j < colNum - 1; j++) {
                            temp[colNum - 2 - j] = tableData[i][j];
                        }
                        line.addLine(temp);
                    } else {
                        line.addLine(tableData[i]);
                    }
                    findData = true;
                }
            }
        }
        if (findData) {
            // 设置x轴
            String[] xLabels = new String[colNum - 1];
            for (int i = 0; i < colNum - 1; i++) {
                if (reverseChart) {
                    xLabels[i] = colNames[colNum - 1 - i];
                } else {
                    xLabels[i] = colNames[i + 1];
                }
            }
            line.setXaxisLabelList(xLabels);
            // 设置图例，颜色和提示文字
            for (int i = 0; i < rowNum && i < maxLineNum; i++) {
                if (legendNum == -1 || i < legendNum) {
                    line.setCutlineText(i, rowNames[i]);
                }
                line.setColour(i, colors[i % colorsNum]);
                line.setToolTip(i, rowNames[i] + "\n#x_label#\n#val#");
            }
            line.setXaxisOffset(false);
            line.setAutoFitYaxis(false);
            line.fitYaxis(10, 0, JOFCUtils.getMaxPrecise(line.getAllValueNumbers()));
            result = line.toString();
        }
        return result;
    }

    private String getPieChartJson(JPieChart chart) {// NOSONAR
        if (tableData.length == 0) {
            return "";
        }
        int sliceNum = pieSliceNum == 0 ? 10 : pieSliceNum;
        int colorsNum = colors.length;
        JPieChart pie = null;
        if (chart == null) {
            pie = new JPieChart();
        } else {
            pie = chart;
        }
        pie.addAnimate(PieAnimates.FADE);
        pie.setColours(Arrays.asList(colors));
        pie.setRadius(pieRadius);
        pie.setStartAngle(-90);
        pie.setBgColour("#FFFFF0");
        pie.setTip("#label#\n#val# of #total#\n#percent#");
        int num = colNum - 1 > sliceNum ? sliceNum : colNum - 1;
        if (isShowChartByColumn) {
            num = rowNum > sliceNum ? sliceNum : rowNum;
        }
        PieValue[] values = new PieValue[num];
        if (isShowChartByColumn) {
            for (int i = 0; i < rowNum; i++) {
                if (i < num - 1) {
                    values[i] = new PieValue(tableData[i].length == 0 ? 0 : tableData[i][0].getItemData().doubleValue());
                    values[i].setColour(colors[i % colorsNum]);
                    values[i].setFontSize(13);
                    values[i].setLabel(rowNames[i]);
                } else {
                    if (i == num - 1) {
                        values[num - 1] = new PieValue(0);
                        values[num - 1].setFontSize(13);
                    }
                    values[num - 1].setColour(colors[(num - 1) % colorsNum]);
                    values[num - 1].setLabel(num == rowNum ? rowNames[i] : "其他");
                    values[num - 1].setValue(values[num - 1].getValue()
                            + (tableData[i].length == 0 ? 0 : tableData[i][0].getItemData().doubleValue()));
                }
            }
        } else {
            for (int i = 0; i < colNum - 1; i++) {
                if (i < num - 1) {
                    values[i] = new PieValue(tableData[0].length == 0 ? 0 : tableData[0][i].getItemData().doubleValue());
                    values[i].setColour(colors[i % colorsNum]);
                    values[i].setFontSize(13);
                    values[i].setLabel(colNames[i + 1]);
                } else {
                    if (i == num - 1) {
                        values[num - 1] = new PieValue(0);
                        values[num - 1].setFontSize(13);
                    }
                    values[num - 1].setColour(colors[(num - 1) % colorsNum]);
                    values[num - 1].setLabel(num == colNum - 1 ? colNames[i + 1] : "其他");
                    values[num - 1].setValue(values[num - 1].getValue()
                            + (tableData[0].length == 0 ? 0 : tableData[0][i].getItemData().doubleValue()));
                }
            }
        }
        pie.setValues(values);
        return pie.toJSONString();
    }

    /**
     * 按csv文件格式返回表格，可以用于将数据导出到excell表格之类的需要<br>
     * 
     * @return
     */
    public String[] getCsvString() {
        String[] result = new String[rowNum + 1];
        int length = colNames.length;
        String head = colNames[0];
        for (int i = 1; i < length; i++) {
            head += "," + colNames[i];
        }
        result[0] = head;
        length = tableData.length;
        for (int i = 0; i < length; i++) {
            int size = tableData[i].length;
            String str = rowNames[i];
            for (int j = 0; j < size; j++) {
                str += "," + StringUtils.defaultString(tableData[i][j].getItemData() == null ? "" : "" + tableData[i][j].getItemData())
                        + StringUtils.defaultString(tableData[i][j].getItemHint() == null ? "" : "-" + tableData[i][j].getItemHint());
            }
            result[i + 1] = str;
        }
        return result.clone();
    }

    /**
     * 按二维数组格式返回表格，可以用于将数据导出到excell表格之类的需要<br>
     * 
     * @return
     */
    public String[][] getTableString() {
        String[][] result = new String[rowNum + 1][colNum];
        System.arraycopy(colNames, 0, result[0], 0, colNames.length);
        int length = tableData.length;
        for (int i = 0; i < length; i++) {
            int size = tableData[i].length;
            result[i + 1][0] = rowNames[i];
            for (int j = 0; j < size; j++) {
                result[i + 1][j + 1] = ""
                        + StringUtils.defaultString(tableData[i][j].getItemData() == null ? "" : "" + tableData[i][j].getItemData())
                        + StringUtils.defaultString(tableData[i][j].getItemHint() == null ? "" : "-" + tableData[i][j].getItemHint());
            }
        }
        return result.clone();
    }

    public String getTitle() {
        return title;
    }

    public ChartTable setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getColNum() {
        return colNum;
    }

    public ChartTable setColNum(int colNum) {
        this.colNum = colNum;
        return this;
    }

    public int getRowNum() {
        return rowNum;
    }

    public ChartTable setRowNum(int rowNum) {
        this.rowNum = rowNum;
        return this;
    }

    public String[] getOriginalColNames() {
        return colNames.clone();
    }

    public ChartTable setColNames(String cornerName, String[] colNames) {
        int size = colNames.length;
        String[] temp = new String[size + 1];
        temp[0] = cornerName;
        System.arraycopy(colNames, 0, temp, 1, size);
        this.colNames = temp;
        return this;
    }

    public String getColNames() {
        if (cacheColNames == null) {
            cacheColNames = JOFCUtils.getJsArray(colNames);
        }
        return cacheColNames;
    }

    public ChartTableItem[][] getOriginalTableData() {
        return tableData.clone();
    }

    public ChartTable setTableData(ChartTableItem[][] tableData) {
        this.tableData = tableData.clone();
        return this;
    }

    public String getTableDataHints() {
        if (cacheTableDataHints == null) {
            String[][] hints = new String[rowNum][colNum - 1];
            for (int row = 0; row < rowNum; row++) {
                for (int col = 0; col < colNum - 1; col++) {
                    hints[row][col] = tableData[row][col].getItemHint();
                }
            }
            cacheTableDataHints = JOFCUtils.getJsArray(hints);
        }
        return cacheTableDataHints;
    }

    public String getTableData() {
        if (cacheTableData == null) {
            Number[][] data = new Number[rowNum][colNum - 1];
            for (int row = 0; row < rowNum; row++) {
                for (int col = 0; col < colNum - 1; col++) {
                    data[row][col] = tableData[row][col].getItemData();
                }
            }
            cacheTableData = JOFCUtils.getJsArray(data);
        }
        return cacheTableData;
    }

    public String[] getOriginalRowNames() {
        return rowNames.clone();
    }

    public ChartTable setRowNames(String[] rowNames) {
        this.rowNames = rowNames.clone();
        return this;
    }

    public String getRowNames() {
        if (cacheRowNames == null) {
            cacheRowNames = JOFCUtils.getJsArray(rowNames);
        }
        return cacheRowNames;
    }

    public String getSumData() {
        if (cacheSumData == null) {
            int length = sumData.length;
            Number[] data = new Number[length];
            for (int i = 0; i < length; i++) {
                data[i] = sumData[i].getItemData();
            }
            cacheSumData = JOFCUtils.getJsArray(data);
        }
        return cacheSumData;
    }

    public ChartTable setSumData(ChartTableItem[] sumData) {
        this.sumData = sumData.clone();
        return this;
    }

    public long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(long timeCost) {
        this.timeCost = timeCost;
    }
}
