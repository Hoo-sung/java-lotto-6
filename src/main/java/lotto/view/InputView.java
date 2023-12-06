package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static String MONEY_INPUT_MESSAGE = "구입 금액을 입력해주세요.";
    private static String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String BONUS_NUM_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static InputView INPUT_VIEW = new InputView();

    private InputView() {

    }

    public int readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        String money = Console.readLine();
        //검증
        return Integer.parseInt(money);
    }

    public String readWinningLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
        String winningLotto = Console.readLine();
        //String이 유효한 형식인지 검증
        return winningLotto;
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUM_INPUT_MESSAGE);
        String bonusNumber = Console.readLine();
        //검증
        return Integer.parseInt(bonusNumber);
    }
}
