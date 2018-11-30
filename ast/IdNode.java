package parser.ast;

public class IdNode extends Node {
	public String value;
	// Node 클래스 상속, ID를 정의하는 IdNode 클래스.
	@Override
	public String toString() {
		return "ID: " + value;
	}
}
