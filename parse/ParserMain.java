package parser.parse;

import java.io.File;
import java.io.FileReader;

public class ParserMain {
	public static final void main(String... args) throws Exception {
		ClassLoader cloader = ParserMain.class.getClassLoader();
		// file read는 편한 대로 작성(위의 코드는 예시)*/		
		File file = new File("C:\\Users\\김도연\\Desktop\\as05.txt");
		System.out.println(file.getAbsolutePath()); 
		// 파일 정보가 file 객체에 정상적으로 들어갔는지 확인하기 위해서 파일의 Path를 출력.
		CuteParser cuteParser = new CuteParser(file);
		// 입력받은 파일을 대상으로 cuteParser 실행.
		NodePrinter.getPrinter(System.out).prettyPrint(cuteParser.parseExpr());

	}
}
