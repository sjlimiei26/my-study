package com.kh.stock.model;

public class SmartPhone extends Device {
	private String os;
	
	public SmartPhone() {
		
	}
	
	public SmartPhone(String brand, String name, int price, String os) {
		// (1) 직접 대입(초기화)
//		this.brand = brand;
//		this.name = name;
//		this.price = price;
		// (2) 부모 클래스의 생성자 사용 ***
		super(brand, name, price);
		
		this.os = os;
	}
	
	@Override
	public String getInformation() {
		// [스마트폰] 브랜드: Apple, 제품명: iPhone 15, 가격: 1250000원 | OS: iOS
		return "[스마트폰] " + super.getInformation() + " | OS: " + os;
	}
	
}








