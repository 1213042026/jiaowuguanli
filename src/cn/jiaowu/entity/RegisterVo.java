package cn.jiaowu.entity;

/**
 * TLaoshi entity. @author MyEclipse Persistence Tools
 */

public class RegisterVo implements java.io.Serializable {
	private String username;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String loginpw;
	private Integer zhuanyeid;
	private Integer type;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getXingbie() {
		return xingbie;
	}
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	public String getNianling() {
		return nianling;
	}
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	public String getLoginpw() {
		return loginpw;
	}
	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}
	public Integer getZhuanyeid() {
		return zhuanyeid;
	}
	public void setZhuanyeid(Integer zhuanyeid) {
		this.zhuanyeid = zhuanyeid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}