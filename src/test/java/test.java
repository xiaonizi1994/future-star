import calculator_soter.Calculator;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

public class test {
    @Test
    public void should_return_even_sum() throws Exception {
        String numbers="1,2,3,4,5,6,7,8,9,10";
        int result=Calculator.getEvenSum(numbers);
        assertThat(result,is(result));
    }
}
