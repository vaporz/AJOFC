package org.jofc.enums;


public enum PieAnimates {
    /**
     * 颜色渐变
     */
    FADE(1),
    /**
     * 弹出
     */
    BOUNCE(2);

    private PieAnimates(int type) {
        this.value = type;
    }

    public final int value;//NOSONAR
    
    public int getValue(){
        return value;
    }
}
