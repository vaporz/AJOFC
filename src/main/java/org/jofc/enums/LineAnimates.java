package org.jofc.enums;

public enum LineAnimates {
    /**
     * 从中间展开，貌似跟MID_SLIDE是一样的
     */
    POP_UP("pop-up"),
    /**
     * 从中间的点冒出来
     */
    EXPLODE("explode"),
    /**
     * 从中间展开，貌似跟POP_UP是一样的
     */
    MID_SLIDE("mid-slide"),
    /**
     * 像倒水一样从上面流下来
     */
    DROP("drop"),
    /**
     * 逐段显示点之间的连线
     */
    FADE_IN("fade-in"),
    /**
     * 逐个显示坐标点，有从大到小的效果
     */
    SHRINK_IN("shrink-in");

    private LineAnimates(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
