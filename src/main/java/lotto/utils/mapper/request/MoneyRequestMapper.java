package lotto.utils.mapper.request;

import lotto.dto.request.MoneyRequest;

public class MoneyRequestMapper {

    public static MoneyRequest of(int money) {
        return new MoneyRequest(money);
    }
}
