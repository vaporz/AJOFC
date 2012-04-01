package org.jofc.itf;

import java.util.List;

import net.sf.json.JSONString;

/**
 * 最主要的抽象，图表元素由用{@link JOFCValue}表示的数据和各种属性组成，决定了图表的展现形式(饼图、柱图、线图......)
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 * @param <T> 实现了{@link JOFCValue}接口的类
 */
public interface JOFCElement<T extends JOFCValue> extends JSONString {

    /**
     * 设置图表的数据
     * 
     * @param jOFCValues
     */
    void setValues(List<T> jOFCValues);
}
