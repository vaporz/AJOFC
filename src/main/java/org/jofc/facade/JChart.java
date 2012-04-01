
package org.jofc.facade;

import net.sf.json.JSONString;

import org.jofc.attribute.ChartAttribute;
import org.jofc.attribute.Title;
import org.jofc.attribute.XAxis;
import org.jofc.attribute.XAxisLabel;
import org.jofc.attribute.XLegend;
import org.jofc.attribute.YAxis;
import org.jofc.attribute.YAxisLabel;
import org.jofc.attribute.YLegend;
import org.jofc.builder.JOFCBaseBuilder;
import org.jofc.itf.JOFCElement;
import org.jofc.itf.JOFCValue;
import org.jofc.util.JOFCUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class JChart implements JSONString {

    private int gridNum = 10;

    private boolean autoFitYaxis = true;

    // int chartNum = 0;

    /**
     * 设置图表属性，这些属性是对整个图标的某种控制，比如背景颜色之类的
     * 
     * @param ca
     */
    public void setChartAttribute(ChartAttribute ca) {
        getBuilder().setChartAttribute(ca);
    }

    /**
     * 得到图标属性对象
     * 
     * @return ChartAttribute
     */
    public ChartAttribute getChartAttribute() {
        return getBuilder().getChartAttribute();
    }

    /**
     * 设置小数位数
     * 
     * @param numDecimals
     */
    public ChartAttribute setNumDecimals(int numDecimals) {
        return getChartAttribute().setNumDecimals(numDecimals);
    }

    /**
     * 是否强制显示指定位数的小数
     * 
     * @return boolean
     */
    public boolean isFixedNumDecimalsForced() {
        return getChartAttribute().isFixedNumDecimalsForced();
    }

    /**
     * 设置是否强制显示指定位数的小数
     * 
     * @param isFixedNumDecimalsForced
     */
    public ChartAttribute setIsFixedNumDecimalsForced(boolean isFixedNumDecimalsForced) {
        return getChartAttribute().setIsFixedNumDecimalsForced(isFixedNumDecimalsForced);
    }

    /**
     * 是否使用逗号作为分隔
     * 
     * @return boolean
     */
    public boolean isDecimalSeparatorComma() {
        return getChartAttribute().isDecimalSeparatorComma();
    }

    /**
     * 设置是否使用逗号作为分隔
     * 
     * @param isDecimalSeparatorComma
     * @return ChartAttribute
     */
    public ChartAttribute setIsDecimalSeparatorComma(boolean isDecimalSeparatorComma) {
        return getChartAttribute().setIsDecimalSeparatorComma(isDecimalSeparatorComma);
    }

    /**
     * 是否使用千位的分割
     * 
     * @return boolean
     */
    public boolean isThousandSeparatorDisabled() {
        return getChartAttribute().isThousandSeparatorDisabled();
    }

    /**
     * 设置是否使用千位的分割
     * 
     * @param isThousandSeparatorDisabled
     * @return ChartAttribute
     */
    public ChartAttribute setIsThousandSeparatorDisabled(boolean isThousandSeparatorDisabled) {
        return getChartAttribute().setIsThousandSeparatorDisabled(isThousandSeparatorDisabled);
    }

    /**
     * 背景颜色
     * 
     * @return String
     */
    public String getBgColour() {
        return getChartAttribute().getBgColour();
    }

    /**
     * 设置背景颜色
     * 
     * @param colour
     * @return ChartAttribute
     */
    public ChartAttribute setBgColour(String colour) {
        return getChartAttribute().setBgColour(colour);
    }

    /**
     * 设置图表的标题，显示于图表上方
     * 
     * @param title
     */
    public void setTitle(String title) {
        getBuilder().setTitle(title);
    }

    /**
     * 设置图表的标题，显示于图表上方
     * 
     * @param title
     */
    public void setTitle(Title title) {
        getBuilder().setTitle(title);
    }

    /**
     * 设置X轴对象，包含了各种属性和样式设置
     * 
     * @param xAxis
     */
    public void setxAxis(XAxis xAxis) {
        getBuilder().setxAxis(xAxis);
    }

    /**
     * 返回显示X轴的坐标值时，间隔的单位数量
     * 
     * @return int
     */
    public int getXaxisLabelSteps() {
        return getxAxis().getLabelSteps();
    }

    /**
     * 显示X轴坐标值时，每steps个单位显示一个坐标值，如果为1，表示每个坐标值都显示
     * 
     * @param labelSteps
     */
    public void setXaxisLabelSteps(int labelSteps) {
        getxAxis().setLabelSteps(labelSteps);
    }

    /**
     * 返回X轴文字逆时针旋转的角度
     * 
     * @return int
     */
    public int getXaxisLabelRotate() {
        return getxAxis().getLabelRotate();
    }

    /**
     * 设置X轴文字逆时针旋转的角度
     * 
     * @param labelRotate
     */
    public void setXaxisLabelRotate(int labelRotate) {
        getxAxis().setLabelRotate(labelRotate);
    }

    /**
     * 返回X轴文字的颜色
     * 
     * @return String
     */
    public String getXaxisLabelColour() {
        return getxAxis().getLabelColour();
    }

    /**
     * 设置X轴文字的颜色
     * 
     * @param labelColour
     */
    public void setXaxisLabelColour(String labelColour) {
        getxAxis().setLabelColour(labelColour);
    }

    /**
     * 返回X轴文字的字号
     * 
     * @return int
     */
    public int getXaxisLabelSize() {
        return getxAxis().getLabelSize();
    }

    /**
     * 设置X轴文字的字号
     * 
     * @param labelSize
     */
    public void setXaxisLabelSize(int labelSize) {
        getxAxis().setLabelSize(labelSize);
    }

    /**
     * 返回X轴文字的对象列表，合法的对象类型包括String对象或者{@link XAxisLabel}对象
     * 
     * @return List
     */
    public List<Object> getXaxisLabelObjectList() {
        return getxAxis().getLabelObjectList();
    }

    /**
     * 返回X轴文字的字符串列表
     * 
     * @return List
     */
    public List<String> getXaxisLabelList() {
        List<String> result = new ArrayList<String>();
        List<Object> labels = getXaxisLabelObjectList();
        for (Object label : labels) {
            if (label == null) {
                result.add("null");
            } else if (label instanceof String) {
                result.add((String) label);
            } else if (label instanceof XAxisLabel) {
                result.add(((XAxisLabel) label).getText());
            } else {
                result.add("undefined");
            }
        }
        return result;
    }

    /**
     * 设置X坐标轴的标签的值，List中可以放置String类型或者{@link XAxisLabel} 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList X坐标轴的标签值
     * @see XAxisLabel
     */
    public void setXaxisLabelList(List<Object> labelList) {
        getxAxis().setLabelList(labelList);
    }

    /**
     * 设置X坐标轴的标签的值，List中可以放置String类型或者{@link XAxisLabel} 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList X坐标轴的标签值
     * @see XAxisLabel
     */
    public void setXaxisLabelList(Object... labelList) {
        getxAxis().setLabelList(labelList);
    }

    /**
     * 设置X坐标轴的标签的值，List中可以放置String类型或者{@link XAxisLabel} 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList X坐标轴的标签值
     * @see XAxisLabel
     */
    public void setXaxisLabelList(String... labelList) {
        getxAxis().setLabelList(labelList);
    }

    /**
     * 返回X坐标轴上突出来的刻度的长度，单位是像素
     * 
     * @return int
     */
    public int getXaxisTickHeight() {
        return getxAxis().getTickHeight();
    }

    /**
     * 设置X坐标轴上突出来的刻度的长度，单位是像素
     * 
     * @param tickHeight
     */
    public void setXaxisTickHeight(int tickHeight) {
        getxAxis().setTickHeight(tickHeight);
    }

    /**
     * 返回X坐标轴的厚度，单位是像素
     * 
     * @return int
     */
    public int getXaxisStroke() {
        return getxAxis().getStroke();
    }

    /**
     * 设置X坐标轴的厚度，单位是像素
     * 
     * @param stroke
     */
    public void setXaxisStroke(int stroke) {
        getxAxis().setStroke(stroke);
    }

    /**
     * 返回X坐标轴是否以坐标原点为起点，false表示向原点右侧偏移一些
     * 
     * @return boolean
     */
    public boolean isXaxisOffset() {
        return getxAxis().isOffset();
    }

    /**
     * 设置X坐标轴是否以坐标原点为起点，false表示向原点右侧偏移一些
     * 
     * @param offset
     */
    public void setXaxisOffset(boolean offset) {
        getxAxis().setOffset(offset);
    }

    /**
     * 返回X坐标轴的颜色，比如“#343434”
     * 
     * @return String
     */
    public String getXaxisColour() {
        return getxAxis().getColour();
    }

    /**
     * 设置X坐标轴的颜色，比如“#343434”
     * 
     * @param colour
     */
    public void setXaxisColour(String colour) {
        getxAxis().setColour(colour);
    }

    /**
     * 返回图表中竖线的颜色，比如“#343434”
     * 
     * @return String
     */
    public String getXaxisGridColour() {
        return getxAxis().getGridColour();
    }

    /**
     * 设置图表中竖线的颜色，比如“#343434”
     * 
     * @param gridColour
     */
    public void setXaxisGridColour(String gridColour) {
        getxAxis().setGridColour(gridColour);
    }

    /**
     * 返回显示X轴的竖线时，间隔的单位数量
     * 
     * @return int
     */
    public int getXaxisSteps() {
        return getxAxis().getSteps();
    }

    /**
     * 显示X轴的竖线时，每steps个单位显示一条竖线，如果为1，表示每条竖线都显示
     */
    public void setXaxisSteps(int steps) {
        getxAxis().setSteps(steps);
    }

    /**
     * 设置Y轴对象，包含了各种属性和样式设置
     * 
     * @param yAxis
     */
    public void setyAxis(YAxis yAxis) {
        getBuilder().setyAxis(yAxis);
    }

    /**
     * 返回Y轴下限
     * 
     * @return double
     */
    public double getYaxisMin() {
        return getyAxis().getMin();
    }

    /**
     * 设置Y轴上限，下限和间隔单位数，设置之后会禁用自动适应的功能
     * 
     * @param min
     */
    public void setYaxis(double min, double max, double steps) {
        getyAxis().setMin(min);
        getyAxis().setMax(max);
        getyAxis().setSteps(steps);
        this.disableAutoFitYaxis();
    }

    /**
     * 设置Y轴下限
     * 
     * @param min
     */
    public void setYaxisMin(double min) {
        getyAxis().setMin(min);
    }

    /**
     * 返回Y轴上限
     * 
     * @return double
     */
    public double getYaxisMax() {
        return getyAxis().getMax();
    }

    /**
     * 设置Y轴上限
     * 
     * @param max
     */
    public void setYaxisMax(double max) {
        getyAxis().setMax(max);
    }

    /**
     * 返回显示Y轴的横线时，间隔的单位数量
     * 
     * @return double
     */
    public double getYaxisSteps() {
        return getyAxis().getSteps();
    }

    /**
     * 设置显示Y轴的横线时，间隔的单位数量
     * 
     * @param steps
     */
    public void setYaxisSteps(double steps) {
        getyAxis().setSteps(steps);
    }

    /**
     * 返回Y轴的厚度，单位是像素
     * 
     * @return int
     */
    public int getYaxisStroke() {
        return getyAxis().getStroke();
    }

    /**
     * 设置Y轴的厚度，单位是像素
     * 
     * @param stroke
     */
    public void setYaxisStroke(int stroke) {
        getyAxis().setStroke(stroke);
    }

    /**
     * 返回Y轴的颜色，如"#A2ACBA"
     * 
     * @return String
     */
    public String getYaxisColour() {
        return getyAxis().getColour();
    }

    /**
     * 设置Y轴的颜色，如"#A2ACBA"
     * 
     * @param colour
     */
    public void setYaxisColour(String colour) {
        getyAxis().setColour(colour);
    }

    /**
     * 返回Y坐标轴上突起的刻度的长度，单位是像素
     * 
     * @return int
     */
    public int getYaxisTickLength() {
        return getyAxis().getTickLength();
    }

    /**
     * 设置Y坐标轴上突起的刻度的长度，单位是像素
     * 
     * @param tickLength
     */
    public void setYaxisTickLength(int tickLength) {
        getyAxis().setTickLength(tickLength);
    }

    /**
     * 返回Y轴横线的颜色，如"#A2ACBA"
     * 
     * @return String
     */
    public String getYaxisGridColour() {
        return getyAxis().getGridColour();
    }

    /**
     * 设置Y轴横线的颜色，如"#A2ACBA"
     * 
     * @param gridColour
     */
    public void setYaxisGridColour(String gridColour) {
        getyAxis().setGridColour(gridColour);
    }

    /**
     * 返回Y轴文字的对象列表，合法的对象类型包括String对象或者{@link YAxisLabel}对象
     * 
     * @return List
     */
    public List<Object> getYaxisLabelObjectList() {
        return getyAxis().getLabelObjectList();
    }

    /**
     * 返回Y轴文字的字符串列表
     * 
     * @return List
     */
    public List<String> getYaxisLabelList() {
        List<String> result = new ArrayList<String>();
        List<Object> labels = getYaxisLabelObjectList();
        for (Object label : labels) {
            if (label == null) {
                result.add("null");
            } else if (label instanceof String) {
                result.add((String) label);
            } else if (label instanceof YAxisLabel) {
                result.add(((YAxisLabel) label).getText());
            } else {
                result.add("undefined");
            }
        }
        return result;
    }

    /**
     * 设置Y坐标轴的标签的值，List中可以放置String对象，其他类型按照"undefined"字符串处理。<br>
     * 注意：使用这个方法时，标签值自动与Y轴的数字对应，分别对应整数的1，2...N
     * 
     * @param labelList X坐标轴的标签值
     * @see YAxisLabel
     */
    public void setYaxisLabelList(String... labelList) {
        getyAxis().setLabelList(labelList);
    }

    /**
     * 设置Y坐标轴的标签的值，List中可以放置{@link YAxisLabel}对象，其他类型按照"undefined"字符串处理。<br>
     * 注意：若使用这种方式设置Y轴标签，那么使用{@link #setYaxisLabelSteps(int)}会失效。
     * 
     * @param labelList X坐标轴的标签值
     * @see YAxisLabel
     */
    public void setYaxisLabelList(YAxisLabel... labelList) {
        getyAxis().setLabelList(labelList);
    }

    /**
     * 设置Y坐标轴的标签的值，List中可以放置String类型或者{@link YAxisLabel} 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList Y坐标轴的标签值
     * @see YAxisLabel
     */
    public void setYaxisLabelsList(List<Object> labelList) {
        getyAxis().setLabelsList(labelList);
    }

    /**
     * 返回显示Y轴的坐标值时，间隔的单位数量
     * 
     * @return int
     */
    public int getYaxisLabelSteps() {
        return getyAxis().getLabelSteps();
    }

    /**
     * 显示Y轴坐标值时，每steps个单位显示一个坐标值，如果为1，表示每个坐标值都显示
     * 
     * @param labelSteps
     */
    public void setYaxisLabelSteps(int labelSteps) {
        getyAxis().setLabelSteps(labelSteps);
    }

    /**
     * 设置X轴的标题
     * 
     * @param text
     */
    public void setxLegend(String text) {
        getxLegend().setText(text);
    }

    /**
     * 设置X轴的标题
     * 
     * @param xLegend
     */
    public void setxLegend(XLegend xLegend) {
        getBuilder().setxLegend(xLegend);
    }

    /**
     * 设置Y轴的标题
     * 
     * @param text
     */
    public void setyLegend(String text) {
        getyLegend().setText(text);
    }

    /**
     * 设置Y轴的标题
     * 
     * @param yLegend
     */
    public void setyLegend(YLegend yLegend) {
        getBuilder().setyLegend(yLegend);
    }

    /**
     * 返回标题对象
     * 
     * @return Title
     */
    public Title getTitle() {
        return getBuilder().getTitle();
    }

    /**
     * 返回X坐标轴对象
     * 
     * @return XAxis
     */
    public XAxis getxAxis() {
        return getBuilder().getxAxis();
    }

    /**
     * 返回Y坐标轴对象
     * 
     * @return YAxis
     */
    public YAxis getyAxis() {
        return getBuilder().getyAxis();
    }

    /**
     * 返回X轴标题对象
     * 
     * @return XLegend
     */
    public XLegend getxLegend() {
        return getBuilder().getxLegend();
    }

    /**
     * 返回Y轴标题对象
     * 
     * @return YLegend
     */
    public YLegend getyLegend() {
        return getBuilder().getyLegend();
    }

    /**
     * 设置X轴3D效果下的宽度
     * 
     * @param width
     */
    public void setXaxis3Dwidth(int width) {
        getxAxis().set3Dwidth(width);
    }

    @Override
    public String toString() {
        return getBuilder().toJSONString();
    }

    @Override
    public String toJSONString() {
        return getBuilder().toJSONString();
    }

    /**
     * 将Y轴自动分为多行，行数是gridNum，坐标原点的Y值设置为min，<br>
     * 本方法不支持小数，仅支持整数
     * 
     * @param gridNum
     * @param min
     */
    public void fitYaxis() {
        List<Double> values = this.getAllValueNumbers();
        double[] minAndMax = JOFCUtils.getMinAndMax(values);
        this.fitYaxis(null, minAndMax[0], minAndMax[1], JOFCUtils.getMaxPrecise(values));
    }

    /**
     * 将Y轴自动分为多行，行数是gridNum，坐标原点的Y值设置为min，<br>
     * gridNum如果为null，则根据y轴上坐标值的范围和数量级自动计算格数，最多分为10格<br>
     * 本方法不支持小数，仅支持整数
     * 
     * @param gridNum
     * @param min
     */
    public void fitYaxis(Integer gridNum) {
        List<Double> values = this.getAllValueNumbers();
        double[] minAndMax = JOFCUtils.getMinAndMax(values);
        this.fitYaxis(gridNum, minAndMax[0], minAndMax[1], JOFCUtils.getMaxPrecise(values));
    }

    /**
     * 将Y轴自动分为多行，行数是gridNum，坐标原点的Y值设置为min<br>
     * gridNum如果为null，则根据y轴上坐标值的范围和数量级自动计算格数，最多分为10格<br>
     * 本方法不支持小数，仅支持整数
     * 
     * @param gridNum
     * @param min
     */
    public void fitYaxis(Integer gridNum, double min) {
        List<Double> values = this.getAllValueNumbers();
        double[] minAndMax = JOFCUtils.getMinAndMax(values);
        this.fitYaxis(gridNum, min, minAndMax[1], JOFCUtils.getMaxPrecise(values));
    }

    /**
     * 将Y轴自动分为多行，行数是gridNum，坐标原点的Y值设置为min，使用的精度为precise，比如1(个位)的精度为0，100(百位 )的精度为2，0.001的精度为-3<br>
     * gridNum如果为null，则根据y轴上坐标值的范围和数量级自动计算格数，最多分为10格<br>
     * 计算最大数量级的方法（仅支持整数）：{@link JOFCUtils#getMaxPrecise(List)}<br>
     * 计算最小数量级的方法：{@link JOFCUtils#getMinPrecise(double[])}<br>
     * 
     * @param gridNum
     * @param min
     * @param precise
     */
    public void fitYaxis(Integer gridNum, double min, int precise) {
        List<Double> values = this.getAllValueNumbers();
        double[] minAndMax = JOFCUtils.getMinAndMax(values);
        this.fitYaxis(gridNum, min, minAndMax[1], precise);
    }

    /**
     * 将Y轴自动分为多行，行数是gridNum，坐标原点的Y值设置为min，Y值最大值不小于max，使用的精度为precise，比如1(个位)的精度为0，100(百位 )的精度为2，0.001的精度为-3<br>
     * gridNum如果为null，则根据y轴上坐标值的范围和数量级自动计算格数，最多分为10格<br>
     * 计算最大数量级的方法（仅支持整数）：{@link JOFCUtils#getMaxPrecise(List)}<br>
     * 计算最小数量级的方法：{@link JOFCUtils#getMinPrecise(double[])}<br>
     * 
     * @param newGridNum
     * @param min
     * @param max
     * @param precise
     */
    public void fitYaxis(Integer gridNum, double min, double max, int precise) {
        double newMin = min;
        Integer newGridNum = gridNum;
        double p = Math.pow(10, Math.abs(precise) - 1);
        double gap = Math.abs(max - newMin);
        if (newMin < 0) {
            newMin = newMin % p == 0 ? newMin : ((int) (newMin / p) - 1) * p;
        } else {
            newMin = newMin % p == 0 ? newMin : ((int) (newMin / p)) * p;
        }
        int devide = (gap / p % 1) == 0 ? (int) (gap / p) : (int) (gap / p) + 1;
        if (newGridNum == null) {// 自动计算格数，最多10格
            newGridNum = (int) (gap / p + (gap % p == 0 ? 0 : 1));
            newGridNum = newGridNum > 10 ? 10 : newGridNum;
        }
        max = (((int) (devide % newGridNum == 0 ? 0 : newGridNum - devide % newGridNum)) + devide) * p + newMin;
        double step = Math.abs(max - newMin) / newGridNum;

        this.setYaxisSteps(step);
        this.setYaxisMax(max);
        this.setYaxisMin(newMin);
        this.gridNum = newGridNum;
        disableAutoFitYaxis();
    }

    /**
     * 设置是否根据输入的数据自动适应Y轴
     * 
     * @param isenable
     */
    public void setAutoFitYaxis(boolean isenable) {
        this.autoFitYaxis = isenable;
    }

    /**
     * 停用Y轴的自动适应功能，使用默认设置或者用户指定的设置
     */
    public void disableAutoFitYaxis() {
        this.autoFitYaxis = false;
    }

    /**
     * 启用Y轴的自动适应功能
     */
    public void enableAutoFitYaxis() {
        this.autoFitYaxis = true;
    }

    /**
     * 返回是否启用了Y轴自动适应功能
     * 
     * @return boolean
     */
    public boolean isAutoFitYaxis() {
        return this.autoFitYaxis;
    }

    /**
     * 返回Y轴坐标的显示行数
     * 
     * @return int
     */
    public int getGridNum() {
        return gridNum;
    }

    /**
     * 设置Y轴坐标的显示行数
     * 
     * @param gridNum
     */
    public void setGridNum(int gridNum) {
        this.gridNum = gridNum;
    }

    /**
     * 将所有Element的数据都放到列表values中
     * 
     * @param values
     */
    public List<Double> getAllValueNumbers() {
        List<Double> values = new ArrayList<Double>();
        int elementCount = this.getCountElement();
        for (int index = 0; index < elementCount; index++) {
            List<Double> tempValues = this.getValueNumbers(index);
            values.addAll(tempValues);
        }
        return values;
    }

    public abstract JOFCBaseBuilder<? extends JOFCElement<? extends JOFCValue>, ? extends JOFCValue> getBuilder();

    /**
     * 返回JOFCElement对象的个数，在折线图中，表示同一个图表中折线的条数
     * 
     * @return int
     */
    public abstract int getCountElement();

    /**
     * 返回第index个Element的数据的列表，有些类型的图表中，这个方法可能没有意义
     * 
     * @param index
     * @return List
     */
    public abstract List<Double> getValueNumbers(int index);

    /**
     * 返回第0个Element的数据的列表，有些类型的图表中，这个方法可能没有意义
     * 
     * @return List
     */
    public abstract List<Double> getValueNumbers();

    /**
     * 返回图表数据中的最大值，比如在折线图中，应返回最高点对应的数值
     * 
     * @return double
     */
    public abstract double getTopValue();
}
