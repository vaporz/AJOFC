package org.jofc.attribute.chart.element.value;

import org.jofc.itf.JOFCValue;
import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;


public class BarValue implements JOFCValue {

    private boolean asObject = false;

    private double top;

    private double bottom;

    private String colour;

    private String tip;

    public double getBottom() {
        return bottom;
    }

    public void setBottom(double bottom) {
        this.bottom = bottom;
    }

    public BarValue(double top) {
        this.top = top;
    }

    public BarValue(double top, double bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public BarValue(double top, double bottom, String colour, String tip) {
        this.top = top;
        this.bottom = bottom;
        this.colour = colour;
        this.tip = tip;
    }

    public BarValue() {
        this.top = 5.00;
    }

    public double getTop() {
        return top;
    }

    public void setTop(double value) {
        this.top = value;
    }

    public boolean isAsObject() {
        return asObject;
    }

    public void setAsObject(boolean asObject) {
        this.asObject = asObject;
    }

    public String getColour() {
        asObject = true;
        return colour;
    }

    public void setColour(String colour) {
        asObject = true;
        this.colour = colour;
    }

    public String getTip() {
        asObject = true;
        return tip;
    }

    public void setTip(String tip) {
        asObject = true;
        this.tip = tip;
    }

    public double getValue() {
        return top;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "top", top);
        JOFCUtils.appendJson(jo, "bottom", bottom);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "tip", tip);
        return jo.toString();
    }

}
