package parser.ast;

public class BooleanNode extends Node {
	public boolean value;
	// Node Ŭ������ ���, Boolean ������ True/False ����.
	@Override
	public String toString() {
		return value ? "#T" : "#F";
	}
}