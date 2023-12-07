package lotto.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Util {

    private Util() {
    }

    public static String makeFloatFormattedYield(float target, int precision) {
        DecimalFormat formatter = new DecimalFormat("###,##0.0");
        String rounded = String.format("%." + precision + "f", target);
        return formatter.format(Float.parseFloat(rounded));
    }

    public static List<Integer> convertStringToNumbers(String lotto) {
        String[] stringNumbers = lotto.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
