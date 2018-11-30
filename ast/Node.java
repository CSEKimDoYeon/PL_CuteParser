package parser.ast;

public abstract class Node {
	Node next;
	// 모든 ___Node들의 기본 틀을 정의하는 Node 클래스.
	public Node() { // 새로우 노드 생성자 정의.
		this.next = null;
	}

	public void setNext(Node next) {
		// 해당 노드에 Next Node를 설정한다.
		this.next = next;
	}

	public void setLastNext(Node next) {
		// 해당 노드의 끝에 새로운 노드를 추가한다.
		if (this.next != null)
			this.next.setLastNext(next);
		else
			this.next = next;
	}

	public Node getNext() {
		// 해당 노드의 다음 노드를 가져온다.
		return next;
	}
}