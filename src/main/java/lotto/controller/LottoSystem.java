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

    public LottoSystem(final RankService rankService, final YieldService yieldService) {
        this.rankService = rankService;
        this.yieldService = yieldService;
    }

    public RankResultResponse applyRank(final WinningLotto winningLotto, final BonusNumber bonusNumber,
                                        final UserLotto userLotto) {

        return RankResultResponseMapper.of(rankService.calculateRank(winningLotto, bonusNumber, userLotto));
    }

    public RankResult createRankResult(final WinningLotto winningLotto, final BonusNumber bonusNumber,
                                       final UserLotto userLotto) {

        return (rankService.calculateRank(winningLotto, bonusNumber, userLotto));
    }

    public YieldResponse applyYield(final RankResult rankResult) {
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
