package service.ServiceImpl;

import dao.DaoImpl.UserDaoImpl;
import dao.UserDao;
import domain.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public boolean isUserNameExists(String name) {
        return dao.findUserByName(name);
    }

    @Override
    public void register(User user) {
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        dao.addUser(user);
        String src = "user/Active?code=" + user.getCode();
        MailUtils.sendMail(user.getEmail(), "<html lang=\"zh-CN\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "你好，这是一封确认邮件。请点击<a href=" + src + ">此链接</a>以完成邮箱绑定\n" +
                "</body>\n" +
                "</html>", "黑马旅游网邮箱绑定");
    }

    @Override
    public boolean active(String code) {
        User user = dao.findUserByCode(code);
        if (user != null) {
            dao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(String username, String password) {
        return dao.login(username, password);
    }
}
