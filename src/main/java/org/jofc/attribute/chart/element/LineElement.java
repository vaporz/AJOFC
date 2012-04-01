
package org.jofc.attribute.chart.element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jofc.attribute.chart.LineChart;
import org.jofc.attribute.chart.element.value.LineValue;
import org.jofc.enums.LineDotType;
import org.jofc.exception.TypeMismatchException;
import org.jofc.itf.JOFCElement;
import org.jofc.util.JOFCUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一个{@link LineChart}可能由多个{@link LineElement}组成，每个{@link LineElement} 代表了一条曲线， 如果图表中需要展示多条图线，就实例化多个{@link LineElement}
 * 对象并设置到{@link LineChart} 对象中。
 * 
 * @author 张啸[xiao.zhang@opi-corp.com]
 */
public class LineElement implements JOFCElement<LineValue>, Serializable {

    // private static final Log logger = LogFactory.getLog(LineElement.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String type;

    private List<LineValue> values = new ArrayList<LineValue>();

    private LineDotStyle dotStyle = new LineDotStyle();// dot-style

    private int width;

    private String colour;

    private boolean enableDotStyle = true;

    private boolean enableLineStyle = false;

    private String lineStyle = "dash";// line-style:style

    private int lineOn = 4;// line-style:on

    private int lineOff = 3;// line-style:off

    private String text;

    private String onshowType;// type

    private double onshowCascade = 1;// cascade

    private double onshowDelay;// delay

