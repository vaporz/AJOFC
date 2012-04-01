
package org.jofc.facade;

import org.jofc.attribute.chart.LineChart;
import org.jofc.attribute.chart.element.LineDotStyle;
import org.jofc.attribute.chart.element.LineElement;
import org.jofc.attribute.chart.element.value.LineValue;
import org.jofc.builder.JOFCFactory;
import org.jofc.builder.LineBuilder;
import org.jofc.enums.Chart;
import org.jofc.enums.LineAnimates;
import org.jofc.itf.ChartTableItem;

import java.util.ArrayList;
import java.util.List;

/**
 * 折线图的用户接口类。<br>
 * 注意：坐标值的最高位有效数字的数量级不能低于1E-3，也就是0.0001，比如0.001是可以的，而0.0001会导致错误，23.0000001 也是可以的，因为最高为有效数字是2，数量级是10。
 * 
 * @author 张啸[zzxx513@gmail.com]
 */
public class JLineChart extends JChart {
    private LineBuilder lineBuilder;

    public JLineChart() {
        this.lineBuilder = (LineBuilder) JOFCFactory.getBuilder(Chart.LINE);// NOSONAR
    }

    /**
     * 返回{@link LineElement}对象的列表
     * 
     * @return List
     */
    public List<LineElement> getLineElements() {
        return lineBuilder.getElements();
    }

    /**
     * 追加一个{@link LineElement}对象
     * 
     * @param lineElement
     * @return
     */
    public JLineChart appendElement(LineElement lineElement) {
        lineBuilder.appendElement(lineElement);
        return this;
    }

    /**
     * 替换第index个{@link LineElement}对象
     * 
     * @param index
     * @param element
     * @return
     */
    public JLineChart setElement(int index, LineElement element) {
        lineBuilder.setElement(index, element);
        return this;
    }

