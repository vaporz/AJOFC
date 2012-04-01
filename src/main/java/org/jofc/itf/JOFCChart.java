
package org.jofc.itf;

import java.util.List;

/**
 * 表示图表中最重要的部分，也就是图表内容，比如折线图中的折线，柱状图中的每一组柱形
 * 
 * @author 张啸[zzxx513@163.com]
 * @param <T> 实现了{@link JOFCElement}接口的类
 * @param <E> 实现了{@link JOFCValue}接口的类
 */
public interface JOFCChart<T extends JOFCElement<E>, E extends JOFCValue> extends JOFCAttribute {

    /**
     * 返回图表元素对象的列表
     * 
     * @return List
     */
    List<T> getElements();

    /**
     * 设置包含的图表元素
     * 
     * @param jOFCElements
     */
    void setElements(List<T> jOFCElements);

    /**
     * 设置第index个图表元素
     * 
     * @param index
     * @param element
     */
    void setElement(int index, T element);

    /**
     * 追加一个图表元素
     * 
     * @param element
     */
    void appendElement(T element);

    /**
     * 设置第index个图表元素的数据
     * 
     * @param index
     * @param values
     */
    void setValues(int index, List<E> values);

    /**
     * 使用提供的数据附加一个图表元素
     * 
     * @param values
     */
    void appendValues(List<E> values);
}
