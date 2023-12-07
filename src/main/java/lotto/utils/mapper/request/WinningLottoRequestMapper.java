package lotto.utils.mapper.request;

import lotto.domain.Lotto;
import lotto.dto.request.WinningLottoRequest;

import java.util.List;


public class WinningLottoRequestMapper {

    public static WinningLottoRequest of(List<Integer> lotto){
        return new WinningLottoRequest(new Lotto(lotto));
    }
}
