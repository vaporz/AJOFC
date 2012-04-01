
package org.jofc.builder;

import org.jofc.attribute.chart.PieChart;
import org.jofc.attribute.chart.element.PieAnimate;
import org.jofc.attribute.chart.element.PieElement;
import org.jofc.attribute.chart.element.value.PieValue;
import org.jofc.enums.PieAnimates;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class PieBuilder extends JOFCBaseBuilder<PieElement, PieValue> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private PieChart pieChart = new PieChart();

    public PieBuilder() {
        setxAxis(null);
        setyAxis(null);
        setxLegend(null);
        setyLegend(null);
        this.setChart(pieChart);
    }

    public void addPieValue(double value, String label, String colour, int fontSize) {
        PieValue pieValue = new PieValue(value);
        pieValue.setLabel(label);
        pieValue.setColour(colour);
        pieValue.setFontSize(fontSize);
        pieChart.getElements().get(0).getValues().add(pieValue);
    }

    public void setValues(float[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i]);
        }
        this.setValues(pieValues);
    }

    public void setValues(short[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i]);
        }
        this.setValues(pieValues);
    }

    public void setValues(double[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i]);
        }
        this.setValues(pieValues);
    }

    public void setValues(long[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i]);
        }
        this.setValues(pieValues);
    }

    public void setValues(int[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i]);
        }
        this.setValues(pieValues);
    }

    public void setValues(Number[] values) {
        PieValue[] pieValues = new PieValue[values.length];
        for (int i = 0; i < pieValues.length; i++) {
            pieValues[i] = new PieValue(values[i] == null ? 0 : values[i].doubleValue());
        }
        this.setValues(pieValues);
    }

    public void setStartAngle(int startAngle) {
        pieChart.getElements().get(0).setStartAngle(startAngle);
    }

    public void setValues(PieValue[] values) {
        this.setValues(0, Arrays.asList(values));
    }

    public void setValues(List<PieValue> values) {
        this.setValues(0, values);
    }

    public void addAnimate(PieAnimates animate) {
        pieChart.getElements().get(0).addAnimate(new PieAnimate(animate));
    }

    public void setColours(List<String> colours) {
        pieChart.getElements().get(0).setColours(colours);
    }

    public void setAlpha(double alpha) {
        pieChart.getElements().get(0).setAlpha(alpha);
    }

    public void setGradientFill(boolean isGradientFill) {
        pieChart.getElements().get(0).setGradientFill(isGradientFill);
    }

    public void setTip(String tip) {
        pieChart.getElements().get(0).setTip(tip);
    }

    public void setNoLabels(boolean noLabels) {
        pieChart.getElements().get(0).setNoLabels(noLabels);
    }

    public void setOnClick(String onClick) {
        pieChart.getElements().get(0).setOnClick(onClick);
    }

    public void setRadius(int radius) {
        pieChart.getElements().get(0).setRadius(radius);
    }

    public void appendValues(List<PieValue> values) {
        pieChart.setValues(0, values);
    }

    public void setValues(int index, List<PieValue> values) {
        pieChart.setValues(index, values);
    }

}
