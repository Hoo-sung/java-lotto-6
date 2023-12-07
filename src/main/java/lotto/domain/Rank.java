package lotto.domain;

public enum Rank {

    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000,"5개 일치"),
    FOURTH(4, 50_000,"4개 일치"),
    FIFTH(3, 5_000,"3개 일치"),
    MISS(0, 0,"3개 미만 일치");

    private final int countOfMatch;
    private final int reward;

    private final String matchStatus;

    Rank(int countOfMatch, int reward, String matchStatus) {
        this.countOfMatch = countOfMatch;
        this.reward = reward;
        this.matchStatus = matchStatus;
    }

    public int getReward() {
        return reward;
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

    @Override
    public String toString() {
        return this.matchStatus+" "+"("+String.format("%,d원",this.reward)+")"+" - ";
    }
}
