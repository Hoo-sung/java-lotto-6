package lotto.domain.service;

import lotto.domain.*;

import java.util.EnumMap;

public class RankService {

    public EnumMap<Rank,Integer> calculateRank(WinningLotto winningLotto , BonusNumber bonusNumber, UserLotto userLotto){
        EnumMap<Rank, Integer> createMap = createMap();
        for(Lotto lotto : userLotto.getUserLotto()){
            Rank rank = calculateLottoRank(winningLotto, bonusNumber, lotto);
            createMap.put(rank, createMap.get(rank) + 1);
        }
        return createMap;
    }

    private Rank calculateLottoRank(WinningLotto winningLotto, BonusNumber bonusNumber, Lotto lotto){
        int grade = winningLotto.grade(lotto);
        boolean contains = lotto.contains(bonusNumber.getBonusNumber());
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
