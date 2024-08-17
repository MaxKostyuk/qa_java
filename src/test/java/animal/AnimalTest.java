package animal;

import com.example.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AnimalDataLoader;

import java.io.IOException;

public class AnimalTest {

    private Animal animal;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @BeforeEach
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFamilyTestShouldReturnDefaultValue() {
        String expectedFamilyMessage = dataLoader.getFamilyName("default");
        String actualFamilyMessage = animal.getFamily();
        Assertions.assertEquals(expectedFamilyMessage, actualFamilyMessage);
    }

    @Test
    public void getFoodTestShouldThrowExceptionWithIncorrectTypeMessage() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> animal.getFood(null));
        String expectedMessage = dataLoader.getExceptionMessage("incorrectAnimalType");
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
