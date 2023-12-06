package lotto.domain;

import lotto.system.ExceptionMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final static int START_NUM = 1;
    private final static int END_NUM = 45;

    private final List<Integer> numbers;

    /** Lotto domain 검증 로직
     * 1. 숫자가 6개인지
     * 2. 중복되지 않은 숫자들인지
     * 3. 각각이 1-9까지의 숫자들인지
     */

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDistinct(numbers);

    }

    private void validateLottoLength(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers){
        for(Integer number : numbers){
            if(number< START_NUM || number > END_NUM){
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
            }
        }
    }

    private void validateLottoNumberDistinct(List<Integer> numbers){
        Set<Integer> uniqueNumbers = new HashSet<>();
        for(Integer number : numbers){
            if(!uniqueNumbers.add(number)){//중복된 숫자가 들어오면,
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
            }
        }
    }
}
