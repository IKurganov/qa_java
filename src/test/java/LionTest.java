import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnFelineGivenNumber() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void getFoodReturnListOfMeatForLion() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedFood = List.of("Свинина", "Мираторг", "Стейки");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void lionConstructorExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("...", feline));

        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();

        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }


}
