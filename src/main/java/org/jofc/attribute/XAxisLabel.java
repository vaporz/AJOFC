package org.jofc.attribute;

import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;


/**
 * X轴坐标值的抽象，可以设置文本，颜色，字号和旋转角度。
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public class XAxisLabel implements JSONString {

    private String text;

    private String colour;

    private int size;

    private int rotate;

    public XAxisLabel(String text) {
        this.text = text;
        this.colour = "#CF4D5F";
        this.size = 16;
        this.rotate = 0;
    }

    public XAxisLabel(String text, String colour, int size, int rotate) {
        this.text = text;
        this.colour = colour;
        this.size = size;
        this.rotate = rotate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        if (text == null || "".equals(text)) {
            return null;
        }
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "text", text);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "size", size);
        JOFCUtils.appendJson(jo, "rotate", rotate);
        return jo.toString();
    }

}
