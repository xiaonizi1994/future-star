package future_star.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/greeting")
public class GreetingController {
    @GetMapping(produces = "application/json")
    public Map<String,String> greeting(){
        Map<String,String> greetMap=new HashMap<>();
        greetMap.put("message","hello");
        return greetMap;
    }
}
