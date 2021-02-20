package web.servlet;

import domain.Category;
import service.CategoryService;
import service.ServiceImpl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class categoryServlet extends baseServlet {
    private CategoryService service = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> list = service.findAll();
        writeValue(list,response);
    }

}
