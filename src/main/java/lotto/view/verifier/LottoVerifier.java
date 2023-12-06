package lotto.view.verifier;

import lotto.system.ExceptionMessage;

public class LottoVerifier implements Verifier {

    /**
     * split한 각각이 숫자
     *
     * @param input
     */
    @Override
    public void validate(String input) {
        validateSplit(input);
    }

    private void validateSplit(String input) {
        String[] split = input.split(",");
        for (int i = 0; i < split.length; i++) {
            try {
                Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
            }
        }
    }


}
