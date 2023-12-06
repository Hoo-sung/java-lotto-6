package lotto.domain;

import lotto.system.ExceptionMessage;
import lotto.utils.RandomNumberGenerator;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final static int START_NUM = 1;
    private final static int END_NUM = 45;

    private final List<Integer> numbers;

    /**
     * Lotto domain 검증 로직
     * 1. 숫자가 6개인지
     * 2. 중복되지 않은 숫자들인지
     * 3. 각각이 1-9까지의 숫자들인지
     * <p>
     * Lotto는 숫자 오름차순으로 정렬해서 만듬.
     */

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int compareWithAnotherLotto(Lotto another) {
        return (int) numbers.stream()
                .filter(another::contains)
                .count();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoLength(numbers);
        validateLottoNumberRange(numbers);
        validateLottoNumberDistinct(numbers);

    }

    private void validateLottoLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUM || number > END_NUM) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
            }
        }
    }

    private void validateLottoNumberDistinct(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {//중복된 숫자가 들어오면,
                throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO);
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
