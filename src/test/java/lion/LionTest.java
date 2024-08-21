package lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import utils.AnimalDataLoader;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    private Lion lion;
    @Mock
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @BeforeEach
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void constructorIncorrectSexShouldThrowException() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> new Lion(null, feline));
        String expectedMessage = dataLoader.getExceptionMessage("incorrectAnimalSex");
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void getFoodTestShouldCallFelineGetFoodOnceWithParameterPredator() throws Exception {
        String predatorString = dataLoader.getAnimalType("predator");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood(predatorString);
    }

    @Test
    public void getKittensTestShouldCallFelineGetKittensOnce() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }
}
