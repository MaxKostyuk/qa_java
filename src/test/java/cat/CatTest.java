package cat;

import com.example.Cat;
import com.example.Feline;
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
public class CatTest {
    private Cat cat;

    @Mock
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @BeforeEach
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void getFoodTestShouldCallFelineEatMeatOnce() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
    @Test
    public void getSoundTestShouldReturnSoundsCat() {
        String expectedSound = dataLoader.getSoundForAnimal("cat");
        String sound = cat.getSound();
        Assertions.assertEquals(expectedSound, sound);
    }
}
