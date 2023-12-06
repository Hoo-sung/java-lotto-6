package lotto.utils.mapper.response;

import lotto.domain.Yield;
import lotto.dto.response.YieldResponse;

public class YieldResponseMapper {

    public static YieldResponse of (Yield yield){
        return new YieldResponse(yield.getYield());
    }
}
