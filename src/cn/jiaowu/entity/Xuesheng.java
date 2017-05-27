package cn.jiaowu.entity;

/**
 * TXuesheng entity. @author MyEclipse Persistence Tools
 */

public class Xuesheng implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer zhuanyeid;
	private String xuehao;
	private String xingming;
	private String xingbie;
	private String nianling;
	private String loginpw;
	private Integer del;
	private String oldPass;
	// Constructors
	private String zymc;
	private Integer status;
	/** default constructor */
	public Xuesheng() {
	}

	/** full constructor */
	public Xuesheng(Integer zhuanyeid, String xuehao, String xingming,
			String xingbie, String nianling, String loginpw, Integer del) {
		this.zhuanyeid = zhuanyeid;
		this.xuehao = xuehao;
		this.xingming = xingming;
		this.xingbie = xingbie;
		this.nianling = nianling;
		this.loginpw = loginpw;
		this.del = del;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getZhuanyeid() {
		return this.zhuanyeid;
	}

	public void setZhuanyeid(Integer zhuanyeid) {
		this.zhuanyeid = zhuanyeid;
	}

	public String getXuehao() {
		return this.xuehao;
	}

	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
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