/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode;

import prop.assignment0.INode;
import prop.assignment0.IParser;
import prop.assignment0.ParserException;
import prop.assignment0.TokenizerException;

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
		return null;
	}

	@Override
	public void close() throws IOException {

	}
}
