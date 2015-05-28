package cn.hglq4.eshop.vo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("all")
public class Page<T> implements Serializable {
	private static long DEFAULT_PAGE_SIZE = 20;
	private long pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数
	private long start; // 当前页第一条数据在List中的位置,从0开始
	private List<T> data = Collections.emptyList(); // 当前页中存放的记录
	private long totalCount = 0; // 总记录数

	public Page() {
		this(0l, 0l, DEFAULT_PAGE_SIZE, Collections.<T> emptyList());
	}

	public Page(long start, long totalSize, long pageSize, List<T> data) {
		this.pageSize = pageSize;
		this.start = start;
		this.totalCount = totalSize;
		this.data = data;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public List<T> getResult() {
		return data;
	}

	public long getCurrentPageNo() {
		return start / pageSize + 1;
	}

	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}

	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}

	protected static long getStartOfPage(long pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	public static long getStartOfPage(long pageNo, long pageSize) {
		return (pageNo - 1) * pageSize;
	}

}
