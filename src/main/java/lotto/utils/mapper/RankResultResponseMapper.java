package lotto.utils.mapper;

import lotto.domain.RankResult;
import lotto.dto.response.RankResultResponse;

public class RankResultResponseMapper {

    public static RankResultResponse of(RankResult rankResult){
        return new RankResultResponse(rankResult.getRankResult());
    }
}
