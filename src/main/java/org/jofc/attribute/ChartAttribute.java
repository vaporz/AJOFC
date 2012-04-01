
package org.jofc.attribute;

import java.util.HashMap;
import java.util.Map;

public class ChartAttribute {

    private Map<String, Object> attributeMap = new HashMap<String, Object>();

    private int numDecimals;

    private boolean isFixedNumDecimalsForced;

    private boolean isDecimalSeparatorComma;

    private boolean isThousandSeparatorDisabled;

    private String bgColour;
    
    public ChartAttribute(){
        attributeMap.put("bg_colour", "#FFFFFF");
    }

    public Object getValueByAttributeName(String attributeName) {
        return attributeMap.get(attributeName);
    }

    public Map<String, Object> getAttributeMap() {
        return attributeMap;
    }

    public int getNumDecimals() {
        return numDecimals;
    }

    /**
     * 设置小数位数
     * 
     * @param numDecimals
     */
    public ChartAttribute setNumDecimals(int numDecimals) {
        this.numDecimals = numDecimals;
        attributeMap.put("num_decimals", numDecimals);
        return this;
    }

    /**
     * 是否强制显示指定位数的小数
     * 
     * @return
     */
    public boolean isFixedNumDecimalsForced() {
        return isFixedNumDecimalsForced;
    }

    /**
     * 设置是否强制显示指定位数的小数
     * 
     * @param isFixedNumDecimalsForced
     */
    public ChartAttribute setIsFixedNumDecimalsForced(boolean isFixedNumDecimalsForced) {
        this.isFixedNumDecimalsForced = isFixedNumDecimalsForced;
        attributeMap.put("is_fixed_num_decimals_forced", isFixedNumDecimalsForced);
        return this;
    }

    /**
     * 是否使用逗号作为分隔
     * 
     * @param isDecimalSeparatorComma
     */
    public boolean isDecimalSeparatorComma() {
        return isDecimalSeparatorComma;
    }

    /**
     * 设置是否使用逗号作为分隔
     * 
     * @param isDecimalSeparatorComma
     */
    public ChartAttribute setIsDecimalSeparatorComma(boolean isDecimalSeparatorComma) {
        this.isDecimalSeparatorComma = isDecimalSeparatorComma;
        attributeMap.put("is_decimal_separator_comma", isDecimalSeparatorComma);
        return this;
    }

    /**
     * 是否使用千位的分割
     * 
     * @param isDecimalSeparatorComma
     */
    public boolean isThousandSeparatorDisabled() {
        return isThousandSeparatorDisabled;
    }

    /**
     * 设置是否使用千位的分割
     * 
     * @param isDecimalSeparatorComma
     */
    public ChartAttribute setIsThousandSeparatorDisabled(boolean isThousandSeparatorDisabled) {
        this.isThousandSeparatorDisabled = isThousandSeparatorDisabled;
        attributeMap.put("is_thousand_separator_disabled", isThousandSeparatorDisabled);
        return this;
    }

    /**
     * 背景颜色
     * 
     * @return
     */
    public String getBgColour() {
        return bgColour;
    }

    /**
     * 设置背景颜色
     * 
     * @param isDecimalSeparatorComma
     */
    public ChartAttribute setBgColour(String colour) {
        bgColour = colour;
        attributeMap.put("bg_colour", colour);
        return this;
    }

}
