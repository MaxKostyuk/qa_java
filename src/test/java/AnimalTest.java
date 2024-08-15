import com.example.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.AnimalDataLoader;

import java.io.IOException;
import java.util.List;

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

    @ParameterizedTest
    @ValueSource(strings = {"predator", "herbivore"})
    public void getFoodTestShouldReturnCorrespondingList(String animalType) {
        String typeName = dataLoader.getAnimalType(animalType);
        List<String> expectedList = dataLoader.getFoodForType(animalType);
        try {
            List<String> actualList = animal.getFood(typeName);
            Assertions.assertEquals(expectedList, actualList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFoodTestShouldThrowExceptionWithIncorrectTypeMessage() {
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            animal.getFood(null);
        });
        String expectedMessage = dataLoader.getExceptionMessage("incorrectAnimalType");
        String actualMessage = exception.getMessage();
        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