    /**
     * 得到第index个{@link LineElement}对象
     * 
     * @param index
     * @return
     */
    public LineElement getElement(int index) {
        return lineBuilder.getElement(index);
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(Number[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(ChartTableItem[] values) {
        int length = values.length;
        if (values != null && length > 0) {
            Number[] numbers = new Number[length];
            for (int i = 0; i < length; i++) {
                numbers[i] = values[i].getItemData();
            }
            lineBuilder.appendValues(numbers);
        }
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(float[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(double[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(long[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(short[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(int[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(LineValue[] values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用列表中的数值添加一条折线
     * 
     * @param values
     * @return JLineChart
     */
    public JLineChart addLine(List<LineValue> values) {
        lineBuilder.appendValues(values);
        return this;
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, LineValue[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, List<LineValue> values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, Number[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, float[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, int[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, double[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, short[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的折线的数据
     * 
     * @param index
     * @param values
     */
    public void setLineValues(int index, long[] values) {
        lineBuilder.setValues(index, values);
    }

    /**
     * 返回指定编号折线的数值的列表
     * 
     * @return List
     */
    @Override
    public List<Double> getValueNumbers(int index) {
        List<LineValue> values = getValueObjects(index);
        List<Double> result = new ArrayList<Double>(values.size());
        for (LineValue value : values) {
            result.add(value.getValue());
        }
        return result;
    }

    /**
     * 返回第0条折线的数值的列表
     * 
     * @return List
     */
    @Override
    public List<Double> getValueNumbers() {
        return getValueNumbers(0);
    }

    /**
     * 返回第0条折线的数据对象的列表
     * 
     * @return List
     */
    public List<LineValue> getValueObjects() {
        return getValueObjects(0);
    }

    /**
     * 返回指定编号折线的数据对象的列表
     * 
     * @return List
     */
    public List<LineValue> getValueObjects(int index) {
        List<LineElement> elements = this.getLineElements();
        int size = elements.size();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements.get(index).getValues();
    }

    /**
     * 返回图中折线的条数
     * 
     * @return int
     */
    @Override
    public int getCountElement() {
        return lineBuilder.getCountElements();
    }

    /**
     * 返回折线最高点的数值
     * 
     * @return double
     */
    @Override
    public double getTopValue() {
        int elementCount = this.getCountElement();
        double top = this.getValueNumbers(0).get(0);
        for (int index = 0; index < elementCount; index++) {
            List<Double> values = this.getValueNumbers(index);
            for (Double value : values) {
                top = top > value ? top : value;
            }
        }
        return top;
    }

    /**
     * 返回折线最低点的数值
     * 
     * @return double
     */
    public double getBottomLineValue() {
        int elementCount = this.getCountElement();
        double bottom = this.getValueNumbers(0).get(0);
        for (int index = 0; index < elementCount; index++) {
            List<Double> values = this.getValueNumbers(index);
            for (Double value : values) {
                bottom = bottom < value ? bottom : value;
            }
        }
        return bottom;
    }

    /**
     * 返回{@link LineBuilder}对象
     * 
     * @return LineBuilder
     */
    @Override
    public LineBuilder getBuilder() {
        return lineBuilder;
    }

    /**
     * 启用折线样式
     */
    public void enableLineStyle() {
        lineBuilder.enableLineStyle();
    }

    /**
     * 启用第index条折线的折线样式
     * 
     * @param index 从0开始计数
     */
    public void enableLineStyle(int index) {
        lineBuilder.enableLineStyle(index);
    }

    /**
     * 启用坐标点样式
     */
    public void enableDotStyle() {
        lineBuilder.enableDotStyle();
    }

    /**
     * 启用第index条折线的坐标点样式
     * 
     * @param index 从0开始计数
     */
    public void enableDotStyle(int index) {
        lineBuilder.enableDotStyle(index);
    }

    public LineChart getjOFChart() {
        return lineBuilder.getjOFChart();
    }

    /**
     * 设置第index条折线的折线样式，只有“dash”样式，如果不使用折线样式，可以设为null或者停用折线样式
     * 
     * @param index 从0开始计数
     * @param styleType 字符串“dash”或者null
     */
    public void setLineStyle(int index, String styleType) {
        lineBuilder.setLineStyle(index, styleType);
    }

    /**
     * 启用折线样式时，显示的线段的长度，单位是像素
     * 
     * @param index 从0开始计数
     * @param pixel
     */
    public void setLineOn(int index, int pixel) {
        lineBuilder.setLineOn(index, pixel);
    }

    /**
     * 启用折线样式时，隐藏的线段的长度，单位是像素
     * 
     * @param index 从0开始计数
     * @param pixel
     */
    public void setLineOff(int index, int pixel) {
        lineBuilder.setLineOff(index, pixel);
    }

    /**
     * 对所有折线设置折线样式，只有“dash”样式，如果不使用折线样式，可以设为null或者停用折线样式
     * 
     * @param styleType 字符串“dash”或者null
     */
    public void setLineStyle(String styleType) {
        lineBuilder.setLineStyle(styleType);
    }

    /**
     * 启用折线样式时，显示的线段的长度，单位是像素，作用于所有折线
     * 
     * @param pixel
     */
    public void setLineOn(int pixel) {
        lineBuilder.setLineOn(pixel);
    }

    /**
     * 启用折线样式时，隐藏的线段的长度，单位是像素，作用于所有折线
     * 
     * @param pixel
     */
    public void setLineOff(int pixel) {
        lineBuilder.setLineOff(pixel);
    }

    /**
     * 对所有折线设置颜色，比如“#FFFFFF”
     * 
     * @param colour
     */
    public void setColour(String colour) {
        lineBuilder.setColour(colour);
    }

    /**
     * 设置第index条折线的颜色，比如“#FFFFFF”
     * 
     * @param index 从0开始计数
     * @param colour
     */
    public void setColour(int index, String colour) {
        lineBuilder.setColour(index, colour);
    }

    /**
     * 对所有折线设置图例的文本
     * 
     * @param text
     */
    public void setCutlineText(String text) {
        lineBuilder.setText(text);
    }

    /**
     * 设置第index条折线的图例文本
     * 
     * @param index
     * @param text
     */
    public void setCutlineText(int index, String text) {
        lineBuilder.setText(index, text);
    }

    /**
     * 对所有折线设置使用的动画效果类型
     * 
     * @param type
     */
    public void setLineAnimate(LineAnimates type) {
        lineBuilder.setLineAnimate(type);
    }

    /**
     * 设置第index条折线使用指定的动画效果
     * 
     * @param index
     * @param type
     */
    public void setLineAnimate(int index, LineAnimates type) {
        lineBuilder.setLineAnimate(index, type);
    }

    /**
     * 对所有折线设置动画效果的持续时间
     * 
     * @param cascade
     */
    public void setLineAnimateCascade(int cascade) {
        lineBuilder.setLineAnimateCascade(cascade);
    }

    /**
     * 设置第index条折线的动画效果的持续时间
     * 
     * @param index
     * @param cascade
     */
    public void setLineAnimateCascade(int index, int cascade) {
        lineBuilder.setLineAnimateCascade(index, cascade);
    }

    /**
     * 对所有折线设置动画效果的延迟时间
     * 
     * @param delay
     */
    public void setLineAnimateDelay(int delay) {
        lineBuilder.setLineAnimateDelay(delay);
    }

    /**
     * 设置第index条折线的动画效果的延迟时间
     * 
     * @param index
     * @param delay
     */
    public void setLineAnimateDelay(int index, int delay) {
        lineBuilder.setLineAnimateDelay(index, delay);
    }

    /**
     * 对所有折线设置动画效果类型，动画效果持续时间和延迟时间
     * 
     * @param type
     * @param cascade
     * @param delay
     */
    public void setLineAnimate(LineAnimates type, int cascade, int delay) {
        lineBuilder.setLineAnimate(type, cascade, delay);
    }

    /**
     * 设置第index条折线的动画效果类型，动画效果持续时间和延迟时间
     * 
     * @param index
     * @param type
     * @param cascade
     * @param delay
     */
    public void setLineAnimate(int index, LineAnimates type, int cascade, int delay) {
        lineBuilder.setLineAnimate(index, type, cascade, delay);
    }

    /**
     * 设置所有折线上的点的样式
     * 
     * @param dotStyle
     */
    public void setDotStyle(LineDotStyle dotStyle) {
        lineBuilder.setDotStyle(dotStyle);
    }

    /**
     * 设置第index条折线上的点的样式
     * 
     * @param index
     * @param dotStyle
     */
    public void setDotStyle(int index, LineDotStyle dotStyle) {
        lineBuilder.setDotStyle(index, dotStyle);
    }

    /**
     * 设置提示文字，可用的变量有#x_label#，#val#，#x#，#y#<br>
     * #x_label#：x轴上的文字<br>
     * #val#：y轴的文字<br>
     * #x#：x轴坐标值，如0，1，2，3...<br>
     * #y#：y轴坐标值<br>
     * 更多内容：http://teethgrinder.co.uk/open-flash-chart-2/x-axis-date.php
     * 
     * @param tip
     */
    public void setToolTip(String tip) {
        lineBuilder.setToolTip(tip);
    }

    /**
     * 对第index条折线设置提示文字，可用的变量有#x_label#，#val#，#x#，#y#<br>
     * #x_label#：x轴上的文字<br>
     * #val#：y轴的文字<br>
     * #x#：x轴坐标值，如0，1，2，3...<br>
     * #y#：y轴坐标值<br>
     * 更多内容：http://teethgrinder.co.uk/open-flash-chart-2/x-axis-date.php
     * 
     * @param index
     * @param tip
     */
    public void setToolTip(int index, String tip) {
        lineBuilder.setToolTip(index, tip);
    }
    
    /**
     * 设置所有折线的宽度，单位是像素
     * 
     * @param dotStyle
     */
    public void setLineWidth(int width) {
        lineBuilder.setLineWidth(width);
    }

    /**
     * 设置第index条折线的宽度，单位是像素
     * 
     * @param index
     * @param dotStyle
     */
    public void setLineWidth(int index, int width) {
        lineBuilder.setLineWidth(index, width);
    }

    @Override
    public String toString() {
        if (isAutoFitYaxis()) {
            this.fitYaxis();
        }
        return super.toString();
    }

    @Override
    public String toJSONString() {
        return this.toString();
    }
}
