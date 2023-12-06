package lotto.domain;


public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningNumbers) {
        this.winningLotto = winningNumbers;
    }
    public int grade(Lotto lotto){
        return winningLotto.compareWithAnotherLotto(lotto);
    }
}
