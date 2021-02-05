package com.mvcstudy.testmvc.vo;

import com.mvcstudy.testmvc.service.UserService;

public class Pagination {
	int userCount;
	int page;
	int pageNum;
	int startPage;
	int endPage;
	int lastPage;
	int prevPage;
	int nextPage;
	public static final int pageUnit = 5;
	public static final int perPage = 5;
	UserService userService = null;
	
	public Pagination() {
		
	}
	
	public Pagination(int page) {
		this.page = page;
		userService = UserService.getInstance();
		userCount = userService.getUsersCount();
		startPage = ((page - 1) / pageUnit) * pageUnit + 1;
		lastPage = (int)Math.ceil(userCount / (float)perPage);
		endPage = startPage + pageUnit - 1;
		endPage = endPage < lastPage ? endPage : lastPage;
		prevPage = (endPage - pageUnit);
		nextPage = (startPage + pageUnit);
	}
	
	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
}