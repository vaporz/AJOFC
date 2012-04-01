
package org.jofc.enums;

/**
 * 类说明
 * 
 * @author 张啸 (zhangxiao@xiaomi.com):
 * @version 创建时间：2011-6-25 上午11:08:05
 */
public enum ORDER {
    DESC("desc"), // NL
    ASC("asc"), // NL
    NONE("");

    private ORDER(String type) {
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
