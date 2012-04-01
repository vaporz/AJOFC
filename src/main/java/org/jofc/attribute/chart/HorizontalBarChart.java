package org.jofc.attribute.chart;

import java.util.Arrays;
import java.util.List;

import org.jofc.attribute.chart.element.HorizontalBarElement;
import org.jofc.attribute.chart.element.value.HorizontalBarValue;
import org.jofc.itf.JOFCChart;


public class HorizontalBarChart implements JOFCChart<HorizontalBarElement, HorizontalBarValue> {

    public void setElements(HorizontalBarElement[] horizontalBarElements) {
        this.setElements(Arrays.asList(horizontalBarElements));
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
    public void appendValues(List<HorizontalBarValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElement(int index, HorizontalBarElement element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElements(List<HorizontalBarElement> jOFCElements) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValues(int index, List<HorizontalBarValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<HorizontalBarElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(HorizontalBarElement element) {
        // TODO Auto-generated method stub
        
    }

}
