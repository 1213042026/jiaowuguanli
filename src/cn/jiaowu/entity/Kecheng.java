package cn.jiaowu.entity;

/**
 * TKecheng entity. @author MyEclipse Persistence Tools
 */

public class Kecheng implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mingcheng;
	private Integer zhuanyeid;
	private Integer del;
	private String zymc;
	// Constructors

	/** default constructor */
	public Kecheng() {
	}

	/** full constructor */
	public Kecheng(String mingcheng, Integer zhuanyeid, Integer del) {
		this.mingcheng = mingcheng;
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

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
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

	public String getZymc() {
		return zymc;
	}

	public void setZymc(String zymc) {
		this.zymc = zymc;
	}

}