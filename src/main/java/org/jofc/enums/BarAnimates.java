package org.jofc.enums;

public enum BarAnimates {
    /**
     * 从下面弹出
     */
    POP_UP("pop-up"),
    /**
     * 从上面落下
     */
    DROP("drop"),
    /**
     * 淡入
     */
    FADE_IN("fade-in"),
    /**
     * 从最小值开始增长至最大值
     */
    GROW_UP("grow-up"),
    /**
     * 从最大值开始增长到最小值
     */
    GROW_DOWN("grow-down"),
    /**
     * 与淡入效果类似，但有弹出来的
     */
    POP("pop");

    private BarAnimates(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
