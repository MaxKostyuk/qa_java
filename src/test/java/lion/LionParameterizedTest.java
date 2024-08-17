package lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

public class LionParameterizedTest {
    @Mock
    private Feline feline;

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void doesHaveManeShouldReturnSameBooleanAsSentToConstructor(boolean isMale) {
        Lion lion = new Lion(isMale, feline);
        Assertions.assertEquals(isMale, lion.doesHaveMane());
    }
}
