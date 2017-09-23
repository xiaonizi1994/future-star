package com.future.star.service;

import com.future.star.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {
    private final AtomicLong counter = new AtomicLong();
    static Map<Long,UserDTO> userData=new HashMap<>();
    public UserDTO createAccount(UserDTO userDTO){
        userData.put(counter.incrementAndGet(),userDTO);
        return userDTO;
    }
}
