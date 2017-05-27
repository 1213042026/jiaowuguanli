package cn.jiaowu.entity;

/**
 * TChengji entity. @author MyEclipse Persistence Tools
 */

public class Chengji implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer xueshengid;
	private String kaoshishi;
	private Integer kechengid;
	private Double fenshu;
	
	private String xsxm;
	private String kcmc;

	// Constructors

	/** default constructor */
	public Chengji() {
	}

	/** full constructor */
	public Chengji(Integer xueshengid, String kaoshishi, Integer kechengid,
			Double fenshu) {
		this.xueshengid = xueshengid;
		this.kaoshishi = kaoshishi;
		this.kechengid = kechengid;
		this.fenshu = fenshu;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getXueshengid() {
		return this.xueshengid;
	}

	public void setXueshengid(Integer xueshengid) {
		this.xueshengid = xueshengid;
	}

	public String getKaoshishi() {
		return this.kaoshishi;
	}

	public void setKaoshishi(String kaoshishi) {
		this.kaoshishi = kaoshishi;
	}

	public Integer getKechengid() {
		return this.kechengid;
	}

	public void setKechengid(Integer kechengid) {
		this.kechengid = kechengid;
	}

	public Double getFenshu() {
		return this.fenshu;
	}

	public void setFenshu(Double fenshu) {
		this.fenshu = fenshu;
	}

	public String getXsxm() {
		return xsxm;
	}

	public void setXsxm(String xsxm) {
		this.xsxm = xsxm;
	}

	public String getKcmc() {
		return kcmc;
	}

	public void setKcmc(String kcmc) {
		this.kcmc = kcmc;
	}

}