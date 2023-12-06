package lotto.configuration;

import lotto.controller.FrontController;
import lotto.controller.LottoSystem;
import lotto.domain.service.RankService;
import lotto.domain.service.YieldService;

public class ApplicationConfiguration {
    public FrontController frontController(){
        return new FrontController(lottoSystem());
    }
    private LottoSystem lottoSystem(){
        return new LottoSystem(rankService(),yieldService());
    }
    private RankService rankService(){
        return new RankService();
    }
    private YieldService yieldService(){
        return new YieldService();
    }

}
