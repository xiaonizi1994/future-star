package api;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class GreetingControllerTest extends BaseControllerTest{
    @Test
    void should_return_greeting() throws Exception{
         mockMvc.perform(get("/api/greeting")
         .contentType(MediaType.APPLICATION_JSON)).
                 andExpect(jsonPath("$.message").value("hello"));

    }
}
