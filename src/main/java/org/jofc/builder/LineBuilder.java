
package org.jofc.builder;

import java.util.Arrays;
import java.util.List;

import org.jofc.attribute.chart.LineChart;
import org.jofc.attribute.chart.element.LineDotStyle;
import org.jofc.attribute.chart.element.LineElement;
import org.jofc.attribute.chart.element.value.LineValue;
import org.jofc.enums.LineAnimates;

public class LineBuilder extends JOFCBaseBuilder<LineElement, LineValue> {

    private LineChart lineChart = new LineChart();

    public LineBuilder() {
        super();
        this.setChart(lineChart);
    }

    public void setValues(int index, float[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, short[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, double[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, long[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, int[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, Number[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i] == null ? 0 : values[i].doubleValue());
        }
        this.setValues(index, lineValues);
    }

    public void setValues(int index, LineValue[] values) {
        this.setValues(index, Arrays.asList(values));
    }

    public void appendValues(LineValue[] values) {
        this.appendValues(Arrays.asList(values));
    }

    public void appendValues(float[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.appendValues(lineValues);
    }

    public void appendValues(short[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.appendValues(lineValues);
    }

    public void appendValues(double[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.appendValues(lineValues);
    }

    public void appendValues(long[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.appendValues(lineValues);
    }

    public void appendValues(int[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i]);
        }
        this.appendValues(lineValues);
    }

    public void appendValues(Number[] values) {
        LineValue[] lineValues = new LineValue[values.length];
        for (int i = 0; i < lineValues.length; i++) {
            lineValues[i] = new LineValue(values[i] == null ? 0 : values[i].doubleValue());
        }
        this.appendValues(lineValues);
    }

    public void appendElement(LineElement lineElement) {
        lineChart.appendElement(lineElement);
    }

    public void setElement(int index, LineElement element) {
        lineChart.setElement(index, element);
    }

    public void enableLineStyle(int index) {
        int size = getCountElements();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);// NOSONAR
        } else {
            getElement(index).enableLineStyle();
        }
    }

    public void enableDotStyle(int index) {
        int size = getCountElements();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);// NOSONAR
        } else {
            getElement(index).enableDotStyle();
        }
    }

    public void enableDotStyle() {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            enableDotStyle(i);
        }
    }

    public void enableLineStyle() {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            enableLineStyle(i);
        }
    }

    public void setLineStyle(int index, String styleType) {
        int size = getCountElements();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);// NOSONAR
        } else {
            getElement(index).setLineStyle(styleType);
        }
    }

    public void setLineOn(int index, int pixel) {
        int size = getCountElements();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);// NOSONAR
        } else {
            getElement(index).setLineOn(pixel);
        }
    }

    public void setLineOff(int index, int pixel) {
        int size = getCountElements();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);// NOSONAR
        } else {
            getElement(index).setLineOff(pixel);
        }
    }

    public void setLineStyle(String styleType) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineStyle(i, styleType);
        }
    }

    public void setLineOn(int pixel) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineOn(i, pixel);
        }
    }

    public void setLineOff(int pixel) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineOff(i, pixel);
        }
    }

    public void setColour(String colour) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setColour(i, colour);
        }
    }

    public void setColour(int index, String colour) {
        getElement(index).setColour(colour);
    }

    public void setText(String text) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setText(i, text);
        }
    }

    public void setText(int index, String text) {
        getElement(index).setText(text);
    }

    public void setValues(int index, List<LineValue> values) {
        lineChart.setValues(index, values);
    }

    public void appendValues(List<LineValue> values) {
        lineChart.appendValues(values);
    }

    @Override
    public List<LineElement> getElements() {
        return lineChart.getElements();
    }

    public LineChart getjOFChart() {
        return lineChart;
    }

    public int getCountElements() {
        return lineChart.getElementsCount();
    }

    public LineElement getElement(int index) {
        return lineChart.getElements().get(index);
    }

    public void setLineAnimate(LineAnimates type) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineAnimate(i, type);
        }
    }

    public void setLineAnimate(int index, LineAnimates type) {
        getElement(index).setOnshowType(type.value);
    }

    public void setLineAnimateCascade(int cascade) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineAnimateCascade(i, cascade);
        }
    }

    public void setLineAnimateCascade(int index, int cascade) {
        getElement(index).setOnshowCascade(cascade);
    }

    public void setLineAnimateDelay(int delay) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineAnimateDelay(i, delay);
        }
    }

    public void setLineAnimateDelay(int index, int delay) {
        getElement(index).setOnshowDelay(delay);
    }

    public void setLineAnimate(LineAnimates type, int cascade, int delay) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineAnimate(i, type, cascade, delay);
        }
    }

    public void setLineAnimate(int index, LineAnimates type, int cascade, int delay) {
        setLineAnimate(index, type);
        setLineAnimateCascade(index, cascade);
        setLineAnimateDelay(index, delay);
    }

    public void setDotStyle(LineDotStyle dotStyle) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            getElement(i).setDotStyle(dotStyle);
        }
    }

    public void setDotStyle(int index, LineDotStyle dotStyle) {
        getElement(index).setDotStyle(dotStyle);
    }

    public void setToolTip(String tip) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            getElement(i).getDotStyle().setTip(tip);
        }
    }

    public void setToolTip(int index, String tip) {
        getElement(index).getDotStyle().setTip(tip);
    }

    public void setLineWidth(int width) {
        int size = getCountElements();
        for (int i = 0; i < size; i++) {
            setLineWidth(i, width);
        }
    }

    public void setLineWidth(int index, int width) {
        getElement(index).setWidth(width);
    }
}
