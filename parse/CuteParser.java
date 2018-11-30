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
	// Token을 반복할 이터레이터 선언.

	public CuteParser(File file) {
		try { // 파일을 읽어서 들어있는 내용을 띄어쓰기 단위로 Token화 한다.
			tokens = Scanner.scan(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Token getNextToken() {
		// 토큰의 바로 다음에 나오는 토큰을 return한다.
		if (!tokens.hasNext())
			return null;
		return tokens.next();
	}

	public Node parseExpr() {
		// 토큰화한 토큰들을 문법에 맞추어 파싱한다.
		Token t = getNextToken();
		if (t == null) {
			System.out.println("No more token");
			return null;
		}
		TokenType tType = t.type();
		String tLexeme = t.lexme();
		// 토큰의 type과 lexme를 저장할 변수 선언.
		switch (tType) {
		case ID: // 해당 노드 타입(tTpye)이 ID일 경우.
			IdNode idNode = new IdNode();
			// 새로운 IdNode를 생성한다.
			idNode.value = tLexeme;
			return idNode;
		case INT: // 해당 노드 타입이 Integer일 경우
			IntNode intNode = new IntNode();
			// 새로운 IntNode를 생성한다.
			if (tLexeme == null)
				// 만약 IntNode에 값이 없다면 "???" 를 출력한다.
				System.out.println("???");
			intNode.value = new Integer(tLexeme);
			return intNode;
		// BinaryOpNode +, -, /, *가 해당
		case DIV:
		case EQ:
		case MINUS:
		case GT:
		case PLUS:
		case TIMES:
		case LT:
			BinaryOpNode binaryNode = new BinaryOpNode();
			// 해당 노드가 enum에 정의된 다음 연사들일일 경우에 binaryNode를 생성한다.
			binaryNode.setValue(tType);
			// 생성한 binaryNode에 tType Value를 설정해준다.
			return binaryNode;
		// FunctionNode 키워드가 FunctionNode에 해당
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
			// 해당 타입이 Funtion일 경우 FunctionNode를 생섷한다.
			functionNode.setValue(tType);
			// 생성한 FunctionNode에 tType Value를 설정한다.
			
			return functionNode;
			// 내용 채우기 (BinaryOp참고)
			// BooleanNode
		case FALSE:
			BooleanNode falseNode = new BooleanNode();
			falseNode.value = false;
			return falseNode;
		case TRUE:
			BooleanNode trueNode = new BooleanNode();
			trueNode.value = true;
			return trueNode;
		// case L_PAREN일 경우와 case R_PAREN일 경우
		// L_PAREN일 경우 parseExprList()를 호출하여 처리
		case L_PAREN:
			ListNode listNode = new ListNode();
			listNode.value = parseExprList();
			return listNode;
		case R_PAREN:
			return null;
		default:
			// head의 next를 만들고 head를 반환하도록 작성
			System.out.println("Parsing Error!");
			return null;
		}
	}

	// List의 value를 생성하는 메소드
	private Node parseExprList() {
		Node head = parseExpr();
		// head의 next 노드를 set하시오.
		if (head == null) // if next token is RPAREN
			return null;
		head.setNext(parseExprList());
		return head;
	}
}