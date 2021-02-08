package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements service.UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        dao.deleteUser(id);
    }

    @Override
    public void updateUser(User user, Integer id) {
        dao.updateUser(user, id);
    }

    @Override
    public User queryUserById(Integer id) {
        return dao.queryUserById(id);
    }

    @Override
    public void delSelectedUsers(String[] checkBoxIds) {
        if (checkBoxIds != null && checkBoxIds.length > 0) {
            for (String checkBoxId : checkBoxIds) {
                dao.deleteUser(Integer.parseInt(checkBoxId));
            }
        }
    }

    @Override
    public PageBean<User> currentPageBean(Integer currentPage, Integer rows, Map<String, String[]> condition) {
        PageBean<User> userPageBean = new PageBean<>();
        int totalCount = dao.findTotalCount(condition);
//        System.out.println("total:"+totalCount);
        int totalPages = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (currentPage > totalPages) {
            currentPage = totalPages;
        }
        List<User> pageList = dao.findListByPage(currentPage,rows,condition);

        userPageBean.setCurrentPage(currentPage);
        userPageBean.setPageList(pageList);
        userPageBean.setTotalCount(totalCount);
        userPageBean.setTotalPages(totalPages);
        userPageBean.setRows(rows);
        return userPageBean;
    }
}
