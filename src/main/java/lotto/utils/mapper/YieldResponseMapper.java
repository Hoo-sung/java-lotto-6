package lotto.utils.mapper;

import lotto.dto.response.YieldResponse;

public class YieldResponseMapper {

    public static YieldResponse of (float yield){
        return new YieldResponse(yield);
    }
}
