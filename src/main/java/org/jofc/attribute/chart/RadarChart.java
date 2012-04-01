package org.jofc.attribute.chart;

import java.util.Arrays;
import java.util.List;

import org.jofc.attribute.chart.element.RadarElement;
import org.jofc.attribute.chart.element.value.RadarValue;
import org.jofc.itf.JOFCChart;


public class RadarChart implements JOFCChart<RadarElement, RadarValue> {

    public void setElements(RadarElement[] radarElements) {
        this.setElements(Arrays.asList(radarElements));
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
    public void appendValues(List<RadarValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElement(int index, RadarElement element) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElements(List<RadarElement> jOFCElements) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValues(int index, List<RadarValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<RadarElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(RadarElement element) {
        // TODO Auto-generated method stub
        
    }
}
