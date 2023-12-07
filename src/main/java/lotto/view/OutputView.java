package lotto.view;

import lotto.domain.Lotto;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.UserLottoResponse;
import lotto.dto.response.YieldResponse;

import static lotto.domain.Rank.*;
import static lotto.utils.Util.*;

public class OutputView {

    public static OutputView OUTPUT_VIEW = new OutputView();

    private final static String USER_LOTTO_START_MESSAGE = "\n%s개를 구매했습니다.";
    private final static String STATISTICS_START_MESSAGE = "\n당첨 통계\n---";
    private final static String PRIZE_UNIT = "개";
    private final static String STATISTIC_RESULT_MESSAGE = "총 수익률은 %s%%입니다.";

    private OutputView() {

    }

    public void printUserLotto(final UserLottoResponse userLottoResponse) {
        System.out.printf((USER_LOTTO_START_MESSAGE) + "%n", userLottoResponse.getSize());
        for (Lotto lotto : userLottoResponse.getUserLotto()) {
            System.out.println(lotto.toString());
        }
    }

    public void printStatistics(final RankResultResponse rankResultResponse, final YieldResponse yieldResponse) {
        System.out.println(STATISTICS_START_MESSAGE);
        System.out.println(FIFTH.toString() + rankResultResponse.getNumberOfRank(FIFTH) + PRIZE_UNIT);
        System.out.println(FOURTH.toString() + rankResultResponse.getNumberOfRank(FOURTH) + PRIZE_UNIT);
        System.out.println(THIRD.toString() + rankResultResponse.getNumberOfRank(THIRD) + PRIZE_UNIT);
        System.out.println(SECOND.toString() + rankResultResponse.getNumberOfRank(SECOND) + PRIZE_UNIT);
        System.out.println(FIRST.toString() + rankResultResponse.getNumberOfRank(FIRST) + PRIZE_UNIT);
        System.out.printf((STATISTIC_RESULT_MESSAGE) + "%n",makeFloatFormattedYield(yieldResponse.getYield(), 1));
    }

}
