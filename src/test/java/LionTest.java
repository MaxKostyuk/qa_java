import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;

    @BeforeEach
    public void setUp() {
        lion = new Lion(true, feline);
    }
    @Test
    public void getFoodTestShouldCallFelineGetFoodOnceWithParameterPredator() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensTestShouldCallFelineGetKittensOnce() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void doesHaveManeShouldReturnSameBooleanAsSentToConstructor(boolean isMale) {
        lion = new Lion(isMale, feline);
        Assertions.assertEquals(isMale, lion.doesHaveMane());
    }
}
