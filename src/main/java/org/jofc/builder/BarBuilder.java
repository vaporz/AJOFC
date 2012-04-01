
package org.jofc.builder;

import org.jofc.attribute.chart.BarChart;
import org.jofc.attribute.chart.element.BarElement;
import org.jofc.attribute.chart.element.value.BarValue;
import org.jofc.enums.BarAnimates;
import org.jofc.enums.BarType;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class BarBuilder extends JOFCBaseBuilder<BarElement, BarValue> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private BarChart barChart = new BarChart();

    public BarBuilder() {
        super();
        this.setChart(barChart);
    }

    public void setValues(int index, float[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, short[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, double[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, long[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, int[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, Number[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i] == null ? 0 : values[i].doubleValue());
        }
        this.setValues(index, barValues);
    }

    public void setValues(int index, BarValue[] values) {
        this.setValues(index, Arrays.asList(values));
    }

    public void appendValues(BarValue[] values) {
        this.appendValues(Arrays.asList(values));
    }

    public void appendValues(float[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.appendValues(barValues);
    }

    public void appendValues(short[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.appendValues(barValues);
    }

    public void appendValues(double[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.appendValues(barValues);
    }

    public void appendValues(long[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.appendValues(barValues);
    }

    public void appendValues(int[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i]);
        }
        this.appendValues(barValues);
    }

    public void appendValues(Number[] values) {
        BarValue[] barValues = new BarValue[values.length];
        for (int i = 0; i < barValues.length; i++) {
            barValues[i] = new BarValue(values[i] == null ? 0 : values[i].doubleValue());
        }
        this.appendValues(barValues);
    }

    public void setCutlineText(String text) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setCutlineText(i, text);
        }
    }

    public void setCutlineText(int index, String text) {
        getElement(index).setText(text);
    }

    private int getCountElements() {
        return barChart.getElementsCount();
    }

    private BarElement getElement(int index) {
        return barChart.getElements().get(index);
    }

    public void appendValues(List<BarValue> values) {
        barChart.appendValues(values);
    }

    public void setValues(int index, List<BarValue> values) {
        barChart.setValues(index, values);
    }

    public void setCutlineFontSize(int fontsize) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setCutlineFontSize(i, fontsize);
        }
    }

    public void setCutlineFontSize(int index, int fontsize) {
        getElement(index).setFontSize(fontsize);
    }

    public void setBarsColour(String colour) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarsColour(i, colour);
        }
    }

    public void setBarsColour(int index, String colour) {
        getElement(index).setColour(colour);
    }

    public void setBarsOutlineColour(String colour) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarsOutlineColour(i, colour);
        }
    }

    public void setBarsOutlineColour(int index, String colour) {
        getElement(index).setOutlineColour(colour);
    }

    public void setBarType(BarType barType) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarType(i, barType);
        }
    }

    public void setBarType(int index, BarType barType) {
        getElement(index).setType(barType.value);
    }

    public void setBarAnimate(BarAnimates type) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarAnimate(i, type);
        }
    }

    public void setBarAnimate(int index, BarAnimates type) {
        getElement(index).setOnshowType(type.value);
    }

    public void setBarAnimateCascade(int cascade) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarAnimateCascade(i, cascade);
        }
    }

    public void setBarAnimateCascade(int index, int cascade) {
        getElement(index).setOnshowCascade(cascade);
    }

    public void setBarAnimateDelay(int delay) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarAnimateDelay(i, delay);
        }
    }

    public void setBarAnimateDelay(int index, int delay) {
        getElement(index).setOnshowDelay(delay);
    }

    public void setBarAnimate(BarAnimates type, int cascade, int delay) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setBarAnimate(i, type, cascade, delay);
        }
    }

    public void setBarAnimate(int index, BarAnimates type, int cascade, int delay) {
        setBarAnimate(index, type);
        setBarAnimateCascade(index, cascade);
        setBarAnimateDelay(index, delay);
    }
}
