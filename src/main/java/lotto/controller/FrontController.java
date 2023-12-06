package lotto.controller;

import lotto.domain.*;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.YieldResponse;

import java.util.List;

import static lotto.view.InputView.INPUT_VIEW;
import static lotto.view.OutputView.OUTPUT_VIEW;

public class FrontController {

    private final LottoSystem lottoSystem;

    public FrontController(LottoSystem lottoController) {
        this.lottoSystem = lottoController;
    }

    public void run() {
        Money money = moneySetting();
        UserLotto userLotto = lottoSystem.applyUserLotto(money);
        OUTPUT_VIEW.printUserLotto(userLotto);
        WinningLotto winningLotto = winningLottoSetting();
        BonusNumber bonusNumber = bonusNumberSetting();
        //Runtime Validate 해야함.
        RankResult rankResult = lottoSystem.createRankResult(winningLotto, bonusNumber, userLotto);
        YieldResponse yieldResponse = lottoSystem.applyYield(rankResult);
        RankResultResponse rankResultResponse = lottoSystem.applyRank(winningLotto, bonusNumber, userLotto);

        OUTPUT_VIEW.printStatistics(rankResultResponse,yieldResponse);

    }

    private Money moneySetting() {
        return ExceptionHandler.handle(() -> {
            return new Money(INPUT_VIEW.readMoney());
        });
    }

    private BonusNumber bonusNumberSetting() {
        return ExceptionHandler.handle(() -> {
            int bonusNumber = INPUT_VIEW.readBonusNumber();
            return new BonusNumber(bonusNumber);
        });
    }

    private WinningLotto winningLottoSetting() {
        return ExceptionHandler.handle(() -> {
            List<Integer> lotto = INPUT_VIEW.readWinningLotto();
            return new WinningLotto(new Lotto(lotto));
        });
    }


}
