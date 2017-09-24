package com.future.star.service;

import com.future.star.dto.UserDTO;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final AtomicLong counter = new AtomicLong();
    static Map<Long, UserDTO> userData = new HashMap<>();

    public UserDTO createAccount(UserDTO userDTO) {
        try {
            userData.put(counter.incrementAndGet(), userDTO);
        } catch (Exception e) {
            throw e;
        }
        return userDTO;
    }

    public Map<Long, Map> getAllUsers() {
        Map<Long, Map> response = new HashMap<>();
        for (Long id : userData.keySet()) {
            response.put(id, userData.get(id).getInfo());
        }
        return response;
    }

    public Map<String, String> updateAge(Long userid, int age) {
        Map<String, String> response = new HashMap<>();
        if (userData.containsKey(userid)) {
            userData.get(userid).setAge(age);
            return userData.get(userid).getInfo();
        }else{
            response.put("error", "user can not be find");
            return response;
        }
    }

    public Map<Long, Map> searchByAge(int age) {
        Map<Long,Map> response=new HashMap<>();
         userData.entrySet().stream().filter(user->user.getValue().getAge()==age)
                .forEach(user->response.put(user.getKey(),user.getValue().getInfo()));
        return response;
    }
}
