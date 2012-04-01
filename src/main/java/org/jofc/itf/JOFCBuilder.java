package org.jofc.itf;

/**
 * builder需要实现的接口，表示整个图表，最顶层的抽象，包括标题，XY坐标轴，图表元素，附加属性等数据
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 * @param <T> 实现了{@link JOFCElement}接口的类
 * @param <E> 实现了{@link JOFCValue}接口的类
 */
public interface JOFCBuilder<T extends JOFCElement<E>, E extends JOFCValue> {
}
