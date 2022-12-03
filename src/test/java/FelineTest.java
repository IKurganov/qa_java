import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatReturnFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyReturnCatsFamily() {
        Feline feline = new Feline();
        String actualResult = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualResult);
    }

    @Test
    public void getKittensReturnOneKitten() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens();
        Assert.assertEquals(1, actualResult);
    }

    @Test
    public void getKittensWithIntReturnGivenInt() {
        Feline feline = new Feline();
        int actualResult = feline.getKittens(5);
        Assert.assertEquals(5, actualResult);
    }
}
