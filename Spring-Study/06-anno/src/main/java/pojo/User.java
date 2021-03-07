package pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
//public class User {
//    public String name = "Morty";
//}

@Component
public class User {
    @Value("Morty")
    public String name;
}
