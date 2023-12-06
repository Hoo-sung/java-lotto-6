package lotto.domain;

import lotto.domain.repository.LottoRepository;

public class UserLotto {
    private final LottoRepository userlottoRepository;

    public UserLotto(LottoRepository lottoRepository) {
        this.userlottoRepository = lottoRepository;
    }

    public Lotto getIndexAt(int index){
        return userlottoRepository.get(index);
    }
    public int size(){
        return userlottoRepository.size();
    }
}
