package future_star.service;

import calculator_soter.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int getEvenNum(String numbers){
        return Calculator.getEvenSum(numbers);
    }
}
