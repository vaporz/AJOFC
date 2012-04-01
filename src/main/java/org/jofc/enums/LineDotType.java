package org.jofc.enums;



public enum LineDotType {
    /**
     * 实心点，默认不显示（鼠标划过时显示）
     */
    DOT("dot"),
    /**
     * 实心点，默认显示（即使鼠标不在该点上也显示）
     */
    SOLID_DOT("solid-dot"),
    /**
     * 空心点，默认显示（即使鼠标不在该点上也显示）
     */
    HOLLOW_DOT("hollow-dot"),
    /**
     * 空心星形，默认显示（即使鼠标不在该点上也显示）
     */
    STAR("star"),
    /**
     * 两个顶点相对的空心三角形，类似这样：[><]，默认显示（即使鼠标不在该点上也显示）
     */
    BOW("bow"),
    /**
     * 空心三角形，默认显示（即使鼠标不在该点上也显示）
     */
    ANCHOR("anchor");
  

    private LineDotType(String type) {
        this.value = type;
    }

    public final String value;//NOSONAR
    
    public String getValue(){
        return value;
    }
}
