package cn.jiaowu.entity;

/**
 * TGonggao entity. @author MyEclipse Persistence Tools
 */

public class Gonggao implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String content;
	private String addtime;

	// Constructors

	/** default constructor */
	public Gonggao() {
	}

	/** full constructor */
	public Gonggao(String title, String content, String addtime) {
		this.title = title;
		this.content = content;
		this.addtime = addtime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

}