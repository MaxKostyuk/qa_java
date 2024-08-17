package lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import utils.AnimalDataLoader;

import java.io.IOException;

public class LionParameterizedTest {
    private Lion lion;
    @Mock
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void doesHaveManeShouldReturnSameBooleanAsSentToConstructor(boolean isMale) {
        lion = new Lion(isMale, feline);
        Assertions.assertEquals(isMale, lion.doesHaveMane());
    }
}
