package org.jofc.attribute.chart;

import org.jofc.attribute.chart.element.CandleElement;
import org.jofc.attribute.chart.element.value.CandleValue;
import org.jofc.itf.JOFCChart;

import java.util.Arrays;
import java.util.List;


public class CandleChart implements JOFCChart<CandleElement, CandleValue> {

    public void setElements(CandleElement[] candleElements) {
        this.setElements(Arrays.asList(candleElements));
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
    public void appendValues(List<CandleValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElement(int index, CandleElement element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setElements(List<CandleElement> jOFCElements) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValues(int index, List<CandleValue> values) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<CandleElement> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getAttributeValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void appendElement(CandleElement element) {
        // TODO Auto-generated method stub
        
    }
}
