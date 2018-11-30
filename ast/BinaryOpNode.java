package parser.ast;
import java.util.HashMap;
import java.util.Map;

import lexer.TokenType;

public class BinaryOpNode extends Node {
	//Node 클래스 상속, 연산자 TokenType를 정의
	enum BinType {
		// 연산자에 따라 TokenType를 지정하는 집합.
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
		private static Map<TokenType, BinType> fromTokenType
		= new HashMap<TokenType, BinType>();
		static { // TokenType를 Map 자료구조를 사용하여 key값과 함께 put해준다.
			for (BinType bType : BinType.values()) {
				fromTokenType.put(bType.tokenType(), bType);
			}
		}

		static BinType getBinType(TokenType tType) {
			return fromTokenType.get(tType);
		} // 해당 토큰의 BinType를 return 한다.

		abstract TokenType tokenType();
	}

	public BinType value;

	public void setValue(TokenType tType) {
		BinType bType = BinType.getBinType(tType);
		value = bType; // 해당 토큰에 Type를 Setting한다.
	}

	@Override
	public String toString() {
		return value.name();
	}
}