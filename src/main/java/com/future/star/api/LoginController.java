package com.future.star.api;

import com.future.star.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/login")
public class LoginController {
    @PostMapping
    public Map<String,String> login(@RequestBody UserDTO userDTO){
        Map<String,String> map=new HashMap<>();
        if(userDTO.getName().equals("future")&&userDTO.getPassword().equals("123")){
            map.put("message","login sucessful");
        }
        else{
            map.put("message","login failed");
        }
        return map;
    }
}
