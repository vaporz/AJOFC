package org.jofc.itf;
/**
 * 类说明
 * @author 张啸 (zhangxiao@xiaomi.com):
 * @version 创建时间：2011-6-24 下午09:27:40
 */
public interface ChartTableItem extends Cloneable{
    Number getItemData();
    String getItemName();
    String getItemHint();
    void setItemData(Number data);
    void setItemName(String name);
    void setItemHint(String hint);
    ChartTableItem getInstance();
}
