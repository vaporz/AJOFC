package org.jofc.attribute;

import org.jofc.itf.JOFCAttribute;
import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;


/**
 * 图表标题的抽象，可以设置文字和样式。<br>
 * 样式使用CSS的方式，比如：<br>
 * <code>
 * {font-size: 20px; font-family: Times New Roman; font-weight: bold; color: #A2ACBA; text-align: center;}
 * </code>
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public class Title implements JOFCAttribute {

    private String text;

    private String style;

    public Title() {
        this.style = "{font-size: 20px; font-family: Times New Roman; font-weight: bold; color: #A2ACBA; text-align: center;}";
    }

    public Title(String title) {
        if (title != null && !"".equals(title.trim())) {
            this.text = title;
            this.style = "{font-size: 20px; font-family: Times New Roman; font-weight: bold; color: #A2ACBA; text-align: center;}";
        }
    }

    public Title(String title, String style) {
        if (title != null && !"".equals(title.trim())) {
            this.text = title;
            this.style = style;
        }
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
        return "title";
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
