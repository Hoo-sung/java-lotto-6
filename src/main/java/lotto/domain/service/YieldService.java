package lotto.domain.service;

import lotto.domain.RankResult;
import lotto.system.Constant;


public class YieldService {

    public static float createYield(RankResult rankResult) {
        float beforeMoney = rankResult.calculateLottoNum() * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        totalMoney += rankResult.calculateEarnMoney();
        return (totalMoney) / beforeMoney * 100 - 100;
    }
}
