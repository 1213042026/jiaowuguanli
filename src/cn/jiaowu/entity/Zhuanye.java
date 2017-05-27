package cn.jiaowu.entity;

/**
 * TZhuanye entity. @author MyEclipse Persistence Tools
 */

public class Zhuanye implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mingcheng;
	private Integer del;

	// Constructors

	/** default constructor */
	public Zhuanye() {
	}

	/** full constructor */
	public Zhuanye(String mingcheng, Integer del) {
		this.mingcheng = mingcheng;
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

	public Integer getDel() {
		return this.del;
	}

	public void setDel(Integer del) {
		this.del = del;
	}

}