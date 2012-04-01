package org.jofc.attribute.chart;

import java.util.Arrays;
import java.util.List;

import org.jofc.attribute.chart.element.StackedBarElement;
import org.jofc.attribute.chart.element.value.StackedBarValue;
import org.jofc.itf.JOFCChart;


public class StackedBarChart implements JOFCChart<StackedBarElement, StackedBarValue> {

    public void setElements(StackedBarElement[] stackedBarElements) {
        this.setElements(Arrays.asList(stackedBarElements));
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendValues(List<StackedBarValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElement(int index, StackedBarElement element) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElements(List<StackedBarElement> jOFCElements) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValues(int index, List<StackedBarValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<StackedBarElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(StackedBarElement element) {
        // TODO Auto-generated method stub
        
    }
}
