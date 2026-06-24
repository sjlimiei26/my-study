package com.kh.pos.controller;

import com.kh.pos.model.CardPayment;
import com.kh.pos.model.Customer;
import com.kh.pos.model.MobilePay;
import com.kh.pos.model.PaymentMethod;

public class PosController {
	// - customer:Customer
	private Customer customer;
	private PaymentMethod[] paymentList;
	
	public PosController() {
		// 결제 수단 정보 초기화 
		/*
[0번] 모바일페이 - 플랫폼: 네이버페이, 제한연령: 12세, 한도: 1000000원 | 제공사: NAVER
[1번] 모바일페이 - 플랫폼: 토스페이, 제한연령: 14세, 한도: 2000000원 | 제공사: Toss
[2번] 신용/체크카드 - 카드명: 국민 나라사랑카드, 제한연령: 12세, 한도: 500000원 | 캐시백 여부: 캐시백 가능
[3번] 신용/체크카드 - 카드명: 신한 체크카드, 제한연령: 8세, 한도: 300000원 | 캐시백 여부: 캐시백 없음
		 */
		paymentList = new PaymentMethod[4];
		
		paymentList[0] = new MobilePay("네이버페이", 12, 1000000, "NAVER");
		paymentList[1] = new MobilePay("토스페이", 14, 2000000, "Toss");
		paymentList[2] = new CardPayment("국민 나라사랑카드", 12, 500000, true);
		paymentList[3] = new CardPayment("신한 체크카드", 8, 300000, false);
		
	}
	
	// + insertCustomer(c:Customer):void
	/*
	 * View 단에서 전달 받은 고객 객체 주소 값을 
	 * Controller의 customer 필드에 대입합니다.
	 */
	// 고객 정보 저장(추가)
	public void insertCustomer(Customer c) {
		customer = c;
	}
	// 고객 정보 조회
	public Customer getCustomerInfo() {
		return customer;
	}
	// 모든 결제 수단 정보 조회
	public PaymentMethod[] selectAllMethods() {
		return paymentList;
	}
	// 결제 수단 검색 -> 결제명 기준으로 검색
	public PaymentMethod[] searchMethod(String keyword) {
		// * 결제 수단 정보 -> paymentList 필드에서 관리 (PaymentMethod[])
		PaymentMethod[] result = new PaymentMethod[paymentList.length];
		int index = 0;
		
		for(PaymentMethod method : paymentList) {
			
			// method -> paymentList[인덱스] => PaymentMethod
			// method.name => 접근 불가!!
			String methodName = method.getName();
			
			// * 문자열.contains(키워드) : 문자열 내에 키워드가 포함되어 있으면 true, 그렇지 않으면 false
			//   ex) "application".contains("cat") => true
			//       "application".contains("c a t") => false
			
			if (methodName.contains(keyword)) {
				// 결제명 내에 keyword가 포함된 경우
//				result[index] = method;
//				index++;
				result[index++] = method;
			}
		}
		
		return result;		
	}
	
	public int processPayment(int index) {
		PaymentMethod method = paymentList[index];
		
		// 1) 기본 연령 미달 또는 모바일 페이 보안 기준 미달 1 리턴
		//       + 해당 결제 수단이 모바일 페이인 경우 나이가 제한연령+3세에 해당하는 지?
		int customerAge = customer.getAge();
		int methodMinAge = method.getMinAge();
		
		// 모바일 페이 결제 수단인지 확인
		//     => 모바일 페이 결제인 경우 제한연령 + 3 이하인지 확인
		if (method instanceof MobilePay && customerAge <= methodMinAge + 3) {
			return 1;
		}
		
		// 기본 연령 미달인지 확인 => 고객 나이가 제한연령 이하인지 확인
		if (customerAge <= methodMinAge) {
			return 1;
		}
		
		// 결제 수단이 카드 결제인 경우, 캐시백 여부 확인
		if (method instanceof CardPayment && ((CardPayment)method).isHasCashback()) {
			// 결과 리턴 전에 고객 포인트 점수 +500
			int currPoint = customer.getPoints();
			customer.setPoints( currPoint + 500 );
			
			return 2;
		}
		
		
		return 0;
	}
}







