package lotto.domain.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private final List<Lotto> lottoRepository;

    public LottoRepository() {
        this.lottoRepository = new ArrayList<>();
    }

    public void add(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public List<Lotto> getLottoRepository() {
        return Collections.unmodifiableList(lottoRepository);
    }

    public int size() {
        return lottoRepository.size();
    }

}
