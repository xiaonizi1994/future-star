package future_star.api;

import future_star.dto.UserDTO;
import future_star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;
    Map<String, String> response;

    @PostMapping()
    public Map<String, String> create(@RequestBody UserDTO userDTO) {
        response = new HashMap<>();
        UserDTO userDTO1 = userService.createAccount(userDTO);
        response.put("message", "create successfuly");
        response.put("username", userDTO1.getName());
        return response;
    }

    @GetMapping
    public Map<Long, Map> getList() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/{userid}", params = "age")
    public Map<String, String> updateAge(@PathVariable Long userid, @RequestParam("age") int age) {
        return userService.updateAge(userid, age);
    }

    @GetMapping(params = "age")
    public Map<Long, Map> searchUserByAge(@RequestParam("age") int age) {
        return userService.searchByAge(age);
    }

}
