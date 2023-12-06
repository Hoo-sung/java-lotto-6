package lotto.dto.request;

public class WinningLottoRequest {

    private final String winningLotto;

    public WinningLottoRequest(String winningLotto) {
        this.winningLotto = winningLotto;
    }
    public String getWinningLotto() {
        return winningLotto;
    }
}
