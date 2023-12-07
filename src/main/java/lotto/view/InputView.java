package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Util;
import lotto.view.verifier.BonusNumberVerifier;
import lotto.view.verifier.LottoVerifier;
import lotto.view.verifier.MoneyVerifier;

import java.util.List;

import static lotto.utils.Util.*;

public class InputView {

    private static String MONEY_INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    private static String WINNING_LOTTO_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static String BONUS_NUM_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static InputView INPUT_VIEW = new InputView();

    private final MoneyVerifier moneyVerifier = new MoneyVerifier();
    private final LottoVerifier lottoVerifier = new LottoVerifier();
    private final BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();

    private InputView() {

    }

    public int readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        moneyVerifier.validate(money);
        return Integer.parseInt(money);
    }

    public List<Integer> readWinningLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        String winningLotto = Console.readLine();
        lottoVerifier.validate(winningLotto);
        return convertStringToNumbers(winningLotto);
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUM_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        bonusNumberVerifier.validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
