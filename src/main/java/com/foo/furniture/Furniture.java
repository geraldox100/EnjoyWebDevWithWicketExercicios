package com.foo.furniture;

import java.io.Serializable;

public class Furniture implements Serializable {
	private static final long serialVersionUID = 1L;

	private int width;
	private int height;
	private String material;

	public Furniture(int width, int height, String material) {
		this.width = width;
		this.height = height;
		this.material = material;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}

}
