package com.jd.vos;

public class Book {
	private int id;
	private String name;
	private float price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Book(){}
	public Book(int id, String name, float price) 
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Book(String name, float price) {

		this.name = name;
		this.price = price;
	}

}
