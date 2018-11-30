package parser.ast;

public abstract class Node {
	Node next;
	// ��� ___Node���� �⺻ Ʋ�� �����ϴ� Node Ŭ����.
	public Node() { // ���ο� ��� ������ ����.
		this.next = null;
	}

	public void setNext(Node next) {
		// �ش� ��忡 Next Node�� �����Ѵ�.
		this.next = next;
	}

	public void setLastNext(Node next) {
		// �ش� ����� ���� ���ο� ��带 �߰��Ѵ�.
		if (this.next != null)
			this.next.setLastNext(next);
		else
			this.next = next;
	}

	public Node getNext() {
		// �ش� ����� ���� ��带 �����´�.
		return next;
	}
}