package lotto.view.verifier;


import java.math.BigInteger;

import static lotto.system.ExceptionMessage.INVALID_MONEY;


public class MoneyVerifier implements Verifier{

    /**
     * 1. 입력값이 숫자인지
     * 2. 유효한 범위(Integer)의 입려값인지를 검증
     */


    @Override
    public void validate(String input) {
        validateNumeric(input);
        validateTypeRange(input);
    }

    private void validateNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }

    private void validateTypeRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MONEY);
        }
    }
}
