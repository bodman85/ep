package com.edp.hbm;

public enum RoleName {
	ADMIN(1), CLIENT(2);

	private final int value;

	private RoleName(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
