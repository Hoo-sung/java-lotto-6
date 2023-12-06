package lotto.domain;


import static lotto.system.ExceptionMessage.INVALID_BONUS_NUMBER;

public class BonusNumber {


    /**
     * 보너스 번호가 유효한 범위의 숫자인지 검증해야 한다.
     */
    private final static int START_NUM = 1;
    private final static int END_NUM = 45;
    private final int bonusNumber;


    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateNumberRange(bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < START_NUM || bonusNumber > END_NUM) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }
}
