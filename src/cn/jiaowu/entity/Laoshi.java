package cn.jiaowu.entity;

/**
 * TLaoshi entity. @author MyEclipse Persistence Tools
 */

public class Laoshi implements java.io.Serializable {

	// Fields

	private Integer id;
	private String bianhao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String loginpw;
	private Integer zhuanyeid;
	private Integer del;
	private String oldPass;
	private String zymc;
	private Integer status;
	/** default constructor */
	public Laoshi() {
	}

	/** full constructor */
	public Laoshi(String bianhao, String xingming, String xingbie,
			String nianling, String loginpw, Integer zhuanyeid, Integer del) {
		this.bianhao = bianhao;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.loginpw = loginpw;
		this.zhuanyeid = zhuanyeid;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBianhao() {
		return this.bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getXingbie() {
		return this.xingbie;
	}

	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}

	public String getNianling() {
		return this.nianling;
	}

	public void setNianling(String nianling) {
		this.nianling = nianling;
	}

	public String getLoginpw() {
		return this.loginpw;
	}

	public void setLoginpw(String loginpw) {
		this.loginpw = loginpw;
	}

	public Integer getZhuanyeid() {
		return this.zhuanyeid;
	}

	public void setZhuanyeid(Integer zhuanyeid) {
		this.zhuanyeid = zhuanyeid;
	}

	public Integer getDel() {
		return this.del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}
	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}