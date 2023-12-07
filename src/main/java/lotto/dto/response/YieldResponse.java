package lotto.dto.response;

public class YieldResponse {
    private final float yield;
    public YieldResponse(float yield) {
        this.yield = yield;
    }

    public float getYield() {
        return yield;
    }
}
