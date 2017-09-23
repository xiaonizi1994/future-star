package com.future.star.api;

import com.future.star.dto.UserDTO;
import com.future.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired UserService userService;
    @PostMapping()
    public Map<String,String> create(@RequestBody UserDTO userDTO){
        Map<String,String> response=new HashMap<>();
        UserDTO userDTO1=userService.createAccount(userDTO);
        response.put("message","create successfuly");
        response.put("username",userDTO1.getName());
        return response;
    }
}
