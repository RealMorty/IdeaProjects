package test;
import dao.UserDao;
import domin.User;
import org.testng.annotations.Test;
public class UserDAO_test {
    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("Morty");
        loginuser.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(loginuser);
//        System.out.println(login);
    }

}
