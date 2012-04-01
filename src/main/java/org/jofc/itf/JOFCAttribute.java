package org.jofc.itf;

import net.sf.json.JSONString;

/**
 * 仅次于{@link JOFCChart}
 * 的高层次的抽象，所有最外层属性的实现类都要实现这个接口，比如“elements”，“x_axis”，“y_axis”，“title”等
 * 
 * @author 张啸[zzxx513@163.com]
 * 
 */
public interface JOFCAttribute extends JSONString {

    /**
     * 得到属性名，用于构造json串，按照OFC的规范返回正确的属性名，比如“elements”，“x_axis”，“y_axis”，“
     * title”等
     * 
     * @return String
     */
    String getAttributeName();

    /**
     * 返回此属性的值，这个方法的作用是，构造json串时判断是否需要添加这个属性，如果返回值是null则不添加此属性，比如，对于一些属性，
     * 值小于等于0是没有意义的， 所以实现此方法时判断属性值是否小于等于0，如果是则返回null
     * 
     * @return Object
     */
    Object getAttributeValue();
}
