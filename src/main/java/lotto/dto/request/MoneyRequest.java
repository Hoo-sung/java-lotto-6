package lotto.dto.request;

public class MoneyRequest {

    private final String money;

    public MoneyRequest(String money) {
        this.money = money;
    }
    public String getMoney() {
        return money;
    }
}
