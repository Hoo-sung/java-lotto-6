package lotto.view.verifier;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.WinningLottoRequest;

import static lotto.system.ExceptionMessage.RUNTIME_ERROR_MESSAGE;

public class RuntimeVerifier {

    public static RuntimeVerifier RUNTIME_VERIFIER = new RuntimeVerifier();

    private RuntimeVerifier() {

    }

    public void validate(WinningLottoRequest winningLottoRequest, BonusNumberRequest bonusNumberRequest) {
        Lotto lotto = winningLottoRequest.getWinningLotto();
        for (Integer number : lotto.getNumbers()) {
            if (number.equals(bonusNumberRequest.getBonusNumber())) {
                throw new IllegalStateException(RUNTIME_ERROR_MESSAGE);
            }
        }
    }
}
