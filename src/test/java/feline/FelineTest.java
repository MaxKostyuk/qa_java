package feline;

import com.example.Feline;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import utils.AnimalDataLoader;

import java.io.IOException;
import java.util.List;

public class FelineTest {
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void getFamilyTestShouldReturnFelineName() {
        String expectedFamily = dataLoader.getFamilyName("feline");
        String actualFamily = feline.getFamily();
        Assertions.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void eatMeatTestReturnFoodPredator() throws Exception {
        List<String> expectedList = dataLoader.getFoodForType("predator");
        List<String> actualList = feline.eatMeat();
        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    public void getKittensTestShouldReturnSentAmount() {
        int sentKittensCount = 3;
        int receivedKittensCount = feline.getKittens(sentKittensCount);
        Assertions.assertEquals(sentKittensCount, receivedKittensCount);
    }

    @Test
    public void getKittensTestShouldReturnOne() {
        int expectedKittensCount = 1;
        int receivedKittensCount = feline.getKittens();
        Assertions.assertEquals(expectedKittensCount, receivedKittensCount);
    }
}
