package com.residencial.app.application.dto;


import java.util.List;

public class ResultPageWrapper<T> {

    List<T> pagesResult;
    private long totalItems;
    private long totalPages;
    private int currentPage;

    public List<T> getPagesResult() {
        return pagesResult;
    }

    public void setPagesResult(List<T> pagesResult) {
        this.pagesResult = pagesResult;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
