
package org.jofc.attribute.chart;

import net.sf.json.JSONArray;

import org.jofc.attribute.chart.element.BarElement;
import org.jofc.attribute.chart.element.value.BarValue;
import org.jofc.itf.JOFCChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BarChart implements JOFCChart<BarElement, BarValue> {
    private List<BarElement> elements = new ArrayList<BarElement>();

    public void setElements(BarElement[] barElements) {
        this.setElements(Arrays.asList(barElements));
    }

    @Override
    public String getAttributeName() {
        return "elements";
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONArray ja = new JSONArray();
        for (BarElement element : elements) {
            ja.add(element);
        }
        return ja.toString();
    }

    @Override
    public void setElement(int index, BarElement element) {
        int size = elements.size();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            elements.set(index, element);
        }
    }

    @Override
    public void setElements(List<BarElement> jOFCElements) {
        this.elements = jOFCElements;
    }

    @Override
    public void setValues(int index, List<BarValue> values) {
        int size = elements.size();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            elements.get(index).setValues(values);
        }
    }

    public int getElementsCount() {
        return elements.size();
    }

    @Override
    public void appendValues(List<BarValue> values) {
        elements.add(new BarElement(values));
    }

    @Override
    public List<BarElement> getElements() {
        return elements;
    }

    @Override
    public Object getAttributeValue() {
        return elements;
    }

    @Override
    public void appendElement(BarElement element) {
        // TODO Auto-generated method stub
        
    }

}
