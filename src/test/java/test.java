import calculator_soter.Calculator;
import calculator_soter.Sorter;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;

public class test {
    @Test
    public void should_return_even_sum() throws Exception {
        String numbers="1,2,3,4,5,6,7,8,9,10";
        int result=Calculator.getEvenSum(numbers);
        assertThat(result,is(30));
    }

    @Test
    public void should_return_sort_letters_with_letter_appear_times() throws Exception {
        String letters="aababbbcabcdabcde";
        Sorter sorter=new Sorter();
        String result=sorter.getSortLettersWithAppearTimes(letters);
        assertThat(result,is("5(a)<6(b)<3(c)<2(d)<1(e)"));
    }
}
