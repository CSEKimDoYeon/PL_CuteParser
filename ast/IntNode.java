package parser.ast;
public class IntNode extends Node {
	public int value;
	// Node Ŭ���� ���, Intger���� Node�� �����ϴ� Ŭ����.
	@Override
	public String toString() {
		return "INT: " + Integer.toString(value);
	}
}
