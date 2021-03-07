//import config.Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Dog;
import pojo.Person;

public class MyTest {
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person person = context.getBean("person",Person.class);
        person.getDog().bark();
        person.getCat().bark();
    }
}
