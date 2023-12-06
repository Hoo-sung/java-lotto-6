package lotto.utils;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class StringToLotto {

    public static Lotto convertToLotto(String lotto){
        String[] stringNumbers = lotto.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : stringNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return new Lotto(numbers);
    }
}
