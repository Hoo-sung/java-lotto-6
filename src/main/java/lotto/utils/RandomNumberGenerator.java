package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumberGenerator {

    private final static int START_NUM = 1;
    private final static int END_NUM = 45;

    private final static int COUNT = 6;

    private RandomNumberGenerator() {

    }

    public static List<Integer> makeUniqueRandomList() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT);
    }

}
