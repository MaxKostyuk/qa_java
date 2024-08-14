import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    private Cat cat;

    @Mock
    private Feline feline;

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
    public void getSoundTestShouldReturnMyau() {
        String sound = cat.getSound();
        Assertions.assertEquals("Мяу", sound);
    }
}
