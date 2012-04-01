
package org.jofc.builder;

import org.jofc.enums.Chart;
import org.jofc.itf.JOFCElement;
import org.jofc.itf.JOFCValue;

public final class JOFCFactory {

    private JOFCFactory() {

    }

    public static JOFCBaseBuilder<? extends JOFCElement<? extends JOFCValue>, ? extends JOFCValue> getBuilder(Chart chart) {
        switch (chart) {
        case LINE:
            return new LineBuilder();
        case PIE:
            return new PieBuilder();
        case BAR:
            return new BarBuilder();
        case CANDLE:
            return new CandleBuilder();
        case HORIZONTAL_BAR:
            return new HorizontalBarBuilder();
        case AREA:
            return new AreaBuilder();
        case RADAR:
            return new RadarBuilder();
        case SCATTER:
            return new ScatterBuilder();
        case STACKEDBAR:
            return new StackedBarBuilder();
        default:
            return null;
        }
    }
}
