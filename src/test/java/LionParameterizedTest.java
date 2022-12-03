import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final boolean expectedResult;

    @Before
    public void init() {
//      использован openMocks, так как initMocks - устаревший
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    Feline feline;

    public LionParameterizedTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{0} обладает гривой - {1}")
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeReturnCorrectAnswer() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals(expectedResult, actualResult);
    }
}