package quiz23;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuiz01 {

	public static void main(String[] args) {
		
		/*
		 * 가격 형식만 찾아서 추출하세요.
		 * ex) ~~~원
		 */
		
		String str = "헠4,500원 헐~ 1,200원엏? 6000원ㅋ 120000원 ㅎㅎ";
		
		String pattern = "\\d,\\d{3}원|\\d{4,6}원";
		
		Matcher m = Pattern.compile(pattern).matcher(str);
		
		while(m.find()) {
			System.out.println("찾을 인덱스 위치:" + m.start());
			System.out.println("끝 인덱스 위치:" + m.end());
			System.out.println("추출:" + m.group());
		}
	}
}
