package parser.ast;

import java.util.HashMap;
import java.util.Map;

import lexer.TokenType;

public class FunctionNode extends Node { // binaryOpNodeŬ������ ���� �����ؼ� �ۼ�
	// Node Ŭ���� ���, �Լ� Node�� Type�� �����ϴ� Ŭ����.
	enum FunctionType {
		//TokenType�� ���� �ش��ϴ� ���� �����ϴ� ����.
		MINUS {
			TokenType tokenType() {
				return TokenType.MINUS;
			}
		},
		PLUS {
			TokenType tokenType() {
				return TokenType.PLUS;
			}
		},
		TIMES {
			TokenType tokenType() {
				return TokenType.TIMES;
			}
		},
		DIV {
			TokenType tokenType() {
				return TokenType.DIV;
			}
		},
		LT {
			TokenType tokenType() {
				return TokenType.LT;
			}
		},
		GT {
			TokenType tokenType() {
				return TokenType.GT;
			}
		},
		EQ {
			TokenType tokenType() {
				return TokenType.EQ;
			}
		};
		private static Map<TokenType, FunctionType> fromTokenType 
		= new HashMap<TokenType, FunctionType>();
		static { // TokenType�� Map �ڷᱸ���� ����Ͽ� key���� �Բ� put���ش�.
			for (FunctionType bType : FunctionType.values()) {
				fromTokenType.put(bType.tokenType(), bType);
			}
		}

		static FunctionType getFuncType(TokenType tType) {
			return fromTokenType.get(tType);
		} // �ش� ��ū�� FunctionType�� return �Ѵ�.

		abstract TokenType tokenType();
	}

	public FunctionType value;

	@Override
	public String toString() {
		// enum���� ����� �ش� Fucntion name�� ����Ѵ�.
		return value.name();
	}

	public void setValue(TokenType tType) {
		// �ش� Fucntion Node �Ķ���ͷ� ���� ���� setting�Ѵ�.
		FunctionType fType = FunctionType.getFuncType(tType);
		value = fType;
	}
}