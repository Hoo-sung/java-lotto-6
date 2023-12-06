package lotto.domain;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank makeRank(int grade, boolean containsBonusNumber){
        if(grade == FIRST.countOfMatch){
            return Rank.FIRST;
        }
        if(grade == SECOND.countOfMatch && containsBonusNumber){
            return Rank.SECOND;
        }
        if(grade == THIRD.countOfMatch){
            return Rank.THIRD;
        }
        if(grade == FOURTH.countOfMatch ){
            return Rank.FOURTH;
        }
        if(grade == FIFTH.countOfMatch){
            return Rank.FIFTH;
        }

        return Rank.MISS;
    }

}
