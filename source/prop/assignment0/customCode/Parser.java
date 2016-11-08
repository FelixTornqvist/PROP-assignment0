/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode;

import prop.assignment0.*;
import prop.assignment0.customCode.Nodes.BlockNode;
import prop.assignment0.customCode.Nodes.StatementsNode;

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
		parseBlockNode();

//		while (tokenizer.current().token() != Token.EOF) {
//			tokenizer.moveNext();
//		}
		return null;
	}

	@Override
	public void close() throws IOException {

	}

	private BlockNode parseBlockNode() throws IOException, TokenizerException, ParserException {

		BlockNode blockNode;

		if (tokenizer.current().token() == Token.LEFT_CURLY) {

			tokenizer.moveNext();
			StatementsNode statementNode = parseStatementsNode();



			if (tokenizer.current().token() == Token.RIGHT_CURLY) {
				blockNode = new BlockNode(statementNode);




			} else {
				throw new ParserException("Right curly bracket missing");
			}


		} else {
			throw new ParserException("Left curly bracket missing");
		}

		return blockNode;

	}

	private StatementsNode parseStatementsNode() throws IOException, TokenizerException, ParserException {


		tokenizer.moveNext();
		return null;
	}


}
