package com.springBoot.project.rest.controller.data.vo;

import com.springBoot.project.enumeration.SortOrder;

public class PaginationDTO {

    private SortOrder sortOrder;
    private Integer startPage;
    private Integer endPage;

    public SortOrder getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

}
