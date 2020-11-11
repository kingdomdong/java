/**
 * <pre>
 * 标  题: DataPage.java.
 * 版权所有: 版权所有(C)2001-2016
 * 公   司: 深圳中兴力维技术有限公司
 * 内容摘要: // 简要描述本文件的内容，包括主要模块、函数及其功能的说明
 * 其他说明: // 其它内容的说明
 * 完成日期: 2016年6月16日
 * </pre>
 * <pre>
 * 修改记录1:
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @version 1.0
 * @author ChenFei
 */

package com.znv.peim.bpm.common.bean;

import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Vector;

/**
 * 分页实体类
 * @param <E>实际数据抽象类
 */
public class PageData<E> {

    private int recordsTotal = 0; // 总条数
    private int recordsFiltered = 0; //过滤后的总记录数
    private int currentPage = 1; // 当前页
    private int totalPages = 0; // 总页数
    private int pageSize = 10; // 每页数据条数
    private int fromIndex = 0; // 起始位置，用于数据库查询
    private int draw = 1; // dataTable的计数器，由页面传来，并原样传回页面
    private String orderBy = ""; // 排序方式
    private List<E> data; // 数据

    public PageData() {
        
    }

    public PageData(int curPage) {
        if (curPage > 0) {
            this.currentPage = curPage;
        }
    }

    public PageData(int currentPageParam, int pageSizeParam) {
        if (pageSize > 0) {
            this.pageSize = pageSizeParam;
        }

        if (currentPageParam > 0) {
            this.currentPage = currentPageParam;
        }

        this.fromIndex = (this.currentPage - 1) * this.pageSize;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public PageData<E> setRecordsTotal(int totalRecords) {
        this.recordsTotal = totalRecords;
        this.totalPages = this.recordsTotal / this.pageSize;
        if (this.recordsTotal % this.pageSize != 0) {
            ++this.totalPages;
        }

        if (this.recordsTotal == 0) {
            this.data = new Vector<E>();
        } else {
            this.fromIndex = (this.currentPage - 1) * this.pageSize;
        }
        return this;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public PageData<E> setCurrentPage(int curPage) {

        if (curPage <= 0) {
            curPage = 1;
        }

        this.currentPage = curPage;
        this.fromIndex = (this.currentPage - 1) * this.pageSize;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageData<E> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.fromIndex = (this.currentPage - 1) * this.pageSize;
        return this;
    }

    public List<E> getData() {
        return data;
    }

    public PageData<E> setData(List<E> data) {
        this.data = data;
        return this;
    }

    public int getDraw() {
        return draw;
    }

    public PageData<E> setDraw(int drawParam) {
        this.draw = drawParam;
        return this;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public PageData<E> setOrderBy(String orderBy) {
        if (!StringUtils.isEmpty(orderBy)) {
            this.orderBy = orderBy;
        }
        return this;
    }

    public int getFromIndex() {
        return fromIndex;
    }

    public PageData<E> setFromIndex(int fromIndexParam) {
        this.fromIndex = fromIndexParam;
        this.currentPage = this.fromIndex % this.pageSize > 0 ? this.fromIndex / this.pageSize + 2
            : this.fromIndex / this.pageSize + 1;

        return this;
    }

    public int getTotalPages() {
        return totalPages;
    }
    
    public int getRecordsFiltered() {
        return recordsFiltered;
    }
    
    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

}
