/**
 * Authors: Annika Svedin & Felix Törnqvist
 */

package prop.assignment0;

import prop.assignment0.*;
import java.io.IOException;

public class Tokenizer implements ITokenizer {

	private Scanner scanner;
	private Lexeme current;

	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		scanner = new Scanner();
		scanner.open(fileName);
		scanner.moveNext();
	}

	@Override
	public Lexeme current() {
		return current;
	}

	@Override
	public void moveNext() throws IOException, TokenizerException {
		while (Character.isWhitespace(scanner.current())) {
			scanner.moveNext();
		}

		if (scanner.current() == Scanner.EOF) {
			current = new Lexeme("EOF", Token.EOF);
			return;
		}

		switch (scanner.current()) {
			case '{':
				current = new Lexeme("{", Token.LEFT_CURLY);
				scanner.moveNext();
				break;
			case '}':
				current = new Lexeme("}", Token.RIGHT_CURLY);
				scanner.moveNext();
				break;
			case '=':
				current = new Lexeme("=", Token.ASSIGN_OP);
				scanner.moveNext();
				break;
			case ';':
				current = new Lexeme(";", Token.SEMICOLON);
				scanner.moveNext();
				break;
			case '+':
				current = new Lexeme("+", Token.ADD_OP);
				scanner.moveNext();
				break;
			case '-':
				current = new Lexeme("-", Token.SUB_OP);
				scanner.moveNext();
				break;
			case '*':
				current = new Lexeme("*", Token.MULT_OP);
				scanner.moveNext();
				break;
			case '/':
				current = new Lexeme("/", Token.DIV_OP);
				scanner.moveNext();
				break;
			case '(':
				current = new Lexeme("(", Token.LEFT_PAREN);
				scanner.moveNext();
				break;
			case ')':
				current = new Lexeme(")", Token.RIGHT_PAREN);
				scanner.moveNext();
				break;

			default:
				char firstChar = scanner.current();
				String word = "";

				if (validChar(firstChar)) {
					while (validChar(scanner.current())) {
						word += scanner.current();
						scanner.moveNext();
					}
					current = new Lexeme(word, Token.IDENT);

				} else if (Character.isDigit(firstChar)) {
					while (Character.isDigit(scanner.current())) {
						word += scanner.current();
						scanner.moveNext();
					}
					Float value = new Float(Integer.parseInt(word));
					current = new Lexeme(value, Token.INT_LIT);
				} else {
					throw new TokenizerException("Illegal character: " + firstChar);
				}
				break;
		}
	}

	private boolean validChar(char c) {
		return (c >= 'a' && c <= 'z');
	}

	@Override
	public void close() throws IOException {
		if (scanner != null) {
			scanner.close();
		}
	}
}
