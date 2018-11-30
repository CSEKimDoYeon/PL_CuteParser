package parser.parse;

import java.io.PrintStream;

import parser.ast.ListNode;
import parser.ast.Node;

public class NodePrinter {
	PrintStream ps; // PrintStream ����.

	public static NodePrinter getPrinter(PrintStream ps) {
		return new NodePrinter(ps);
		//�ش� NodePrinter�� PrintStream return
	}

	private NodePrinter(PrintStream ps) {
		this.ps = ps;
		//PrintStream ������.
	}

	private void printList(Node head) {
		if (head == null) {
			ps.print("( ) ");
			return;
			// ��尡 ���� ��� �ƹ��͵� ���� ����Ʈ ()�� ����Ѵ�.
		}
		ps.print("( ");
		printNode(head);
		// ��尡 ������ ��� head�� print�Ѵ�.
		ps.print(") ");
	}

	private void printNode(Node head) {
		if (head == null)
			return; // head�� null�� ��� ����.
		if (head instanceof ListNode) {
			ListNode ln = (ListNode) head;
			printList(ln.value);
			// head�� ListNode �� ��� ����Ʈ�� value�� ���.
		} else {
			ps.print("[" + head + "] ");
			
		}
		printNode(head.getNext());
		// �ش� ����� ����� ������ ���� ��带 ����Ѵ�.
	}

	public void prettyPrint(Node root) {
		printNode(root);
		// �ش� ����� root�� ����Ѵ�.
	}
}