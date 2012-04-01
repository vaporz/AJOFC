
package org.jofc.attribute.chart.element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jofc.attribute.chart.element.value.BarValue;
import org.jofc.exception.TypeMismatchException;
import org.jofc.itf.JOFCElement;
import org.jofc.util.JOFCUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarElement implements JOFCElement<BarValue>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String type;

    private String colour;

    private String outlineColour;// outline-colour

    private int offset;

    private String text;

    private int fontSize = 12;

    // "on-show":{"type":"pop","cascade":1,"delay":0.5}}
    private String onshowType;// type

    private double onshowCascade = 1;// cascade

    private double onshowDelay;// delay

    private List<BarValue> values = new ArrayList<BarValue>();

    public BarElement() {
        type = "bar";
        Integer[] values = new Integer[] {
            9, 8, 7, 6, 5, 4, 3, 2, 1
        };
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i].doubleValue());
        }
        this.values = Arrays.asList(barValues);
    }

    public BarElement(List<BarValue> values) {
        type = "bar";
        this.values = values;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getOutlineColour() {
        return outlineColour;
    }

    public void setOutlineColour(String outlineColour) {
        this.outlineColour = outlineColour;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<BarValue> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    @Override
    public void setValues(List<BarValue> jOFCValues) {
        values = jOFCValues;
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    public void setValues(Number[] jOFCValues) {
        BarValue[] barValues = new BarValue[jOFCValues.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(jOFCValues[i].doubleValue());
        }
        this.setValues(barValues);
    }

    /**
     * 设置数据，数值对应Y轴坐标
     * 
     * @param jOFCValues
     * @throws TypeMismatchException
     */
    public void setValues(BarValue[] jOFCValues) {
        this.setValues(Arrays.asList(jOFCValues));
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

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JSONArray valueArray = new JSONArray();
        if (values != null) {
            for (BarValue value : values) {
                if (value.isAsObject()) {
                    valueArray.add(value);
                } else {
                    valueArray.add(value.getTop());
                }
            }
        }
        if (onshowType != null) {
            JSONObject onshow = new JSONObject();
            JOFCUtils.appendJson(onshow, "type", onshowType);
            JOFCUtils.appendJson(onshow, "cascade", onshowCascade);
            JOFCUtils.appendJson(onshow, "delay", onshowDelay);

            JOFCUtils.appendJson(jo, "on-show", onshow);
        }
        JOFCUtils.appendJson(jo, "type", type);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "outline-colour", outlineColour);
        JOFCUtils.appendJson(jo, "offset", offset);
        JOFCUtils.appendJson(jo, "values", valueArray);
        JOFCUtils.appendJson(jo, "text", text);
        JOFCUtils.appendJson(jo, "font-size", fontSize);
        return jo.toString();
    }
}
