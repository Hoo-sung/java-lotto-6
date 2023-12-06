package lotto.domain;

public class Money {

    /**
     * 돈이 양수인지 검증한다.
     * 돈이 1000으로 나눠떨어지는지 검증한다.
     */

    private static final int UNIT = 1000;
    private static final String IS_NOT_VALID_RANGE = "[ERROR]: 돈은 0보다 큰 정수이어야 합니다.";
    private static final String IS_NOT_DIVIDABLE = "[ERROR]: 돈이 1000원으로 나눠 떨어지지 않습니다.";

    private final int money;

    public Money(int money) {
        validate(money);
        this.money = money;
    }

    private void validate(int money){
        validateMoneyRange(money);
        validateDividable(money);
    }

    private void validateMoneyRange(int money){
        if(money<=0)
            throw new IllegalArgumentException(IS_NOT_VALID_RANGE);
    }

    private void validateDividable(int money){
        if(money % UNIT !=0){
            throw new IllegalArgumentException(IS_NOT_DIVIDABLE);
        }
    }

    public int getMoney() {
        return money;
    }
}
