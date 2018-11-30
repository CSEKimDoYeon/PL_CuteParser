package parser.ast;

public class BooleanNode extends Node {
	public boolean value;
	// Node 클래스를 상속, Boolean 형태의 True/False 정의.
	@Override
	public String toString() {
		return value ? "#T" : "#F";
	}
}