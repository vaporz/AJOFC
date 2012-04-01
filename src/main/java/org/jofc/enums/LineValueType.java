package org.jofc.enums;


public enum LineValueType {

    /**
     * 实心圆点
     */
    DOT("dot"),
    /**
     * 星形
     */
    STAR("star");

    private LineValueType(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
