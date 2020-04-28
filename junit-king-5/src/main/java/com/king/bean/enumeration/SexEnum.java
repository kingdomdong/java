package com.king.bean.enumeration;

public enum SexEnum {

	MALE(1, "MALE"), FEMALE(0, "FEMALE");

	private Integer id;
	private String name;

	SexEnum(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static SexEnum getSexById(Integer id) {
		for (SexEnum elem : SexEnum.values()) {
			if (elem.getId() == id) {
				return elem;
			}
		}
		
		return null;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
