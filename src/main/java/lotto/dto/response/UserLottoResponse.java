package lotto.dto.response;

import lotto.domain.Lotto;
import java.util.Collections;
import java.util.List;

public class UserLottoResponse {
    private final List<Lotto> userLotto;

    public UserLottoResponse(List<Lotto> userLotto) {
        this.userLotto = userLotto;
    }

    public List<Lotto> getUserLotto() {
        return Collections.unmodifiableList(userLotto);
    }

    public int getSize(){
        return userLotto.size();
    }
}
