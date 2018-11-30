package parser.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

import lexer.Scanner;
import lexer.Token;
import lexer.TokenType;

import parser.ast.BinaryOpNode;
import parser.ast.BooleanNode;
import parser.ast.FunctionNode;
import parser.ast.IdNode;
import parser.ast.IntNode;
import parser.ast.ListNode;
import parser.ast.Node;

public class CuteParser {
	private Iterator<Token> tokens;
	// Token�� �ݺ��� ���ͷ����� ����.

	public CuteParser(File file) {
		try { // ������ �о ����ִ� ������ ���� ������ Tokenȭ �Ѵ�.
			tokens = Scanner.scan(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Token getNextToken() {
		// ��ū�� �ٷ� ������ ������ ��ū�� return�Ѵ�.
		if (!tokens.hasNext())
			return null;
		return tokens.next();
	}

	public Node parseExpr() {
		// ��ūȭ�� ��ū���� ������ ���߾� �Ľ��Ѵ�.
		Token t = getNextToken();
		if (t == null) {
			System.out.println("No more token");
			return null;
		}
		TokenType tType = t.type();
		String tLexeme = t.lexme();
		// ��ū�� type�� lexme�� ������ ���� ����.
		switch (tType) {
		case ID: // �ش� ��� Ÿ��(tTpye)�� ID�� ���.
			IdNode idNode = new IdNode();
			// ���ο� IdNode�� �����Ѵ�.
			idNode.value = tLexeme;
			return idNode;
		case INT: // �ش� ��� Ÿ���� Integer�� ���
			IntNode intNode = new IntNode();
			// ���ο� IntNode�� �����Ѵ�.
			if (tLexeme == null)
				// ���� IntNode�� ���� ���ٸ� "???" �� ����Ѵ�.
				System.out.println("???");
			intNode.value = new Integer(tLexeme);
			return intNode;
		// BinaryOpNode +, -, /, *�� �ش�
		case DIV:
		case EQ:
		case MINUS:
		case GT:
		case PLUS:
		case TIMES:
		case LT:
			BinaryOpNode binaryNode = new BinaryOpNode();
			// �ش� ��尡 enum�� ���ǵ� ���� ��������� ��쿡 binaryNode�� �����Ѵ�.
			binaryNode.setValue(tType);
			// ������ binaryNode�� tType Value�� �������ش�.
			return binaryNode;
		// FunctionNode Ű���尡 FunctionNode�� �ش�
		case ATOM_Q:
		case CAR:
		case CDR:
		case COND:
		case CONS:
		case DEFINE:
		case EQ_Q:
		case LAMBDA:
		case NOT:
		case NULL_Q:
			FunctionNode functionNode = new FunctionNode();
			// �ش� Ÿ���� Funtion�� ��� FunctionNode�� ���E�Ѵ�.
			functionNode.setValue(tType);
			// ������ FunctionNode�� tType Value�� �����Ѵ�.
			
			return functionNode;
			// ���� ä��� (BinaryOp����)
			// BooleanNode
		case FALSE:
			BooleanNode falseNode = new BooleanNode();
			falseNode.value = false;
			return falseNode;
		case TRUE:
			BooleanNode trueNode = new BooleanNode();
			trueNode.value = true;
			return trueNode;
		// case L_PAREN�� ���� case R_PAREN�� ���
		// L_PAREN�� ��� parseExprList()�� ȣ���Ͽ� ó��
		case L_PAREN:
			ListNode listNode = new ListNode();
			listNode.value = parseExprList();
			return listNode;
		case R_PAREN:
			return null;
		default:
			// head�� next�� ����� head�� ��ȯ�ϵ��� �ۼ�
			System.out.println("Parsing Error!");
			return null;
		}
	}

	// List�� value�� �����ϴ� �޼ҵ�
	private Node parseExprList() {
		Node head = parseExpr();
		// head�� next ��带 set�Ͻÿ�.
		if (head == null) // if next token is RPAREN
			return null;
		head.setNext(parseExprList());
		return head;
	}
}