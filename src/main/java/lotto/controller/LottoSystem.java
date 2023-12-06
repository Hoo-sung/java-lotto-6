package lotto.controller;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;
import lotto.utils.RandomNumberGenerator;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.system.Constant.MONEY_UNIT;


public class LottoSystem {

    private final RankService rankService;
    private final YieldService yieldService;

    public LottoSystem(final RankService rankService, final YieldService yieldService) {
        this.rankService = rankService;
        this.yieldService = yieldService;
    }

    public RankResult applyRank(final WinningLotto winningLotto, final BonusNumber bonusNumber,
                                final UserLotto userLotto) {
        return rankService.calculateRank(winningLotto, bonusNumber, userLotto);
    }

    public Yield applyYield(final RankResult rankResult) {
        return new Yield(yieldService.createYield(rankResult));
    }

    public UserLotto applyUserLotto(final Money money) {
        int numberOfLottos = money.getMoney() / MONEY_UNIT;

        List<Lotto> lottos = IntStream.range(0, numberOfLottos)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.makeUniqueRandomList()))
                .collect(Collectors.toList());
        return new UserLotto(new LottoRepository(lottos));
    }


}
