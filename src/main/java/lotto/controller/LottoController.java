package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.RankResult;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;
import lotto.dto.response.RankResultResponse;
import lotto.dto.response.YieldResponse;
import lotto.utils.mapper.RankResultResponseMapper;
import lotto.utils.mapper.YieldResponseMapper;

public class LottoController {

    private final RankService rankService;
    private final YieldService yieldService;

    public LottoController(RankService rankService, YieldService yieldService) {
        this.rankService = rankService;
        this.yieldService = yieldService;
    }

    public RankResultResponse applyRank(WinningLotto winningLotto, BonusNumber bonusNumber, UserLotto userLotto) {
        return RankResultResponseMapper.of(rankService.calculateRank(winningLotto, bonusNumber, userLotto));
    }

    public YieldResponse applyYield(RankResult rankResult) {
        return YieldResponseMapper.of(yieldService.createYield(rankResult);
    }
}
