package lotto.utils.mapper.request;

import lotto.dto.request.BonusNumberRequest;

public class BonusNumberRequestMapper {
    public static BonusNumberRequest of (int bonusNumber){
        return new BonusNumberRequest(bonusNumber);
    }
}
