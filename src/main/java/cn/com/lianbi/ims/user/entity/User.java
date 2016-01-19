package cn.com.lianbi.ims.user.entity;

/**
 * @since 2016年1月15日 上午10:46:35
 * @author xjh
 */
public class User {
	
	private String name = "未知";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
	
}
