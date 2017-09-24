package api;

import com.fasterxml.jackson.databind.ObjectMapper;
import future_star.api.UserController;
import future_star.dto.UserDTO;
import future_star.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.hasSize;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends BaseControllerTest {
    @Autowired
    UserService userService;
    UserDTO user1;
    UserDTO user2;

    @BeforeEach
    void before() {
        user1 = UserDTO.builder().name("future_star").password("123456").age(0).build();
        user2 = UserDTO.builder().name("future_star").password("123456").age(12).build();
    }

    @Test
    void should_create_user() throws Exception {
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(jsonPath("$.message").value("create successfuly"))
                .andExpect(jsonPath("$.username").value("future_star"));

    }

    @Test
    void should_list_all_users() throws Exception {
        userService.clear();

        userService.createAccount(user1);

        userService.createAccount(user2);

        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].age").value(12))
                .andExpect(jsonPath("$[0].username").value("future_star"));

    }

    @Test
    void should_update_user() throws Exception {
        userService.clear();
        userService.createAccount(user1);

        userService.createAccount(user2);

        mockMvc.perform(put("/api/users/" + user1.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user2)))
                .andExpect(jsonPath("$.age").value(12))
                .andExpect(jsonPath("$.username").value("future_star"));

    }
    @Test
    void should_list_user_with_age_22() throws Exception {
        userService.clear();
        userService.createAccount(user1);
        userService.createAccount(user2);
        userService.createAccount(user2);

        mockMvc.perform(get("/api/users")
                .param("age", "12")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