    /**
     * 默认构造方法，初始化了一条Y值从0到9，有10个数值的线图
     * 
     * @throws TypeMismatchException
     */
    public LineElement() {
        type = "line";
        Integer[] values = new Integer[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i].doubleValue());
        }
        this.values = Arrays.asList(lineValues);
    }

    public LineElement(List<LineValue> values) {
        type = "line";
        this.values = values;
    }

    /**
     * 返回坐标点的基本样式，比如实心点，空心点等等
     * 
     * @return {@link LineDotType} 枚举类型
     */
    public LineDotType getDotType() {
        return dotStyle.getDotType();
    }

    /**
     * 设置坐标点的基本样式，比如实心点，空心点等等
     * 
     * @param dotType {@link LineDotType} 枚举类型
     */
    public void setDotType(LineDotType dotType) {
        dotStyle.setDotType(dotType);
    }

    /**
     * 返回坐标点的大小，单位是像素
     * 
     * @return int
     */
    public int getDotSize() {
        return dotStyle.getDotSize();
    }

    /**
     * 设置坐标点的大小，单位是像素
     * 
     * @param dotSize
     */
    public void setDotSze(int dotSize) {
        dotStyle.setDotSize(dotSize);
    }

    /**
     * 返回坐标点占用的面积的大小，单位是像素，如果Halo_size大于Dot_size，多出来的部分会补白(直译是光圈，不好理解， 自己试试就知道干什么用的了)
     * 
     * @return
     */
    public int getDotHaloSize() {
        return dotStyle.getHaloSize();
    }

    /**
     * 设置 坐标点占用的面积的大小，单位是像素，如果Halo_size大于Dot_size，多出来的部分会补白(直译是光圈，不好理解， 自己试试就知道干什么用的了)
     * 
     * @param haloSize
     */
    public void setDotHaloSize(int haloSize) {
        dotStyle.setHaloSize(haloSize);
    }

    /**
     * 返回坐标点的颜色
     * 
     * @return
     */
    public String getDotColour() {
        return dotStyle.getColour();
    }

    /**
     * 设置坐标点的颜色
     * 
     * @param colour
     */
    public void setDotColour(String colour) {
        dotStyle.setColour(colour);
    }

    /**
     * 返回类型
     * 
     * @return String
     */
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 返回数据的List，LineValue对象的type属性如果是null，那这一项就只是个普通数字
     * 
     * @return List<LineValue>
     */
    public List<LineValue> getValues() {
        return values;
    }

    /**
     * 返回曲线的宽度，单位是像素
     * 
     * @return int
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置曲线的宽度，单位是像素
     * 
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 返回曲线的颜色，比如“#FFFFFF”
     * 
     * @return String
     */
    public String getColour() {
        return colour;
    }

    /**
     * 设置曲线的颜色，比如“#FFFFFF”
     * 
     * @param colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    public void setValues(Number[] jOFCValues) {
        LineValue[] lineValues = new LineValue[jOFCValues.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(jOFCValues[i].doubleValue());
        }
        this.setValues(lineValues);
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    public void setValues(LineValue[] jOFCValues) {
        this.setValues(Arrays.asList(jOFCValues));
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    @Override
    public void setValues(List<LineValue> jOFCValues) {
        values = jOFCValues;
    }

    /**
     * 返回json字符串
     * 
     * @see #toJSONString()
     */
    @Override
    public String toString() {
        return this.toJSONString();
    }

    /**
     * 返回折线样式是否生效
     * 
     * @return boolean
     */
    public boolean isEnableLineStyle() {
        return enableLineStyle;
    }

    /**
     * 设置是否使用折线样式
     * 
     * @param enableLineStyle
     */
    public void setEnableLineStyle(boolean enableLineStyle) {
        this.enableLineStyle = enableLineStyle;
    }

    /**
     * 使用折线样式
     */
    public void enableLineStyle() {
        this.enableLineStyle = true;
    }

    /**
     * 不使用折线样式
     */
    public void disableLineStyle() {
        this.enableLineStyle = false;
    }

    /**
     * 返回现在使用的折线样式
     * 
     * @return String
     */
    public String getLineStyle() {
        return lineStyle;
    }

    /**
     * 设置折线样式
     * 
     * @param lineStyle
     */
    public void setLineStyle(String lineStyle) {
        this.lineStyle = lineStyle;
    }

    /**
     * 返回显示的折线段的长度
     * 
     * @return int
     */
    public int getLineOn() {
        return lineOn;
    }

    /**
     * 设置显示的折线段的长度
     * 
     * @param lineOn
     */
    public void setLineOn(int lineOn) {
        this.lineOn = lineOn;
    }

    /**
     * 返回隐藏的折线段的长度
     * 
     * @return int
     */
    public int getLineOff() {
        return lineOff;
    }

    /**
     * 设置隐藏的折线段的长度
     * 
     * @param lineOn
     */
    public void setLineOff(int lineOff) {
        this.lineOff = lineOff;
    }

    /**
     * 设置是否使用坐标点样式
     * 
     * @param enableDotStyle
     */
    public void setEnableDotStyle(boolean enableDotStyle) {
        this.enableDotStyle = enableDotStyle;
    }

    /**
     * 返回坐标点样式是否生效
     * 
     * @return boolean
     */
    public boolean isEnableDotStyle() {
        return enableDotStyle;
    }

    /**
     * 使用坐标点样式
     */
    public void enableDotStyle() {
        this.enableDotStyle = true;
    }

    /**
     * 不使用坐标点样式
     */
    public void disableDotStyle() {
        this.enableDotStyle = false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * 返回记录了坐标点样式的{@link LineDotStyle}对象
     * 
     * @return {@link LineDotStyle}
     */
    public LineDotStyle getDotStyle() {
        return dotStyle;
    }

    /**
     * 设置坐标点的样式，传入构造好的{@link LineDotStyle}对象
     * 
     * @param dotStyle
     */
    public void setDotStyle(LineDotStyle dotStyle) {
        this.dotStyle = dotStyle;
    }

    /**
     * 返回动画效果的类型
     * 
     * @return String
     */
    public String getOnshowType() {
        return onshowType;
    }

    /**
     * 设置动画效果的类型
     * 
     * @param onshowType
     */
    public void setOnshowType(String onshowType) {
        this.onshowType = onshowType;
    }

    /**
     * 返回动画效果的持续时间
     * 
     * @return double
     */
    public double getOnshowCascade() {
        return onshowCascade;
    }

    /**
     * 设置动画效果的持续时间
     * 
     * @param onshowCascade
     */
    public void setOnshowCascade(double onshowCascade) {
        this.onshowCascade = onshowCascade;
    }

    /**
     * 返回动画效果的延迟时间
     * 
     * @return double
     */
    public double getOnshowDelay() {
        return onshowDelay;
    }

    /**
     * 设置动画效果的延迟时间
     * 
     * @param onshowDelay
     */
    public void setOnshowDelay(double onshowDelay) {
        this.onshowDelay = onshowDelay;
    }

    /**
     * 返回json字符串
     */
    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JSONArray valueArray = new JSONArray();
        if (values != null) {
            for (LineValue value : values) {
                if (value.getType() == null) {
                    valueArray.add(value.getValue());
                } else {
                    valueArray.add(value);
                }
            }
        }
        JOFCUtils.appendJson(jo, "type", type);
        JOFCUtils.appendJson(jo, "values", valueArray);
        if (this.enableDotStyle) {
            JOFCUtils.appendJson(jo, "dot-style", dotStyle);
        }
        if (this.enableLineStyle) {
            JSONObject linestyle = new JSONObject();
            JOFCUtils.appendJson(linestyle, "style", lineStyle);
            JOFCUtils.appendJson(linestyle, "on", lineOn);
            JOFCUtils.appendJson(linestyle, "off", lineOff);

            JOFCUtils.appendJson(jo, "line-style", linestyle);
        }
        if (onshowType != null) {
            JSONObject onshow = new JSONObject();
            JOFCUtils.appendJson(onshow, "type", onshowType);
            JOFCUtils.appendJson(onshow, "cascade", onshowCascade);
            JOFCUtils.appendJson(onshow, "delay", onshowDelay);

            JOFCUtils.appendJson(jo, "on-show", onshow);
        }
        JOFCUtils.appendJson(jo, "width", width);
        JOFCUtils.appendJson(jo, "text", text);
        JOFCUtils.appendJson(jo, "colour", colour);
        return jo.toString();
    }

}
