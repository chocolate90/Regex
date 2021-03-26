package quiz24;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class RegexQuiz {

	public static void main(String[] args) {
		
		/*
		 * 1. Product 클래스 day, store, grade, detail, price 맴버변수 선언
		 * 2. getter, setter 은닉 클래스
		 * 
		 * 3. Product를 제네릭으로 갖는 List를 생성
		 * 4. BufferedReader를 이용해서 건담.txt 읽어들인다.
		 * 5. while문 안에서 readLine으로 한줄씩 읽어서 처리
		 * 6. 날짜, 지점, 등급, 상세, 가격 패턴을 분석해서 Product에 저장한 후 리스트에 추가
		 *    상세 - 앞 뒤 인덱스를 이용해서 추출
		 * 
		 * 7. 외부 라이브러리(POI)를 사용해서 분석한 패턴을 xlsx 엑셀파일로 추출한다. 
		 */
		
		List<Product> list = new ArrayList<>();
		
		BufferedReader br = null;
		String path = "C:\\Users\\woohyun\\Desktop\\programming\\course\\java\\workspace\\Quiz\\src\\quiz24\\건담.txt";
		
		try {
			br = new BufferedReader(new InputStreamReader( new FileInputStream(path), "utf-8"));
			
			String str = "";
			int count = 1;
			while((str = br.readLine()) != null) {
//				System.out.println(str);
				
//				System.out.println(count++);
				Product p = new Product();
				
				String pattern = "\\d+-\\d{2}-\\d+";
				String pattern1 = "[가-힣]+\\s[가-힣]+";
				String pattern2 = "\\[[A-Z]+\\]|\\[[가-힣]+\\]";
				String pattern3 = "\\d+,\\d+원|\\d+원";
				
//				String[] arr = {pattern, pattern1, pattern2, pattern3};
				
				Matcher m = Pattern.compile(pattern).matcher(str);
				Matcher m1 = Pattern.compile(pattern1).matcher(str);
				Matcher m2 = Pattern.compile(pattern2).matcher(str);
				Matcher m3 = Pattern.compile(pattern3).matcher(str);
				
				if(m.find() && m1.find() && m2.find() && m3.find()) {
					
					p.setDay(m.group());
					p.setStore(m1.group());
					p.setGrade(m2.group());
					String detail = str.substring(m2.end()+1 , m3.start()-1);
					p.setDetail(detail);
					p.setPrice(m3.group());
				}
				
				list.add(p);
			}
			list.forEach((p) -> System.out.println(p.toString()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------추출--------------------");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;
		
		cell = row.createCell(0);
		cell.setCellValue("날짜");
		
		cell = row.createCell(1);
		cell.setCellValue("지점");
		
		cell = row.createCell(2);
		cell.setCellValue("등급");
		
		cell = row.createCell(3);
		cell.setCellValue("상세");
		
		cell = row.createCell(4);
		cell.setCellValue("가격");
		
		Product p;
		for(int i = 0; i < list.size(); i++) {
			p = list.get(i);
			
			row = sheet.createRow(i+1);
			
			cell = row.createCell(0);
			cell.setCellValue(p.getDay());
			
			cell = row.createCell(1);
			cell.setCellValue(p.getStore());
			
			cell = row.createCell(2);
			cell.setCellValue(p.getGrade());
			
			cell = row.createCell(3);
			cell.setCellValue(p.getDetail());
			
			cell = row.createCell(4);
			cell.setCellValue(p.getPrice());
		}
		
		File file = new File("C:\\Users\\woohyun\\Desktop\\programming\\course\\java\\workspace\\Quiz\\src\\quiz24\\건담1.xlsx");
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			wb.write(fos);
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			
			try {
				wb.close();
				fos.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}
}
