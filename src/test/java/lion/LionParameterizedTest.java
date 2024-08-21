package lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import utils.AnimalDataLoader;

import java.io.IOException;

public class LionParameterizedTest {
    @Mock
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @ParameterizedTest
    @ValueSource(strings = {"male", "female"})
    public void doesHaveManeShouldReturnSameBooleanAsSentToConstructor(String sex) throws Exception {
        String sexName = dataLoader.getSexName(sex);
        Lion lion = new Lion(sexName, feline);
        boolean expectedHasMane = dataLoader.getHasManeForSex(sex);
        boolean actualHasMane = lion.doesHaveMane();
        Assertions.assertEquals(expectedHasMane, actualHasMane);
    }
}
