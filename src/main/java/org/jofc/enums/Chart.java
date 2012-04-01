package org.jofc.enums;


public enum Chart {

    /**
     * 线图
     */
    LINE(1),
    /**
     * 饼状图
     */
    PIE(2),
    /**
     * 柱状图
     */
    BAR(3),
    /**
     * 蜡烛图
     */
    CANDLE(4),
    /**
     * 横条图
     */
    HORIZONTAL_BAR(5),
    /**
     * 面积条线图
     */
    AREA(6),
    /**
     * 雷达图
     */
    RADAR(7),
    /**
     * 点状分布图
     */
    SCATTER(8),
    /**
     * 多层线图
     */
    STACKEDBAR(9);

    private Chart(int type) {
        this.value = type;
    }

    public final int value;//NOSONAR
    
    public int getValue(){
        return value;
    }
}
