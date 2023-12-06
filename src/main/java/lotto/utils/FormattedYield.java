package lotto.utils;

import java.text.DecimalFormat;

public class FormattedYield {
    public static String makeFloatFormattedYield(float target, int precision) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", target);
        return formatter.format(Float.parseFloat(rounded));
    }
}
