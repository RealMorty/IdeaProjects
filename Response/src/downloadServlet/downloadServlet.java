package downloadServlet;

import utils.DownLoadUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath(filename);
        FileInputStream fis = new FileInputStream(realPath);

        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        String header = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(header, filename);
        response.setHeader("content-disposition","attachment;filename="+filename);

        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len=fis.read(buff))!=-1) {
            sos.write(buff,0,len);
        }
        fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
