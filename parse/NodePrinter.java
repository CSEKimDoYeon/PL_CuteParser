package parser.parse;

import java.io.PrintStream;

import parser.ast.ListNode;
import parser.ast.Node;

public class NodePrinter {
	PrintStream ps; // PrintStream 선언.

	public static NodePrinter getPrinter(PrintStream ps) {
		return new NodePrinter(ps);
		//해당 NodePrinter의 PrintStream return
	}

	private NodePrinter(PrintStream ps) {
		this.ps = ps;
		//PrintStream 생성자.
	}

	private void printList(Node head) {
		if (head == null) {
			ps.print("( ) ");
			return;
			// 노드가 없을 경우 아무것도 없는 리스트 ()를 출력한다.
		}
		ps.print("( ");
		printNode(head);
		// 노드가 존재할 경우 head를 print한다.
		ps.print(") ");
	}

	private void printNode(Node head) {
		if (head == null)
			return; // head가 null일 경우 종료.
		if (head instanceof ListNode) {
			ListNode ln = (ListNode) head;
			printList(ln.value);
			// head가 ListNode 일 경우 리스트의 value를 출력.
		} else {
			ps.print("[" + head + "] ");
			
		}
		printNode(head.getNext());
		// 해당 노드의 출력이 끝나면 다음 노드를 출력한다.
	}

	public void prettyPrint(Node root) {
		printNode(root);
		// 해당 노드의 root를 출력한다.
	}
}