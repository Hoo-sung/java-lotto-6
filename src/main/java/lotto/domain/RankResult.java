package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

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
        for (Map.Entry<Rank,Integer> component : rankResult.entrySet()) {
            totalEarnMoney += (component.getKey().getWinningMoney() * component.getValue());
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
