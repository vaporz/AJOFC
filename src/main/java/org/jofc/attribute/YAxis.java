package org.jofc.attribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jofc.enums.YAxixEnum;
import org.jofc.itf.JOFCAttribute;
import org.jofc.util.JOFCUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONString;


/**
 * Y坐标轴的抽象，可以设置自己定义的文字作为坐标值，也可以设置颜色等样式。<br>
 * 需要指定上限和下限，但上限的数值不一定必须低于下限。
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public class YAxis implements JOFCAttribute {

    private double min;

    private double max;

    private double steps;

    private int stroke;

    private String colour;

    private int tickLength;//tick-length

    private String gridColour;//grid-colour

    private Labels labels = new Labels();

    public YAxis() {
        min = 0;
        max = 10;
        steps = 1;
        stroke = 2;
        colour = "#000000";
        tickLength = 3;
        gridColour = "#e0e0e0";
    }

    /**
     * 返回Y轴下限
     * 
     * @return
     */
    public double getMin() {
        return min;
    }

    /**
     * 设置Y轴下限
     * 
     * @param min
     */
    public void setMin(double min) {
        this.min = min;
    }

    /**
     * 返回Y轴上限
     * 
     * @return
     */
    public double getMax() {
        return max;
    }

    /**
     * 设置Y轴上限
     * 
     * @param max
     */
    public void setMax(double max) {
        this.max = max;
    }

    /**
     * 返回显示Y轴的横线时，间隔的单位数量
     * 
     * @return
     */
    public double getSteps() {
        return steps;
    }

    /**
     * 设置显示Y轴的横线时，间隔的单位数量
     * 
     * @param steps
     */
    public void setSteps(double steps) {
        this.steps = steps;
    }

    /**
     * 返回Y轴的厚度，单位是像素
     * 
     * @return
     */
    public int getStroke() {
        return stroke;
    }

    /**
     * 设置Y轴的厚度，单位是像素
     * 
     * @param stroke
     */
    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    /**
     * 返回Y轴的颜色，如"#A2ACBA"
     * 
     * @return
     */
    public String getColour() {
        return colour;
    }

    /**
     * 设置Y轴的颜色，如"#A2ACBA"
     * 
     * @param colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * 返回Y坐标轴上突起的刻度的长度，单位是像素
     * 
     * @return
     */
    public int getTickLength() {
        return tickLength;
    }

    /**
     * 设置Y坐标轴上突起的刻度的长度，单位是像素
     * 
     * @param tickLength
     */
    public void setTickLength(int tickLength) {
        this.tickLength = tickLength;
    }

    /**
     * 返回Y轴横线的颜色，如"#A2ACBA"
     * 
     * @return
     */
    public String getGridColour() {
        return gridColour;
    }

    /**
     * 设置Y轴横线的颜色，如"#A2ACBA"
     * 
     * @param gridColour
     */
    public void setGridColour(String gridColour) {
        this.gridColour = gridColour;
    }

    /**
     * 返回Y轴文字的对象列表，合法的对象类型包括String对象或者{@link YAxisLabel}对象
     * 
     * @return
     */
    public List<Object> getLabelObjectList() {
        return labels.labels;
    }

    /**
     * 返回Y轴文字的字符串列表
     * 
     * @return
     */
    public List<String> getLabelList() {
        List<String> result = new ArrayList<String>(20);
        for (Object label : labels.labels) {
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
     * 设置Y坐标轴的标签的值，List中可以放置String类型或者{@link YAxisLabel}
     * 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList X坐标轴的标签值
     * @see YAxisLabel
     */
    public void setLabelList(Object[] labelList) {
        labels.labels = Arrays.asList(labelList);
    }

    /**
     * 设置Y坐标轴的标签的值，List中可以放置String类型或者{@link YAxisLabel}
     * 对象，其他类型按照"undefined"字符串处理
     * 
     * @param labelList Y坐标轴的标签值
     * @see YAxisLabel
     */
    public void setLabelsList(List<Object> labelList) {
        labels.labels = labelList;
    }

    /**
     * 返回显示Y轴的坐标值时，间隔的单位数量
     * 
     * @return
     */
    public int getLabelSteps() {
        return labels.steps;
    }

    /**
     * 显示Y轴坐标值时，每steps个单位显示一个坐标值，如果为1，表示每个坐标值都显示
     * 
     * @param labelSteps
     */
    public void setLabelSteps(int labelSteps) {
        labels.steps = labelSteps;
    }

    @Override
    public String getAttributeName() {
        return "y_axis";
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "min", min);
        JOFCUtils.appendJson(jo, "max", max);
        JOFCUtils.appendJson(jo, "steps", steps);
        JOFCUtils.appendJson(jo, "stroke", stroke);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "tick-length", tickLength);
        JOFCUtils.appendJson(jo, "grid-colour", gridColour);
        if (labels.labels.size() > 0) {
            JOFCUtils.appendJson(jo, "labels", labels);
        }
        return jo.toString();
    }

    private static class Labels implements JSONString {

        private List<Object> labels = new ArrayList<Object>();

        private int steps;

        private YAxixEnum rotate;

        private String colour;

        public Labels() {
            steps = 4;
            colour = "#A2ACBA";
        }

        @Override
        public String toJSONString() {
            JSONObject jo = new JSONObject();
            JSONArray ja = new JSONArray();
            for (Object label : labels) {
                if (label == null) {
                    ja.add("null");
                } else if (label instanceof String || label instanceof YAxisLabel) {
                    ja.add(label);
                } else {
                    ja.add("undefined");
                }
            }
            JOFCUtils.appendJson(jo, "colour", colour);
            JOFCUtils.appendJson(jo, "steps", steps);
            if (rotate != null) {
                JOFCUtils.appendJson(jo, "rotate", rotate.value);
            }
            JOFCUtils.appendJson(jo, "labels", ja);
            return jo.toString();
        }
    }

    @Override
    public Object getAttributeValue() {
        return true;
    }
}
