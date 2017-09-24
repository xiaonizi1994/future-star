package calculator_soter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class Calculator {
    public static int getEvenSum(String numbers) {
        List<String> listNumbers= Arrays.asList(numbers.split(","));
        return listNumbers.stream().map(item->Integer.valueOf(item))
                .filter(item->item%2==0)
                .mapToInt(Integer::intValue).sum();
    }
}
