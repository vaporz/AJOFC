package org.jofc.enums;

public enum YAxixEnum {

    /**
     * Y轴坐标逆时针翻转90度
     */
    VERTICAL("vertical");

    private YAxixEnum(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
