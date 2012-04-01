package org.jofc.attribute.chart.element.value;

import org.jofc.itf.JOFCValue;
import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;


public class PieValue implements JOFCValue {

    private double value;

    private String label;

    private String colour;

    private String labelColour;//label-colour

    private int fontSize;//font-size

    private String onClick;//on-click

    public PieValue(double value) {
        this.value = value;
        this.label = null;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getLabelColour() {
        return labelColour;
    }

    public void setLabelColour(String labelColour) {
        this.labelColour = labelColour;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "value", value);
        JOFCUtils.appendJson(jo, "label", label);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "label-colour", labelColour);
        JOFCUtils.appendJson(jo, "font-size", fontSize);
        JOFCUtils.appendJson(jo, "on-click", onClick);
        return jo.toString();
    }
}
