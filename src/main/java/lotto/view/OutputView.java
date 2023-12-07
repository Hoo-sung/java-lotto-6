package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.UserLottoResponse;
import lotto.dto.response.YieldResponse;
import lotto.utils.Util;

import static lotto.utils.Util.*;

public class OutputView {

    public static OutputView OUTPUT_VIEW = new OutputView();

    private final static String USER_LOTTO_START_MESSAGE = "\n%s개를 구매했습니다.";
    private final static String STATISTICS_START_MESSAGE = "\n당첨 통계\n---";
    private final static String PRIZE_UNIT = "개";

    private OutputView() {

    }

    public void printUserLotto(final UserLottoResponse userLottoResponse) {
        System.out.println(String.format(USER_LOTTO_START_MESSAGE, userLottoResponse.getSize()));
        for (Lotto lotto : userLottoResponse.getUserLotto()) {
            System.out.println(lotto.toString());
        }
    }

    public void printStatistics(final RankResultResponse rankResultResponse, final YieldResponse yieldResponse) {
        System.out.println(STATISTICS_START_MESSAGE);
        System.out.println("3개 일치 (5,000원) - " + rankResultResponse.getNumberOfRank(Rank.FIFTH) + PRIZE_UNIT);
        System.out.println("4개 일치 (50,000원) - " + rankResultResponse.getNumberOfRank(Rank.FOURTH) + PRIZE_UNIT);
        System.out.println("5개 일치 (1,500,000원) - " + rankResultResponse.getNumberOfRank(Rank.THIRD) + PRIZE_UNIT);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankResultResponse.getNumberOfRank(Rank.SECOND) + PRIZE_UNIT);
        System.out.println("6개 일치 (2,000,000,000원) - " + rankResultResponse.getNumberOfRank(Rank.FIRST) + PRIZE_UNIT);
        System.out.println("총 수익률은 " + makeFloatFormattedYield(yieldResponse.getYield(), 1) + "%입니다.");
    }

}
