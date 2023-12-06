package lotto.view.verifier;

import static lotto.system.ExceptionMessage.INVALID_BONUS_NUMBER;

public class BonusNumberVerifier implements Verifier {

    /**
     * view에서의 검증: 숫자 아닌 입력에 대한 검증
     */

    @Override
    public void validate(String input) {
        validateNumeric(input);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }
}
