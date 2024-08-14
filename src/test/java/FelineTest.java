import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class FelineTest {
    private Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
    }


    @Test
    public void getFamilyTestShouldReturnKoshachiy() {
        String family = feline.getFamily();
        Assertions.assertEquals("Кошачьи", family);
    }

    @Test
    public void eatMeatTestReturnListForPredator() throws Exception {
        List<String> food = feline.eatMeat();
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
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
