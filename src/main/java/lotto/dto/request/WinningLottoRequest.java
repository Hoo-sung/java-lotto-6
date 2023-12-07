package lotto.dto.request;

import lotto.domain.Lotto;

public class WinningLottoRequest {

    private final Lotto winningLotto;

    public WinningLottoRequest(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
