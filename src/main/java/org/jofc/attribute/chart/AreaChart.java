
package org.jofc.attribute.chart;

import org.jofc.attribute.chart.element.AreaElement;
import org.jofc.attribute.chart.element.value.AreaValue;
import org.jofc.itf.JOFCChart;

import java.util.Arrays;
import java.util.List;

public class AreaChart implements JOFCChart<AreaElement, AreaValue> {

    public void setElements(AreaElement[] areaElements) {
        this.setElements(Arrays.asList(areaElements));
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
    public void appendValues(List<AreaValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElement(int index, AreaElement element) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setElements(List<AreaElement> jOFCElements) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setValues(int index, List<AreaValue> values) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<AreaElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(AreaElement element) {
        // TODO Auto-generated method stub
        
    }
}
