package regex.basic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx02 {

	public static void main(String[] args) {
		
		/* 많이 사용되는 정규표현 형식들
		 * \\w 영문자 숫자
		 * \\w+ 영문자 숫자 여러개
		 * 
		 * \\d 숫자만
		 * \\d+ 숫자 여러개
		 * 
		 * \\d{3} 숫자 3개
		 * \\d{3,5} 숫자 3개 이상 5개 이하
		 * 
		 * [0-9] 0-9사이의 문자를 1개 찾음
		 * [a-z] a-z사이의 문자를 1개 찾음
		 * [A-Z] A-Z사이의 문자를 1개 찾음
		 * [가-힣] 한글 1개를 찾음
		 * [가-힣]{3} 한글 3개를 찾음
		 * [가-힣]+ 한글 여러개를 찾음
		 */
		
		String info = "30세/서울시 강남구/02-123-3452/010-1234-5678/kkk@naver.com";
		
		// 전화번호 형식
		String pattern = "\\d{2,3}-\\d{3,4}-\\d{4}";
		
		// 1. 정규표현 엔진 생성
		Pattern p = Pattern.compile(pattern);
		
		// 2. 정규표현 엔진 적용
		Matcher m = p.matcher(info);
		
		while(m.find()) { // 패턴을 찯으면 true, 없다면 false
			System.out.println("찾은 인덱스 위치:" + m.start());
			System.out.println("끝 인덱스 위치:" + m.end());
			System.out.println("추출:" + m.group());
			
		}
		
		System.out.println("----------------------------------------------");
		
		// 이메일 (정규표현식 메타문자에 포함되지 않는 글자 or 특수문자는 그대로 사용하면 된다.)
		String pattern2 = "\\w+@\\w+.\\w+";
		
		Matcher m2 = Pattern.compile(pattern2).matcher(info);
		
		while(m2.find()) {
			System.out.println("찾은 인덱스 위치:" + m2.start());
			System.out.println("끝 인덱스 위치:" + m2.end());
			System.out.println("추출:" + m2.group());
		}
	}
}
