/**
 * Authors: Annika Svedin, Felix Törnqvist
 */

package prop.assignment0.customCode;

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
		while(Character.isWhitespace(scanner.current())){
			scanner.moveNext();
		}

		switch (scanner.current()){
			case '{':
				current = new Lexeme("{", Token.LEFT_CURLY);
				break;
			case '}':
				current = new Lexeme("}", Token.RIGHT_CURLY);
				break;
			case '=':
				current = new Lexeme("=", Token.ASSIGN_OP);
				break;
			case ';':
				current = new Lexeme(";", Token.SEMICOLON);
				break;
			case '+':
				current = new Lexeme("+", Token.ADD_OP);
				break;
			case '-':
				current = new Lexeme("-", Token.SUB_OP);
				break;
			case '*':
				current = new Lexeme("*", Token.MULT_OP);
				break;
			case '/':
				current = new Lexeme("/", Token.DIV_OP);
				break;
			case '(':
				current = new Lexeme("(", Token.LEFT_PAREN);
				break;
			case ')':
				current = new Lexeme(")", Token.RIGHT_PAREN);
				break;

			default:
				String word = "";

				while (!Character.isWhitespace(scanner.current())) {
					word += scanner.current();
					scanner.moveNext();
				}

				char  firstChar = word.charAt(0);

				if (Character.isLetter(firstChar)) {
					current = new Lexeme(word, Token.IDENT);

				} else if (Character.isDigit(firstChar)) {

					Integer value = new Integer(Integer.parseInt(word));
					current = new Lexeme(value, Token.INT_LIT);
				}
				break;
		}
		scanner.moveNext();
	}

	@Override
	public void close() throws IOException {

	}
}
