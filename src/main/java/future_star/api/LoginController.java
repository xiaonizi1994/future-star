package future_star.api;

import future_star.dto.UserDTO;
import future_star.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping
    public Map<String,String> login(@RequestBody UserDTO userDTO){
        Map<String,String> map=new HashMap<>();
        if(!loginService.login(userDTO)){
            map.put("message","login sucessful");
            map.put("username",userDTO.getName());
        }else{
            map.put("message","login failed");
        }
        return map;
    }
}
