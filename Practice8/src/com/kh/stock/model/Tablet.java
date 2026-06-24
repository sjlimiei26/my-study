package com.kh.stock.model;

public class Tablet extends Device {
	private boolean supportStylus;
	
	public Tablet() {
		
	}
	public Tablet(String brand, String name, int price, boolean supportStylus) {
		super(brand, name, price);
		this.supportStylus = supportStylus;
	}
	
	@Override
	public String getInformation() {
		return String.format("[태블릿] %s | 펜 지원 여부: %s"
							, super.getInformation()
							, (supportStylus) ? "지원함" : "지원 안함");
	}
}







