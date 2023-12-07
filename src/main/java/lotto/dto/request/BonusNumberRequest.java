package lotto.dto.request;

public class BonusNumberRequest {

    private final int bonusNumber;

    public BonusNumberRequest(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
