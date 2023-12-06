package lotto.domain.repository;

import lotto.domain.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoRepository {

    /**
     * 로또저장소이다. 로또저장소에 로또를 추가하는 기능
     */

    private final List<Lotto> lottoRepository;

    public LottoRepository(List<Lotto> lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    public void add(Lotto lotto) {
        lottoRepository.add(lotto);
    }

    public List<Lotto> getLottoRepository(){
        return Collections.unmodifiableList(lottoRepository);
    }

    public Lotto get(int index) {
        return lottoRepository.get(index);
    }

    public int size() {
        return lottoRepository.size();
    }

}
