package lotto.utils.mapper.response;

import lotto.domain.UserLotto;
import lotto.dto.response.UserLottoResponse;

public class UserLottoResponseMapper {

    public static UserLottoResponse of(UserLotto userLotto){
        return new UserLottoResponse(userLotto.getUserLotto());
    }
}
