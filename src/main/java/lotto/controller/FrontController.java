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

    /**
     * ReqDto를 삭제함 --> 정상 입력을 받을때까지 계속 입력을 받으므로 View, Domain에서 검증 로직을 모두 거친 도메인이 Service
     * 로 전달되어야 함.
     * 도메인에서의 검증 로직때문에 ReqDto를 만들어 Service 계층으로 보내는 구조가 안된다.
     * 이유: 정상 입력 받을때 까지 계속 입력 받아야 하므로 ReqDto 대신 검증된 도메인 을 인자로 전달 해야 한다.
     */

    public FrontController(LottoSystem lottoController) {
        this.lottoSystem = lottoController;
    }

    public void run() {
        Money money = createMoney();
        UserLotto userLotto = lottoSystem.createUserLotto(money);
        UserLottoResponse userLottoResponse = UserLottoResponseMapper.of(userLotto);
        OUTPUT_VIEW.printUserLotto(userLottoResponse);

        WinningLotto winningLotto = createWinningLotto();
        BonusNumber bonusNumber = createBonusNumber(winningLotto);

        renderResult(winningLotto, bonusNumber, userLotto);

    }

    private Money createMoney() {
        return ExceptionHandler.handle(() -> {
            int money = INPUT_VIEW.readMoney();
            return new Money(money);
        });
    }

    private WinningLotto createWinningLotto() {
        return ExceptionHandler.handle(() -> {
            List<Integer> lotto = INPUT_VIEW.readWinningLotto();
            return new WinningLotto(new Lotto(lotto));
        });
    }

    private BonusNumber createBonusNumber(WinningLotto winningLotto) {
        return ExceptionHandler.handle(() -> {
            int bonusNumber = INPUT_VIEW.readBonusNumber();
            RUNTIME_VERIFIER.validate(winningLotto, bonusNumber);
            return new BonusNumber(bonusNumber);
        });
    }

    private void renderResult(WinningLotto winningLotto, BonusNumber bonusNumber, UserLotto userLotto) {
        RankResult rankResult = lottoSystem.applyRank(winningLotto, bonusNumber, userLotto);
        Yield yield = lottoSystem.applyYield(rankResult);

        RankResultResponse rankResultResponse = RankResultResponseMapper.of(rankResult);
        YieldResponse yieldResponse = YieldResponseMapper.of(yield);
        OUTPUT_VIEW.printStatistics(rankResultResponse, yieldResponse);
    }


}
