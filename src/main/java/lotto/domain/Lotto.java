package lotto.domain;

import lotto.io.OutputHandler;
import lotto.verifier.LottoVerifier;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String forCheck = String.join(",", numbers.stream().map(Object::toString).collect(Collectors.toList()));
        new LottoVerifier().check(forCheck);
    }

    public boolean contains(int number){
        return numbers.contains(number);
    }

    public void printLottoInfo(){
        OutputHandler.printLotto(numbers);
    }

    public int compareWithAnotherLotto(Lotto another){
        int count=0;
        for(int i=0;i<6;i++){
            if(another.contains(numbers.get(i)))
                count++;
        }
        return count;
    }

}
