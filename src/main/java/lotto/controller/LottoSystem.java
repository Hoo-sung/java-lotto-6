package lotto.controller;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;
import lotto.utils.RandomNumberGenerator;
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
        int numberOfLotto = money.getMoney() / MONEY_UNIT;

        LottoRepository lottoRepository = new LottoRepository();

        IntStream.range(0, numberOfLotto)
                .forEach(i -> lottoRepository.add(new Lotto(RandomNumberGenerator.makeUniqueRandomList())));

        return new UserLotto(lottoRepository);
    }


}
