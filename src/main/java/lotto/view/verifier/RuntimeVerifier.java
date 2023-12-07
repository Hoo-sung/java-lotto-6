package lotto.view.verifier;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

import static lotto.system.ExceptionMessage.RUNTIME_ERROR_MESSAGE;

public class RuntimeVerifier {

    public static RuntimeVerifier RUNTIME_VERIFIER = new RuntimeVerifier();

    private RuntimeVerifier() {

    }

    public void validate(WinningLotto winningLotto, int bonusNumber) {
        Lotto lotto = winningLotto.getWinningLotto();
        for (Integer number : lotto.getNumbers()) {
            if (number.equals(bonusNumber)) {
                throw new IllegalStateException(RUNTIME_ERROR_MESSAGE);
            }
        }
    }
}
