package lotto;

import lotto.domain.Lotto;
import lotto.system.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("checkNumberCount 검증 테스트")
    class CheckNumberCount {
        @ParameterizedTest(name = "{0}가 입력되었을 때")
        @MethodSource("parameterProvider")
        void 유효한_개수가_입력되었는지_테스트(List<Integer> target) {
            assertThatThrownBy(() -> new Lotto(target))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ExceptionMessage.COUNT_NOT_EQUAL);
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of()),
                    Arguments.of(List.of(1)),
                    Arguments.of(List.of(1,2)),
                    Arguments.of(List.of(1,2,3)),
                    Arguments.of(List.of(1,2,3,4,5)),
                    Arguments.of(List.of(1,2,3,4,5,6,7))
            );
        }
    }
}