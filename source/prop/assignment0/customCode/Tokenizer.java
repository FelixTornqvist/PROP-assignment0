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


		switch (scanner.current()){
			case '{':
				break;
			case '}':
				break;
			case '=':
				break;
			case ';':
				break;
			case '+':
				break;
			case '-':
				break;
			case '*':
				break;
			case '/':
				break;
			case '(':
				break;
			case ')':
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
					current = new Lexeme(value, Token.IDENT);
				}

				break;
		}
	}

	@Override
	public void close() throws IOException {

	}
}
