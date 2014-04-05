package com.edp.hbm;

public enum StatusName {
	NEW(1),
	ACTIVATED(2),
	BLOCKED(3);
	
	private final int value;
	
	private StatusName(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
