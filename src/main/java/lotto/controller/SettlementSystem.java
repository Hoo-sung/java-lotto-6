package lotto.controller;

import lotto.domain.Award;
import lotto.domain.BonusNumber;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.io.OutputHandler;
import lotto.manager.AwardManager;
import lotto.manager.YieldManager;


import java.util.List;

public class SettlementSystem {

    private List<Award> awards;

    private float yield;

    public void makeResult(WinningLotto winningLotto, UserLotto userLotto, BonusNumber bonusNumber) {
        awards = AwardManager.makeAwards(winningLotto, userLotto, bonusNumber);
        yield = YieldManager.makeYield(awards);
    }

    public void renderResult() {
        OutputHandler.printReward(awards);
        OutputHandler.printYield(yield);
    }
}
