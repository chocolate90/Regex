package regex.basic;

public class RegexEx01 {

	public static void main(String[] args) {
		
		// regex를 매개변수로 받는 메서드는 정규표현식을 적용할 수 있다.
		
		String info = "홍길자|30세|서울시 강남구|017-1111-1234";
		
		// 전화번호 형식을 찾아서 ***-****-****로 변경
		
		String pattern = "\\d{3}-\\d{3,4}-\\d{4}"; // 전화번호 정규표현 형식
		
		info = info.replaceAll(pattern, "***-****-****");
		
		System.out.println(info);
	}
}
