package parser.ast;

import java.util.HashMap;
import java.util.Map;

import lexer.TokenType;

public class FunctionNode extends Node { // binaryOpNode클래스를 보고 참고해서 작성
	// Node 클래스 상속, 함수 Node의 Type을 지정하는 클래스.
	enum FunctionType {
		//TokenType에 따라 해당하는 값을 저장하는 집합.
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
		static { // TokenType를 Map 자료구조를 사용하여 key값과 함께 put해준다.
			for (FunctionType bType : FunctionType.values()) {
				fromTokenType.put(bType.tokenType(), bType);
			}
		}

		static FunctionType getFuncType(TokenType tType) {
			return fromTokenType.get(tType);
		} // 해당 토큰의 FunctionType를 return 한다.

		abstract TokenType tokenType();
	}

	public FunctionType value;

	@Override
	public String toString() {
		// enum에서 저장된 해당 Fucntion name을 출력한다.
		return value.name();
	}

	public void setValue(TokenType tType) {
		// 해당 Fucntion Node 파라미터로 들어온 값을 setting한다.
		FunctionType fType = FunctionType.getFuncType(tType);
		value = fType;
	}
}