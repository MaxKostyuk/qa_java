package animal;

import com.example.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.AnimalDataLoader;

import java.io.IOException;
import java.util.List;

public class AnimalParameterizedTest {
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

    @ParameterizedTest
    @ValueSource(strings = {"predator", "herbivore"})
    public void getFoodTestShouldReturnCorrespondingList(String animalType) throws Exception {
        String typeName = dataLoader.getAnimalType(animalType);
        List<String> expectedList = dataLoader.getFoodForType(animalType);
        List<String> actualList = animal.getFood(typeName);
        Assertions.assertEquals(expectedList, actualList);
    }
}
