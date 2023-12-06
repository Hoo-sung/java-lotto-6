package lotto.dto.response;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class UserLottoResponse {
    private final List<Lotto> userLottos;

    public UserLottoResponse(List<Lotto> userLottos) {
        this.userLottos = userLottos;
    }

    public List<Lotto> getUserLottos() {
        return Collections.unmodifiableList(userLottos);
    }

    public int getSize(){
        return userLottos.size();
    }
}
