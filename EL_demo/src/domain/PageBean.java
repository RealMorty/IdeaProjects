package domain;

import java.util.List;

public class PageBean<T> {
    private int totalPages;
    private int totalCount;
    private List<T> pageList;
    private int rows;
    private int currentPage;

    public PageBean() {
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalPages=" + totalPages +
                ", totalCount=" + totalCount +
                ", PageList=" + pageList +
                ", rows=" + rows +
                ", currentPage=" + currentPage +
                '}';
    }
}
