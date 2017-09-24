package future_star.api;

import calculator_soter.Calculator;
import future_star.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/evenSum")
public class CalculatorController {
    @Autowired
    CalculatorService calculatorService;
   @GetMapping(params = "numbers")
    public Map<String,Integer> getEvenSum(@RequestParam("numbers") String numbers){
       Map<String,Integer> response=new HashMap<>();
       Integer evenSum=calculatorService.getEvenNum(numbers);
       response.put("evenSum",evenSum);
       return response;
   }
}
