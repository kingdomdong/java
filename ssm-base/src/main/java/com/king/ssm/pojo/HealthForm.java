package com.king.ssm.pojo;

public abstract class HealthForm {

	/** fields */
	
	private Long id;
	private Long empId;
	private String heart;
	private String liver;
	private String spleen;
	private String lung;
	private String kidney;
	private String note;

	/** getters & setters */
	
	public String getHeart() {
		return heart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public void setHeart(String heart) {
		this.heart = heart;
	}

	public String getLiver() {
		return liver;
	}

	public void setLiver(String liver) {
		this.liver = liver;
	}

	public String getSpleen() {
		return spleen;
	}

	public void setSpleen(String spleen) {
		this.spleen = spleen;
	}

	public String getLung() {
		return lung;
	}

	public void setLung(String lung) {
		this.lung = lung;
	}

	public String getKidney() {
		return kidney;
	}

	public void setKidney(String kidney) {
		this.kidney = kidney;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
