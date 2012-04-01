package org.jofc.attribute.chart;

import java.util.Arrays;
import java.util.List;

import org.jofc.attribute.chart.element.ScatterElement;
import org.jofc.attribute.chart.element.value.ScatterValue;
import org.jofc.itf.JOFCChart;


public class ScatterChart implements JOFCChart<ScatterElement, ScatterValue> {

    public void setElements(ScatterElement[] scatterElements) {
        this.setElements(Arrays.asList(scatterElements));
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
    public void appendValues(List<ScatterValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElement(int index, ScatterElement element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElements(List<ScatterElement> jOFCElements) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValues(int index, List<ScatterValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<ScatterElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(ScatterElement element) {
        // TODO Auto-generated method stub
        
    }
}
