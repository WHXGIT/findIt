package com.cogitationsoft.findit.common;

import java.util.List;

/**
 * @author: Andy
 * @date: 5/14/2018 6:04 PM
 * @description: 分页
 * @version: 1.0
 */
public class Pagination<E> {
	private int currentPage;
	private int prePage;
	private int nextPage;
	private int firstPage;
	private int lastPage;
	private int totalPage;
	private int totalCount;
	private int pageCount;
	private List<E> data;

	public Pagination(){}


	public Pagination(int currentPage, int prePage, int nextPage, int firstPage, int lastPage, int totalPage,
	                  int totalCount, int pageCount, List<E> data) {
		this.currentPage = currentPage;
		this.prePage = prePage;
		this.nextPage = nextPage;
		this.firstPage = firstPage;
		this.lastPage = lastPage;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
		this.pageCount = pageCount;
		this.data = data;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
