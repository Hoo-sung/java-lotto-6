package lotto.domain;

import java.util.EnumMap;

public class RankResult {

    private final EnumMap<Rank, Integer> rankResult;

    public RankResult(EnumMap<Rank, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public EnumMap<Rank, Integer> getRankResult() {
        return rankResult;
    }

    public int calculateEarnMoney() {
        int totalEarnMoney = 0;
        for (Integer value : rankResult.values()) {
            totalEarnMoney += value;
        }
        return totalEarnMoney;
    }

    public int calculateLottoNum() {
        int sum = 0;
        for (Integer value : rankResult.values()) {
            sum += value;
        }
        return sum;
    }
}
