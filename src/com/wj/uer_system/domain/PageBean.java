package com.wj.uer_system.domain;

import java.util.List;

/**
 * @Project : user_system
 * @Package : com.wj.uer_system.domain
 * @Author : Created By wangjun, Copyright © wangjun All Rights Reserved
 * @Date : 2020/2/22 22:21
 **/
public class PageBean<T> {

    // 当前页数
    private Integer currentPage;
    // 总页数
    private Integer totalPage;
    // 总条目数
    private Integer totalCount;
    // 包含数据的集合
    private List<T> beanList;
    // 每页有几条数据
    private int number;

    public PageBean() {
    }

    public PageBean(Integer currentPage, Integer totalPage, Integer totalCount, List<T> beanList, int number) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.beanList = beanList;
        this.number = number;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", beanList=" + beanList +
                ", number=" + number +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
