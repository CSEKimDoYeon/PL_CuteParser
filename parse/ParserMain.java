package parser.parse;

import java.io.File;
import java.io.FileReader;

public class ParserMain {
	public static final void main(String... args) throws Exception {
		ClassLoader cloader = ParserMain.class.getClassLoader();
		// file read�� ���� ��� �ۼ�(���� �ڵ�� ����)*/		
		File file = new File("C:\\Users\\�赵��\\Desktop\\as05.txt");
		System.out.println(file.getAbsolutePath()); 
		// ���� ������ file ��ü�� ���������� ������ Ȯ���ϱ� ���ؼ� ������ Path�� ���.
		CuteParser cuteParser = new CuteParser(file);
		// �Է¹��� ������ ������� cuteParser ����.
		NodePrinter.getPrinter(System.out).prettyPrint(cuteParser.parseExpr());

	}
}
