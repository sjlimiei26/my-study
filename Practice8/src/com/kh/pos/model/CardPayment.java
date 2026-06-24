package com.kh.pos.model;

public class CardPayment extends PaymentMethod {
	
	private boolean hasCashback;

	public CardPayment() {
		super();
	}

	public CardPayment(String name, int minAge, int transactionLimit
						, boolean hasCashback) {
		super(name, minAge, transactionLimit);
		
		this.hasCashback = hasCashback;
	}
	
	// * hasCashback getter 메소드 => Controller 작업 중 추가
	//   -> isXXX (필드 타입이 boolean 인 경우만!)
	public boolean isHasCashback() {
		return hasCashback;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// return super.toString();
		// 신용/체크카드 - 카드명: 국민 나라사랑카드, 제한연령: 12세, 한도: 500000원 | 캐시백 여부: 캐시백 가능
//		return String.format("신용/체크카드 - 카드명: %s | 캐시백 여부: %s"
//							, super.toString(), hasCashback ? "캐시백 가능" : "캐시백 없음");
		
		return "신용/체크카드 - 카드명: " + name + ", 제한연령: " + minAge
				+ ", 한도: " + transactionLimit + "원 | 캐시백 여부: " 
					+ (hasCashback ? "캐시백 가능" : "캐시백 없음"); 
	}
	

}



