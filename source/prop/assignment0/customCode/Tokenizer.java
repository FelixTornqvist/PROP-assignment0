/**
 * Authors: Annika Svedin, Felix Törnqvist
 */

package prop.assignment0.customCode;

import prop.assignment0.ITokenizer;
import prop.assignment0.Lexeme;
import prop.assignment0.TokenizerException;

import java.io.IOException;

public class Tokenizer implements ITokenizer {
	@Override
	public void open(String fileName) throws IOException, TokenizerException {

	}

	@Override
	public Lexeme current() {
		return null;
	}

	@Override
	public void moveNext() throws IOException, TokenizerException {

	}

	@Override
	public void close() throws IOException {

	}
}
