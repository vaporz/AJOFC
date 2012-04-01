
package org.jofc.attribute.chart.element;

import net.sf.json.JSONObject;
import net.sf.json.JSONString;

import org.jofc.enums.PieAnimates;
import org.jofc.util.JOFCUtils;

public class PieAnimate implements JSONString {

    private String type = "fade";

    private int distance;

    public PieAnimate(PieAnimates animate) {
        switch (animate) {
        case BOUNCE:
            type = "bounce";
            distance = 10;
            break;
        case FADE:
            type = "fade";
            break;
        default:
            break;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }

    @Override
    public String toJSONString() {
        JSONObject jo = new JSONObject();
        JOFCUtils.appendJson(jo, "type", type);
        if ("bounce".equals(type)) {
            JOFCUtils.appendJson(jo, "distance", distance);
        }
        return jo.toString();
    }

}
