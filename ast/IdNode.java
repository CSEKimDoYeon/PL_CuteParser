package parser.ast;

public class IdNode extends Node {
	public String value;
	// Node Ŭ���� ���, ID�� �����ϴ� IdNode Ŭ����.
	@Override
	public String toString() {
		return "ID: " + value;
	}
}
