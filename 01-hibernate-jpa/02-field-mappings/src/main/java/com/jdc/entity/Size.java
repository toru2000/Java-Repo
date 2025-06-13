package com.jdc.entity;

public enum Size {
	// private String name; ma ya
	SMALL(500), MEDIUM(1000), LARGE(1500);

	private int times;

	Size(int times) {
		this.times = times;
	}

	public int getTimes() {
		return times;
	}
}
