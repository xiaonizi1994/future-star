package future_star.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
@Builder
@ToString
public class UserDTO {
    String name;
    String password;
    int age;
    int id;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String,String> getInfo(){
        Map<String,String> map=new HashMap<>();
        map.put("username",this.getName());
        map.put("age",Integer.toString(this.getAge()));
        return map;
    }
}
