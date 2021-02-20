package dao.DaoImpl;

import dao.CategoryDao;
import domain.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    String TABLE_NAME = "customerlist.tab_category";
    @Override
    public List<Category> findAll() {
        String sql = "select * from " + TABLE_NAME + " ;";
//        System.out.println(sql);
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
    }
}
