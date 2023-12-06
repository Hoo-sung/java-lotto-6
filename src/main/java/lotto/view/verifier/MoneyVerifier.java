package lotto.view.verifier;

import java.math.BigInteger;

public class MoneyVerifier implements Verifier{

    /**
     * 1. 입력값이 숫자인지
     * 2. 유효한 범위(Integer)의 입려값인지를 검증
     */
    private static String IS_NOT_NUMERIC = "[ERROR]: 입력한 돈이 숫자가 아닙니다.";
    private static String IS_NOT_VALID_RANGE = "[ERROR]: 입력한 돈이 유효한 범위의 수가 아닙니다.";

    @Override
    public void validate(String input) {
        validateNumeric(input);
        validateTypeRange(input);
    }

    private void validateNumeric(String input) {
        try {
            new BigInteger(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(IS_NOT_NUMERIC);
        }
    }

    private void validateTypeRange(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_VALID_RANGE);
        }
    }
}
