
package org.jofc.attribute.chart;

import net.sf.json.JSONArray;

import org.jofc.attribute.chart.element.PieElement;
import org.jofc.attribute.chart.element.value.PieValue;
import org.jofc.itf.JOFCChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PieChart implements JOFCChart<PieElement, PieValue> {
    private List<PieElement> elements = new ArrayList<PieElement>();

    public PieChart() {
        elements.add(new PieElement());
    }

    public void setElements(PieElement[] pieElements) {
        this.setElements(Arrays.asList(pieElements));
    }

    @Override
    public String getAttributeName() {
        return "elements";
    }

    @Override
    public void appendValues(List<PieValue> values) {
        elements.add(new PieElement(values));
    }

    @Override
    public void setElement(int index, PieElement element) {
        int size = elements.size();
        if (size == 0) {
            elements.add(element);
        } else {
            elements.set(0, element);
        }
    }

    @Override
    public void setElements(List<PieElement> pieElements) {
        this.elements = pieElements;
    }

    @Override
    public void setValues(int index, List<PieValue> values) {
        int size = elements.size();
        if (size == 0) {
            elements.add(new PieElement(values));
        } else {
            elements.get(0).setValues(values);
        }
    }

    @Override
    public List<PieElement> getElements() {
        return elements;
    }

    @Override
    public Object getAttributeValue() {
        return elements;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONArray ja = new JSONArray();
        for (PieElement element : elements) {
            ja.add(element);
        }
        return ja.toString();
    }

    @Override
    public void appendElement(PieElement element) {
        // TODO Auto-generated method stub
        
    }
}
