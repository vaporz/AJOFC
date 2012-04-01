package org.jofc.attribute;

import org.jofc.util.JOFCUtils;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;
/**
 * Y轴坐标值的抽象，可以设置文本，颜色，字号。<br>
 * 文本在Y轴上的位置通过变量y的数值来确定。
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public class YAxisLabel implements JSONString {

    private double y;

    private String text;

    private String colour;

    private int size = 10;

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }
    /**
     * 可以为Y轴上的值增加前后缀，例如“$#val# million”会显示为“$1234 million”
     * @param text
     */
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

    public YAxisLabel(double y,String text) {
        this.y = y;
        this.text = text;
    }
    public YAxisLabel() {
        
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        if(text==null||"".equals(text)){
            return null;
        }
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "y", y);
        JOFCUtils.appendJson(jo, "text", text);
        JOFCUtils.appendJson(jo, "colour", colour);
        JOFCUtils.appendJson(jo, "size", size);
        return jo.toString();
    }
}
