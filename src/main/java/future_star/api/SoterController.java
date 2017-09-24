package future_star.api;

import future_star.service.SoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sorter")
public class SoterController {
    @Autowired
    SoterService soterService;
    @GetMapping(params = "letters")
    public Map<String,String> getSoterLetterWithAppearTimes(@RequestParam("letters") String letters){
        Map<String,String> response=new HashMap<>();
        String result=soterService.getSorterLetterWithAppearTimes(letters);
        response.put("message",result);
        return response;
    }

}
