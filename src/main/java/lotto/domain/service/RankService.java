package lotto.domain.service;

import lotto.domain.*;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.WinningLottoRequest;

import java.util.EnumMap;

public class RankService {

    public RankResult calculateRank(WinningLottoRequest winningLottoRequest , BonusNumberRequest bonusNumberRequest, UserLotto userLotto){
        EnumMap<Rank, Integer> createMap = createMap();
        for(Lotto lotto : userLotto.getUserLotto()){
            Rank rank = calculateLottoRank(winningLottoRequest, bonusNumberRequest, lotto);
            createMap.put(rank, createMap.get(rank) + 1);
        }
        return new RankResult(createMap);
    }

    private Rank calculateLottoRank(WinningLottoRequest winningLottoRequest , BonusNumberRequest bonusNumberRequest, Lotto lotto){

        WinningLotto winningLotto = new WinningLotto(winningLottoRequest.getWinningLotto());
        int grade = winningLotto.grade(lotto);
        boolean contains = lotto.contains(bonusNumberRequest.getBonusNumber());
        return Rank.makeRank(grade,contains);
    }

    private EnumMap<Rank,Integer> createMap(){
        EnumMap<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
        rankMap.put(Rank.MISS,0);
        rankMap.put(Rank.FIFTH,0);
        rankMap.put(Rank.FOURTH,0);
        rankMap.put(Rank.THIRD,0);
        rankMap.put(Rank.SECOND,0);
        rankMap.put(Rank.FIRST,0);
        return rankMap;
    }
}
