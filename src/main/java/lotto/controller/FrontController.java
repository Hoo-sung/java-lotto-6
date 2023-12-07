package lotto.controller;

import lotto.domain.*;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningLottoRequest;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.UserLottoResponse;
import lotto.dto.response.YieldResponse;
import lotto.utils.mapper.request.BonusNumberRequestMapper;
import lotto.utils.mapper.request.MoneyRequestMapper;
import lotto.utils.mapper.request.WinningLottoRequestMapper;
import lotto.utils.mapper.response.RankResultResponseMapper;
import lotto.utils.mapper.response.UserLottoResponseMapper;
import lotto.utils.mapper.response.YieldResponseMapper;


import static lotto.view.InputView.INPUT_VIEW;
import static lotto.view.OutputView.OUTPUT_VIEW;
import static lotto.view.verifier.RuntimeVerifier.RUNTIME_VERIFIER;

public class FrontController {

    private final LottoSystem lottoSystem;

    public FrontController(LottoSystem lottoController) {
        this.lottoSystem = lottoController;
    }

    public void run() {
        MoneyRequest moneyRequest = createMoneyRequest();
        UserLotto userLotto = lottoSystem.createUserLotto(moneyRequest);
        UserLottoResponse userLottoResponse = UserLottoResponseMapper.of(userLotto);
        OUTPUT_VIEW.printUserLotto(userLottoResponse);

        WinningLottoRequest winningLottoRequest = createWinningLottoRequest();
        BonusNumberRequest bonusNumberRequest = createBonusNumberRequest(winningLottoRequest);

        renderResult(winningLottoRequest, bonusNumberRequest, userLotto);

    }

    private MoneyRequest createMoneyRequest() {
        return ExceptionHandler.handle(() -> MoneyRequestMapper.of(INPUT_VIEW.readMoney()));
    }

    private WinningLottoRequest createWinningLottoRequest() {
        return ExceptionHandler.handle(() -> WinningLottoRequestMapper.of(INPUT_VIEW.readWinningLotto()));
    }

    private BonusNumberRequest createBonusNumberRequest(WinningLottoRequest winningLottoRequest) {
        return ExceptionHandler.handle(() -> {
            int bonusNumber = INPUT_VIEW.readBonusNumber();
            BonusNumberRequest bonusNumberRequest = BonusNumberRequestMapper.of(bonusNumber);
            RUNTIME_VERIFIER.validate(winningLottoRequest,bonusNumberRequest);
            return bonusNumberRequest;
        });
    }

    private void renderResult(WinningLottoRequest winningLottoRequest, BonusNumberRequest bonusNumberRequest, UserLotto userLotto) {
        RankResult rankResult = lottoSystem.applyRank(winningLottoRequest, bonusNumberRequest, userLotto);
        Yield yield = lottoSystem.applyYield(rankResult);

        RankResultResponse rankResultResponse = RankResultResponseMapper.of(rankResult);
        YieldResponse yieldResponse = YieldResponseMapper.of(yield);
        OUTPUT_VIEW.printStatistics(rankResultResponse, yieldResponse);
    }


}
