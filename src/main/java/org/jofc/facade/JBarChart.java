
package org.jofc.facade;

import org.jofc.attribute.chart.element.BarElement;
import org.jofc.attribute.chart.element.value.BarValue;
import org.jofc.builder.BarBuilder;
import org.jofc.builder.JOFCBaseBuilder;
import org.jofc.builder.JOFCFactory;
import org.jofc.enums.BarAnimates;
import org.jofc.enums.BarType;
import org.jofc.enums.Chart;
import org.jofc.itf.JOFCElement;
import org.jofc.itf.JOFCValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 柱状图的用户接口类
 * 
 * @author 张啸[zzxx513@gmail.com]
 */
public class JBarChart extends JChart {
    private BarBuilder barBuilder;

    public JBarChart() {
        this.barBuilder = (BarBuilder) JOFCFactory.getBuilder(Chart.BAR);// NOSONAR
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(Number[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(float[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(double[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(long[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(short[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(int[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用数组中的数据添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(BarValue[] values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 使用列表中的数值添加一组柱状图
     * 
     * @param values
     * @return JBarChart
     */
    public JBarChart addBars(List<BarValue> values) {
        barBuilder.appendValues(values);
        return this;
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, BarValue[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, List<BarValue> values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, Number[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, float[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, int[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, double[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, short[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 重新设置指定编号的柱状图的数据
     * 
     * @param index
     * @param values
     */
    public void setBarValues(int index, long[] values) {
        barBuilder.setValues(index, values);
    }

    /**
     * 对所有柱状图设置图例文字的大小，默认值是12，单位为像素
     * 
     * @param fontsize
     */
    public void setCutlineFontSize(int fontsize) {
        barBuilder.setCutlineFontSize(fontsize);
    }

    /**
     * 对指定编号的柱状图设置图例文字的大小，默认值是12，单位为像素
     * 
     * @param index
     * @param fontsize
     */
    public void setCutlineFontSize(int index, int fontsize) {
        barBuilder.setCutlineFontSize(index, fontsize);
    }

    /**
     * 对所有柱状图设置柱状图的填充颜色，比如“#FFFFFF”
     * 
     * @param colour
     */
    public void setBarsColour(String colour) {
        barBuilder.setBarsColour(colour);
    }

    /**
     * 设置第index个柱状图的填充颜色，比如“#FFFFFF”
     * 
     * @param index
     * @param colour
     */
    public void setBarsColour(int index, String colour) {
        barBuilder.setBarsColour(index, colour);
    }

    /**
     * 对所有柱状图设置柱状图的描边颜色，比如“#FFFFFF”
     * 
     * @param colour
     */
    public void setBarsOutlineColour(String colour) {
        barBuilder.setBarsOutlineColour(colour);
    }

    /**
     * 对所有柱状图设置柱状图的描边颜色，比如“#FFFFFF”
     * 
     * @param colour
     */
    public void setBarsOutlineColour(int index, String colour) {
        barBuilder.setBarsOutlineColour(index, colour);
    }

    /**
     * 对所有柱状图设置感观
     * 
     * @param barType
     */
    public void setBarType(BarType barType) {
        barBuilder.setBarType(barType);
    }

    /**
     * 设置第index组柱状图的感观
     * 
     * @param index
     * @param barType
     */
    public void setBarType(int index, BarType barType) {
        barBuilder.setBarType(index, barType);
    }

    @Override
    public List<Double> getValueNumbers(int index) {
        List<BarValue> values = getValueObjects(index);
        List<Double> result = new ArrayList<Double>(values.size());
        for (BarValue value : values) {
            result.add(value.getValue());
        }
        return result;
    }

    @Override
    public List<Double> getValueNumbers() {
        return getValueNumbers(0);
    }

    /**
     * 返回第0组柱状图的数据对象的列表
     * 
     * @return List
     */
    public List<BarValue> getValueObjects() {
        return getValueObjects(0);
    }

    /**
     * 返回指定编号柱状图的数据对象的列表
     * 
     * @return List
     */
    public List<BarValue> getValueObjects(int index) {
        List<BarElement> elements = this.getBarElements();
        int size = elements.size();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements.get(index).getValues();
    }

    /**
     * 返回图中柱状图的组数
     * 
     * @return int
     */
    @Override
    public int getCountElement() {
        return this.getBarElements().size();
    }

    /**
     * 返回{@link BarElement}对象的列表
     * 
     * @return List
     */
    public List<BarElement> getBarElements() {
        return barBuilder.getElements();
    }

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
     * 返回柱状图数据中最小值
     * 
     * @return double
     */
    public double getBottomBarValue() {
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
     * 对所有柱状图设置图例的文本
     * 
     * @param text
     */
    public void setCutlineText(String text) {
        barBuilder.setCutlineText(text);
    }

    /**
     * 设置第index组柱状图的图例文本
     * 
     * @param index
     * @param text
     */
    public void setCutlineText(int index, String text) {
        barBuilder.setCutlineText(index, text);
    }

    /**
     * 对所有柱状图设置使用的动画效果类型
     * 
     * @param type
     */
    public void setBarAnimate(BarAnimates type) {
        barBuilder.setBarAnimate(type);
    }

    /**
     * 设置第index组柱状图使用指定的动画效果
     * 
     * @param index
     * @param type
     */
    public void setBarAnimate(int index, BarAnimates type) {
        barBuilder.setBarAnimate(index, type);
    }

    /**
     * 对所有柱状图设置动画效果的持续时间
     * 
     * @param cascade
     */
    public void setBarAnimateCascade(int cascade) {
        barBuilder.setBarAnimateCascade(cascade);
    }

    /**
     * 设置第index组柱状图的动画效果的持续时间
     * 
     * @param index
     * @param cascade
     */
    public void setBarAnimateCascade(int index, int cascade) {
        barBuilder.setBarAnimateCascade(index, cascade);
    }

    /**
     * 对所有柱状图设置动画效果的延迟时间
     * 
     * @param delay
     */
    public void setBarAnimateDelay(int delay) {
        barBuilder.setBarAnimateDelay(delay);
    }

    /**
     * 设置第index组柱状图的动画效果的延迟时间
     * 
     * @param index
     * @param delay
     */
    public void setBarAnimateDelay(int index, int delay) {
        barBuilder.setBarAnimateDelay(index, delay);
    }

    /**
     * 对所有柱状图设置动画效果类型，动画效果持续时间和延迟时间
     * 
     * @param type
     * @param cascade
     * @param delay
     */
    public void setBarAnimate(BarAnimates type, int cascade, int delay) {
        barBuilder.setBarAnimate(type, cascade, delay);
    }

    /**
     * 设置第index组柱状图的动画效果类型，动画效果持续时间和延迟时间
     * 
     * @param index
     * @param type
     * @param cascade
     * @param delay
     */
    public void setBarAnimate(int index, BarAnimates type, int cascade, int delay) {
        barBuilder.setBarAnimate(index, type, cascade, delay);
    }

    @Override
    public String toString() {
        if (isAutoFitYaxis()) {
            this.fitYaxis(getGridNum());
        }
        return super.toString();
    }

    @Override
    public JOFCBaseBuilder<? extends JOFCElement<? extends JOFCValue>, ? extends JOFCValue> getBuilder() {
        return barBuilder;
    }
}
