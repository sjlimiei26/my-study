package com.kh.pos.model;

public class PaymentMethod {
	
	protected String name;
	protected int minAge;
	protected int transactionLimit;
	
	public PaymentMethod() {
		super();
	}

	public PaymentMethod(String name, int minAge, int transactionLimit) {
		super();
		this.name = name;
		this.minAge = minAge;
		this.transactionLimit = transactionLimit;
	}
	
	// * Controller 에서 name의 값을 확인하기 위해 메소드 추가
	public String getName() {
		return name;
	}
	
	// * Controller 에서 minAge 값을 확인하기 위해 메소드 추가
	public int getMinAge() {
		return minAge;
	}

	@Override
	public String toString() {
		// {name}, 제한연령: {minAge}세, 한도: {transactionLimit}원
		return String.format("%s, 제한연령: %d세, 한도: %d원"
							, name, minAge, transactionLimit);
	}
		

}
