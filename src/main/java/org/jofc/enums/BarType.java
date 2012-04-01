package org.jofc.enums;

public enum BarType {
    /**
     * 普通柱图
     */
    BAR("bar"),
    /**
     * 填充颜色的柱图
     */
    BAR_FILLED("bar_filled"),
    /**
     * 玻璃效果的柱图
     */
    BAR_GLASS("bar_glass"),
    /**
     * 蜡笔画效果的柱图
     */
    BAR_SKETCH("bar_sketch"),
    /**
     * 圆柱体的柱图
     */
    BAR_CYLINDER("bar_cylinder"),
    /**
     * 带描边的圆柱体的柱图
     */
    BAR_CYLINDER_OUTLINE("bar_cylinder_outline"),
    /**
     * 半圆形顶部的玻璃效果的柱图
     */
    BAR_ROUND_GLASS("bar_round_glass"),
    /**
     * 顶部和底部都是半圆形的玻璃效果的柱图
     */
    BAR_ROUND("bar_round"),
    /**
     * 底部有立体效果的半圆形顶部的玻璃效果的柱图
     */
    BAR_DOME("bar_dome");

    private BarType(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
