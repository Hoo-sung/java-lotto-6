package lotto.controller;

import lotto.domain.*;
import lotto.domain.repository.LottoRepository;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;
import lotto.dto.request.BonusNumberRequest;
import lotto.dto.request.MoneyRequest;
import lotto.dto.request.WinningLottoRequest;
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

    public RankResult applyRank(final WinningLottoRequest winningLottoRequest, final BonusNumberRequest bonusNumberRequest,
                                        final UserLotto userLotto) {
        return rankService.calculateRank(winningLottoRequest, bonusNumberRequest, userLotto);
    }

    public Yield applyYield(final RankResult rankResult) {
        return yieldService.createYield(rankResult);
    }

    public UserLotto createUserLotto(final MoneyRequest moneyRequest) {
        int numberOfLotto = moneyRequest.getMoney() / MONEY_UNIT;

        LottoRepository lottoRepository = new LottoRepository();

        IntStream.range(0, numberOfLotto)
                .forEach(i -> lottoRepository.add(new Lotto(RandomNumberGenerator.makeUniqueRandomList())));

        return new UserLotto(lottoRepository);
    }

}
