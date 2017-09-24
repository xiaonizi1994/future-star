package api;


import com.fasterxml.jackson.databind.ObjectMapper;
import future_star.dto.LoginDTO;
import future_star.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class authenticationControllerTest extends BaseControllerTest{
    @Test
    void should_login_successfully() throws Exception {
        UserDTO userDTO=UserDTO.builder().name("future_star").password("123").build();

        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.message").value("login sucessful"))
                .andExpect(jsonPath("$.username").value(" future_star"));
    }

    /**
     * 2.2 完成登陆失败API
     */
    @Test
    void should_login_failed_when_login_with_bad_credential() throws Exception {
        UserDTO userDTO=UserDTO.builder().name("future_star").password("123").build();

        mockMvc.perform(post("/api/authentication")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(userDTO)))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.message").value("login failed"));
    }
}
