package cn.com.lianbi.framework.dao;

/**
 * @since 2016年1月15日 下午2:06:58
 * @author xjh
 */
public class Page {

	private int firstResult;
	private int maxResult;
	
	public int getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}
	public int getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(int maxResult) {
		this.maxResult = maxResult;
	}
	
}
