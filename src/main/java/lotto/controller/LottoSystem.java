package lotto.controller;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.YieldResponse;
import lotto.utils.RandomNumberGenerator;
import lotto.utils.mapper.RankResultResponseMapper;
import lotto.utils.mapper.YieldResponseMapper;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private final RankService rankService;
    private final YieldService yieldService;

    public LottoSystem(RankService rankService, YieldService yieldService) {
        this.rankService = rankService;
        this.yieldService = yieldService;
    }

    public RankResultResponse applyRank(WinningLotto winningLotto, BonusNumber bonusNumber, UserLotto userLotto) {
        return RankResultResponseMapper.of(rankService.calculateRank(winningLotto, bonusNumber, userLotto));
    }

    public YieldResponse applyYield(RankResult rankResult) {
        return YieldResponseMapper.of(yieldService.createYield(rankResult));
    }

    public UserLotto applyUserLotto(final Money money) {
        LottoRepository userRepository = new LottoRepository(new ArrayList<>());
        int number = money.getMoney() / 1000;
        for (int i = 0; i < number; i++) {
            List<Integer> lotto = RandomNumberGenerator.makeUniqueRandomList();
            userRepository.add(new Lotto(lotto));
        }
        return new UserLotto(userRepository);
    }

}
