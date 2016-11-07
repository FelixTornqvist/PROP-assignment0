/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode;

import prop.assignment0.*;

import java.io.IOException;

public class Parser implements IParser {
	private Tokenizer tokenizer;

	public Parser() {

	}

	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		tokenizer = new Tokenizer();
		tokenizer.open(fileName);

	}

	@Override
	public INode parse() throws IOException, TokenizerException, ParserException {
		tokenizer.moveNext();
		while(tokenizer.current().token() != Token.EOF){
			tokenizer.moveNext();
		}
		return null;
	}

	@Override
	public void close() throws IOException {

	}
}
