/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode;

import prop.assignment0.*;
import prop.assignment0.customCode.Nodes.*;

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
		return parseBlockNode();

//		while (tokenizer.current().token() != Token.EOF) {
//			tokenizer.moveNext();
//		}
	}

	@Override
	public void close() throws IOException {

	}

	private BlockNode parseBlockNode() throws IOException, TokenizerException, ParserException {
		BlockNode blockNode;

		if (tokenizer.current().token() == Token.LEFT_CURLY) {
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
		StatementsNode statementsNode;
		tokenizer.moveNext();

		if (tokenizer.current().token() == Token.IDENT) {
			statementsNode = new StatementsNode(parseAssignmentNode(), parseStatementsNode());
		} else {
			statementsNode = new StatementsNode();
		}
		return statementsNode;
	}

	private AssignmentNode parseAssignmentNode() throws IOException, TokenizerException, ParserException {
		ExpressionNode expressionNode;
		Lexeme id = tokenizer.current();
		tokenizer.moveNext();

		if (tokenizer.current().token() == Token.ASSIGN_OP) {
			tokenizer.moveNext();
			expressionNode = parseExpressionNode();

			if (tokenizer.current().token() == Token.SEMICOLON) {
				return new AssignmentNode(id, expressionNode);

			} else {
				throw new ParserException("Semicolon not found");
			}
		}

		return null;
	}

	private ExpressionNode parseExpressionNode() throws IOException, TokenizerException, ParserException {
		TermNode termNode = parseTermNode();

		if (tokenizer.current().token() == Token.ADD_OP || tokenizer.current().token() == Token.SUB_OP) {
			Lexeme op = tokenizer.current();
			tokenizer.moveNext();
			return new ExpressionNode(termNode, op, parseExpressionNode());
		}
		return new ExpressionNode(termNode);
	}

	private TermNode parseTermNode() throws IOException, TokenizerException, ParserException {
		FactorNode factorNode = parseFactorNode();

		if (tokenizer.current().token() == Token.MULT_OP || tokenizer.current().token() == Token.DIV_OP) {
			Lexeme op = tokenizer.current();
			tokenizer.moveNext();

			return new TermNode(factorNode, op, parseTermNode());
		} else {
			return new TermNode(factorNode);
		}
	}

	private FactorNode parseFactorNode() throws IOException, TokenizerException, ParserException {
		ExpressionNode expressionNode;

		if (tokenizer.current().token() == Token.INT_LIT || tokenizer.current().token() == Token.IDENT) {
			FactorNode factorNode = new FactorNode(tokenizer.current());
			tokenizer.moveNext();
			return factorNode;

		} else if (tokenizer.current().token() == Token.LEFT_PAREN) {
			tokenizer.moveNext();
			expressionNode = parseExpressionNode();

			if (tokenizer.current().token() == Token.RIGHT_PAREN) {
				tokenizer.moveNext();
				return new FactorNode(expressionNode);

			} else {
			throw new ParserException("Right parenthesis not found");
			}

		} else {
			throw new ParserException("Factor not found");
		}

	}
}
