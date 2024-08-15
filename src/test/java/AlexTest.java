import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import utils.AnimalDataLoader;

import java.io.IOException;
import java.util.List;

public class AlexTest {
    private Alex alex;
    @Mock
    private Feline feline;
    private static AnimalDataLoader dataLoader;

    @BeforeAll
    public static void initializeData() throws IOException {
        dataLoader = AnimalDataLoader.getInstance();
    }

    @BeforeEach
    public void setUp() {
        alex = new Alex(feline);
    }

    @Test
    public void getKittensShouldReturnZero() {
        Assertions.assertEquals(0, alex.getKittens());
    }

    @Test
    public void getFriendsShouldReturnFriends() {
        List<String> expectedList = dataLoader.getAlexFriends();
        List<String> actualList = alex.getFriends();
        Assertions.assertEquals(expectedList, actualList);
    }
    
    @Test
    public void getPlaceOfLivingShouldReturnPlace() {
        String expectedPlace = dataLoader.getAlexPlaceOfLiving();
        String actualPlace = alex.getPlaceOfLiving();
        Assertions.assertEquals(expectedPlace, actualPlace);
    }
}
