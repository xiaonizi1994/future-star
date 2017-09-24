package future_star.service;

import calculator_soter.Sorter;
import org.springframework.stereotype.Service;

@Service
public class SoterService {
    public String getSorterLetterWithAppearTimes(String letters){
        return Sorter.getSortLettersWithAppearTimes(letters);
    }
}
