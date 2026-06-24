package com.kh.stock.model;

public class Device /* extends Object */ {
	
	protected String brand;
	protected String name;
	protected int price;
	
	
	public Device() {
	}
	
	public Device(String brand, String name, int price) {
		// super();
		this.brand = brand;
		this.name = name;
		this.price = price;
	}
	
	public String getInformation() {
		// 브랜드: Apple, 제품명: iPhone 15, 가격: 1250000원
	 	return "브랜드: " + brand + ", 제품명: " + name + ", 가격: " + price + "원";
//		return String.format("브랜드: %s, 제품명: %s, 가격: %d원", brand, name, price);
		// String.format(문자열형식, 사용할값, ...) => printf와 유사!
	}
}







