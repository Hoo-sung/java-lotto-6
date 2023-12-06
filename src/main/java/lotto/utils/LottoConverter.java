package lotto.utils;

import java.util.ArrayList;
import java.util.List;

public class LottoConverter {

    public static List<Integer> convertStringToNumbers(String lotto){
        String[] stringNumbers = lotto.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
