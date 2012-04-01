
package org.jofc.attribute.chart;

import net.sf.json.JSONArray;

import org.jofc.attribute.chart.element.LineElement;
import org.jofc.attribute.chart.element.value.LineValue;
import org.jofc.itf.JOFCChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 记录关于曲线本身的一些信息，比如坐标值，坐标点样式等，是对曲线的抽象
 * 
 * @author 张啸[zzxx513@163.com]
 */
public class LineChart implements JOFCChart<LineElement, LineValue> {

    private List<LineElement> elements = new ArrayList<LineElement>();

    @Override
    public List<LineElement> getElements() {
        return elements;
    }

    @Override
    public void setElements(List<LineElement> pieElements) {
        this.elements = pieElements;
    }

    public LineChart() {
    }

    public void setElements(LineElement[] lineElements) {
        this.setElements(Arrays.asList(lineElements));
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
        for (LineElement element : elements) {
            ja.add(element);
        }
        return ja.toString();
    }

    @Override
    public void setElement(int index, LineElement element) {
        int size = elements.size();
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            elements.set(index, element);
        }
    }

    @Override
    public void setValues(int index, List<LineValue> values) {
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
    public void appendValues(List<LineValue> values) {
        elements.add(new LineElement(values));
    }

    @Override
    public Object getAttributeValue() {
        return elements;
    }

    @Override
    public void appendElement(LineElement element) {
        elements.add(element);
    }

}
