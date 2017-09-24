package future_star.service;

import future_star.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LoginService {
    Map<Long,UserDTO> userData=UserService.userData;
    public boolean login(UserDTO userDTO){
        List<Map.Entry> response= userData.entrySet().stream().
                filter(user->user.getValue().getName().equals(userDTO.getName())
                        &&user.getValue().getPassword().equals(userDTO.getPassword()))
                .collect(Collectors.toList());
        return response.isEmpty();
    }

}
