package service.ServiceImpl;

import dao.DaoImpl.RouteDaoImpl;
import dao.RouteDao;
import domain.PageBean;
import domain.Route;
import service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao =new RouteDaoImpl();

    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        PageBean<Route> pb = new PageBean<Route>();
        pb.setCurrentPage(currentPage);
        pb.setPageSize(pageSize);

        int totalCount = routeDao.findTotalCount(cid);
        pb.setTotalCount(totalCount);

        int start = (currentPage - 1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize);
        pb.setList(list);

        int totalPage = totalCount % pageSize == 0 ? totalCount / pageSize :
                (totalCount / pageSize) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
