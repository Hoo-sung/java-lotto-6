package lotto.controller;

import lotto.domain.*;
import lotto.utils.StringToLotto;


import static lotto.view.InputView.INPUT_VIEW;

public class FrontController {

    private final LottoSystem lottoSystem;

    public FrontController(LottoSystem lottoController) {
        this.lottoSystem = lottoController;
    }

    public void run() {
        Money money = moneySetting();
        UserLotto userLotto = lottoSystem.applyUserLotto(money);
        BonusNumber bonusNumber = bonusNumberSetting();
        WinningLotto winningLotto = winningLottoSetting();



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
            String winningLotto = INPUT_VIEW.readWinningLotto();
            Lotto lotto = StringToLotto.convertToLotto(winningLotto);
            return new WinningLotto(lotto);
        });
    }


}
