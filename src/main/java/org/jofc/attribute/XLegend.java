package org.jofc.attribute;

import org.jofc.itf.JOFCAttribute;
import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;


/**
 * X轴标题的抽象，可以设置文字和样式。<br>
 * 样式使用CSS的方式，比如：<br>
 * <code>
 * {font-size: 20px; color: #778877}
 * </code>
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public class XLegend implements JOFCAttribute {

    private String text;

    private String style;

    public XLegend() {
        style = "{font-size: 20px; color: #778877}";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if (text != null && !"".equals(text.trim())) {
            this.text = text;
        }
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String getAttributeName() {
        return "x_legend";
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "text", text);
        JOFCUtils.appendJson(jo, "style", style);
        return jo.toString();
    }

    @Override
    public Object getAttributeValue() {
        return text;
    }

}
