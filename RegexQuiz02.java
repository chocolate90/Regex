package quiz23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuiz02 {

	public static void main(String[] args) {
		
		/*
		 * 상품번호, 편의점명, (도시락명), 가격으로 분리해서 출력
		 */
		
		String str = "123123-456456 GS25(마늘햄쌈) 4,400원";
		String str2 = "111111-222222 GS25(치킨도시락) 5,500원";
		String str3 = "222222-333333 MIMISTOP(제육볶음) 5,700원";
		
		String pattern = "\\d+-\\d+";
		String pattern1 = "[A-Z]{2}\\d{2}|\\w{8}"; // [A-Z]+[0-9]*
		String pattern2 = "\\([가-힣]{4,5}\\)";
		String pattern3 = "\\d,\\d{3}원";
		
		
		String[] arr = {str, str2, str3};
		String[] arr1 = {pattern, pattern1, pattern2, pattern3};
		
		for(int i = 0; i < arr.length; i++) {
			
			for(int j = 0; j < arr1.length; j++) {
				
				Matcher m = Pattern.compile(arr1[j]).matcher(arr[i]);
				
				if(m.find()) {
					System.out.println(m.group());
				}
			}
			System.out.println();
		}
		
	}
}
