package parser.ast;
public class IntNode extends Node {
	public int value;
	// Node 클래스 상속, Intger형의 Node를 정의하는 클래스.
	@Override
	public String toString() {
		return "INT: " + Integer.toString(value);
	}
}
