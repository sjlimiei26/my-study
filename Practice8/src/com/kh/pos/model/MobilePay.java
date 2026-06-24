package com.kh.pos.model;

public class MobilePay extends PaymentMethod {

	private String payVendor;
	
	public MobilePay() {
		
	}

	public MobilePay(String name, int minAge, int transactionLimit
					, String payVendor) {
		super(name, minAge, transactionLimit);
		this.payVendor = payVendor;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();   // PaymenthMethod.toString()
		return String.format("모바일 페이 - 플랫폼: %s | 제공사: %s"
								, super.toString(), payVendor);
	}

	
	
	
}
