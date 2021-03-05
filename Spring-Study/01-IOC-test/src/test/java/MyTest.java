import dao.UserDao;
import dao.UserDaoImpl;
import dao.UserDaoMysqlImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;
import service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
//        //用户实际调用的是业务层，dao层不接触
//        UserServiceImpl userService = new UserServiceImpl();
//
//        userService.setUserDao(new UserDaoImpl());
//
//        userService.getUser();
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.getUser();

    }
}
