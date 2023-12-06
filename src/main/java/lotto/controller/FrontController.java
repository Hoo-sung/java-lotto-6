package lotto.controller;

import lotto.domain.*;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.UserLottoResponse;
import lotto.dto.response.YieldResponse;
import lotto.utils.mapper.response.RankResultResponseMapper;
import lotto.utils.mapper.response.UserLottoResponseMapper;
import lotto.utils.mapper.response.YieldResponseMapper;

import java.util.List;

import static lotto.view.InputView.INPUT_VIEW;
import static lotto.view.OutputView.OUTPUT_VIEW;
import static lotto.view.verifier.RuntimeVerifier.RUNTIME_VERIFIER;

public class FrontController {

    private final LottoSystem lottoSystem;

    public FrontController(LottoSystem lottoController) {
        this.lottoSystem = lottoController;
    }

    public void run() {
        Money money = moneySetting();
        UserLotto userLotto = lottoSystem.applyUserLotto(money);
        UserLottoResponse userLottoResponse = UserLottoResponseMapper.of(userLotto);
        OUTPUT_VIEW.printUserLotto(userLottoResponse);

        WinningLotto winningLotto = winningLottoSetting();
        BonusNumber bonusNumber = bonusNumberSetting(winningLotto);

        renderResult(userLotto, winningLotto, bonusNumber);
    }

    private Money moneySetting() {
        return ExceptionHandler.handle(() -> new Money(INPUT_VIEW.readMoney()));
    }

    private BonusNumber bonusNumberSetting(WinningLotto winningLotto) {
        return ExceptionHandler.handle(() -> {
            int bonusNumber = INPUT_VIEW.readBonusNumber();
            RUNTIME_VERIFIER.validate(winningLotto, bonusNumber);
            return new BonusNumber(bonusNumber);
        });
    }

    private WinningLotto winningLottoSetting() {
        return ExceptionHandler.handle(() -> {
            List<Integer> lotto = INPUT_VIEW.readWinningLotto();
            return new WinningLotto(new Lotto(lotto));
        });
    }

    private void renderResult(UserLotto userLotto, WinningLotto winningLotto, BonusNumber bonusNumber) {
        RankResult rankResult = lottoSystem.applyRank(winningLotto, bonusNumber, userLotto);
        Yield yield = lottoSystem.applyYield(rankResult);

        RankResultResponse rankResultResponse = RankResultResponseMapper.of(rankResult);
        YieldResponse yieldResponse = YieldResponseMapper.of(yield);
        OUTPUT_VIEW.printStatistics(rankResultResponse, yieldResponse);
    }


}
