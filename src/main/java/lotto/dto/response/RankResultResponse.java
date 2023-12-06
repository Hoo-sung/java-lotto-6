package lotto.dto.response;

import lotto.domain.Rank;

import java.util.EnumMap;

public class RankResultResponse {
    private final EnumMap<Rank, Integer> rankResult;

    public RankResultResponse(EnumMap<Rank, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public int getNumberOfRank(Rank rank){
       return rankResult.get(rank);
    }
}
