package com.jeff.mybatis.page;

import java.util.List;

/**
 * 分页对象
 * 
 * @author jeff he
 *
 * @param <T>
 */
public class Page<T> {
	/**
	 * 分页的大小?
	 */
	private int limit;
	/**
	 * 分页的起始页
	 */
	private int offset;
	/**
	 * 总记录数
	 */
	private Long total = new Long(0);
	/**
	 * 总页数
	 */
	private Long totalPage = new Long(0);
	/**
	 * 分页的数据?
	 */
	private List<T> rows;

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
