package lotto.domain.service;

import lotto.domain.RankResult;
import lotto.domain.Yield;
import lotto.system.Constant;


public class YieldService {

    public Yield createYield(RankResult rankResult) {
        float beforeMoney = rankResult.calculateLottoNum() * Constant.MONEY_UNIT;
        float totalMoney = beforeMoney;
        totalMoney += rankResult.calculateEarnMoney();
        return new Yield((totalMoney) / beforeMoney * 100 - 100);
    }
}
