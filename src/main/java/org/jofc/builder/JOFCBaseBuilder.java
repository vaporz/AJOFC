
package org.jofc.builder;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

import org.jofc.attribute.ChartAttribute;
import org.jofc.attribute.OtherAttributes;
import org.jofc.attribute.Title;
import org.jofc.attribute.XAxis;
import org.jofc.attribute.XLegend;
import org.jofc.attribute.YAxis;
import org.jofc.attribute.YLegend;
import org.jofc.itf.JOFCBuilder;
import org.jofc.itf.JOFCChart;
import org.jofc.itf.JOFCElement;
import org.jofc.itf.JOFCValue;
import org.jofc.util.JOFCUtils;

import java.util.List;
import java.util.Map.Entry;

public abstract class JOFCBaseBuilder<T extends JOFCElement<E>, E extends JOFCValue> implements JSONString, JOFCBuilder<T, E> {

    public JOFCBaseBuilder() {
        title = new Title();
        xAxis = new XAxis();
        yAxis = new YAxis();
        xLegend = new XLegend();
        yLegend = new YLegend();
        chartAttribute = new ChartAttribute();
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        jo.put("elements", jOFChart);
        JOFCUtils.appendJson(jo, title);
        JOFCUtils.appendJson(jo, xAxis);
        JOFCUtils.appendJson(jo, yAxis);
        JOFCUtils.appendJson(jo, xLegend);
        JOFCUtils.appendJson(jo, yLegend);
        for (Entry<String, Object> entry : chartAttribute.getAttributeMap().entrySet()) {
            JOFCUtils.appendJson(jo, entry.getKey(), entry.getValue());
        }
        return jo.toString();
    }

    private JOFCChart<T, E> jOFChart = null;

    private Title title;

    private XAxis xAxis;

    private YAxis yAxis;

    private XLegend xLegend;

    private YLegend yLegend;

    private OtherAttributes otherAttributes;

    private ChartAttribute chartAttribute;

    public JOFCBaseBuilder<T, E> setChart(JOFCChart<T, E> jOFChart) {
        this.jOFChart = jOFChart;
        return this;
    }

    public JOFCBaseBuilder<T, E> setTitle(String title) {
        this.title.setText(title);
        return this;
    }

    public JOFCBaseBuilder<T, E> setTitle(Title title) {
        this.title = title;
        return this;
    }

    public JOFCBaseBuilder<T, E> setxAxis(XAxis xAxis) {
        this.xAxis = xAxis;
        return this;
    }

    public JOFCBaseBuilder<T, E> setyAxis(YAxis yAxis) {
        this.yAxis = yAxis;
        return this;
    }

    public JOFCBaseBuilder<T, E> setxLegend(XLegend xLegend) {
        this.xLegend = xLegend;
        return this;
    }

    public JOFCBaseBuilder<T, E> setyLegend(YLegend yLegend) {
        this.yLegend = yLegend;
        return this;
    }

    public JOFCBaseBuilder<T, E> setChartAttribute(ChartAttribute chartAttribute) {
        this.chartAttribute = chartAttribute;
        return this;
    }

    public JOFCBaseBuilder<T, E> setOtherAttributes(OtherAttributes otherAttributes) {
        this.otherAttributes = otherAttributes;
        return this;
    }

    public JOFCChart<T, E> getjOFChart() {
        return jOFChart;
    }

    public Title getTitle() {
        return title;
    }

    public XAxis getxAxis() {
        return xAxis;
    }

    public YAxis getyAxis() {
        return yAxis;
    }

    public XLegend getxLegend() {
        return xLegend;
    }

    public YLegend getyLegend() {
        return yLegend;
    }

    public OtherAttributes getOtherAttributes() {
        return otherAttributes;
    }

    public ChartAttribute getChartAttribute() {
        return chartAttribute;
    }

    // @Override
    public List<T> getElements() {
        return jOFChart.getElements();
    }
}
