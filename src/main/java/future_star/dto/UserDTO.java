package future_star.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twcn on 23/09/2017.
 */
public class UserDTO {
    String name;
    String password;
    int age;

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
