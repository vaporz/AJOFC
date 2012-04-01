
package org.jofc.attribute.chart.element;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jofc.attribute.chart.element.value.PieValue;
import org.jofc.itf.JOFCElement;
import org.jofc.util.JOFCUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PieElement implements JOFCElement<PieValue>, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<PieValue> values = new ArrayList<PieValue>();

    private String type;

    private double alpha = 0.5;

    private boolean gradientFill = true;// gradient-fill

    private int startAngle;// start-angle

    private List<String> colours = new ArrayList<String>();

    private String tip = "#percent#";

    private boolean noLabels = false;// no-labels

    private String onClick;// on-click

    private int radius = 80;

    private List<PieAnimate> animate = new ArrayList<PieAnimate>();

    public PieElement() {
        type = "pie";
        Integer[] values = new Integer[] {
            10, 10, 10
        };
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i].doubleValue());
        }
        this.values = Arrays.asList(pieValues);
    }

    public void addAnimate(PieAnimate animate) {
        this.animate.add(animate);
    }

    public PieElement(List<PieValue> values) {
        type = "pie";
        this.values = values;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public int getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    public boolean isGradientFill() {
        return gradientFill;
    }

    public void setGradientFill(boolean gradientFill) {
        this.gradientFill = gradientFill;
    }

    public List<PieAnimate> getAnimate() {
        return animate;
    }

    public void setAnimate(List<PieAnimate> animate) {
        this.animate = animate;
    }

    public String getTip() {
        return tip;
    }

    /**
     * #val# - the number value of the slice<br>
     * #total# - the total of all the slices<br>
     * #percent# - the value as a percent<br>
     * #label# - if you have passed in a label, the tooltip can contain it. This is useful if you set 'nolabel' to true,
     * the pie chart will fill the area, but you can still display a unique label for each slice.<br>
     * #radius# - to help figure out a good radius when you want to fix it. <br>
     * 例："#val# of #total#， #percent# of 100%";
     * 
     * @param tip
     */
    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isNoLabels() {
        return noLabels;
    }

    public void setNoLabels(boolean noLabels) {
        this.noLabels = noLabels;
    }

    public String getOnClick() {
        return onClick;
    }

    public void setOnClick(String onClick) {
        this.onClick = onClick;
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JSONArray valueArray = new JSONArray();
        if (values != null) {
            for (PieValue value : values) {
                if (value.getLabel() == null) {
                    valueArray.add(value.getValue());
                } else {
                    valueArray.add(value);
                }
            }
        }
        JSONArray colourArray = new JSONArray();
        if (colours != null) {
            for (String value : colours) {
                if (value != null) {
                    colourArray.add(value);
                }
            }
        }
        JSONArray animateArray = new JSONArray();
        if (animate != null) {
            for (PieAnimate value : animate) {
                if (value != null) {
                    animateArray.add(value);
                }
            }
        }
        JOFCUtils.appendJson(jo, "type", type);
        JOFCUtils.appendJson(jo, "alpha", alpha);
        JOFCUtils.appendJson(jo, "start-angle", startAngle);
        JOFCUtils.appendJson(jo, "tip", tip);
        JOFCUtils.appendJson(jo, "animate", animateArray);
        JOFCUtils.appendJson(jo, "no-labels", noLabels);
        JOFCUtils.appendJson(jo, "on-click", onClick);
        JOFCUtils.appendJson(jo, "radius", radius);
        JOFCUtils.appendJson(jo, "gradient-fill", gradientFill);
        JOFCUtils.appendJson(jo, "values", valueArray);
        return jo.toString();
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    /**
     * 返回数据的List，PieValue对象的type属性如果是null，那这一项就只是个普通数字
     * 
     * @return
     */
    public List<PieValue> getValues() {
        return values;
    }

    @Override
    public void setValues(List<PieValue> jOFCValues) {
        values = jOFCValues;
    }

    public void setValues(Number[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i].doubleValue());
        }
        this.setValues(pieValues);
    }

    public void setValues(PieValue[] jOFCValues) {
        this.setValues(Arrays.asList(jOFCValues));
    }

}
