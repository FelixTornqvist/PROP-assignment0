/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;
import prop.assignment0.Token;

public class ExpressionNode implements INode {

	private TermNode termChild;
	private Lexeme op;
	private ExpressionNode exprChild;

	public ExpressionNode(TermNode termChild) {
		this.termChild = termChild;
	}

	public ExpressionNode(TermNode termChild, Lexeme op, ExpressionNode exprChild) {
		this.termChild = termChild;
		this.op = op;
		this.exprChild = exprChild;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		Float result;
		Float termEval = (Float) termChild.evaluate(null);

		if (args != null) {
			termEval = termEval * -1;
		}

		if (op != null && exprChild != null) {
			Float exprEval;

			if (op.token() == Token.SUB_OP) {
				Object[] subtract = new Lexeme[]{op};
				exprEval = (Float) exprChild.evaluate(subtract);
			} else {
				exprEval = (Float) exprChild.evaluate(null);
			}

			result = termEval + exprEval;
		} else {
			result = termEval;
		}
		return result;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "ExpressionNode", tabs);
		this.termChild.buildString(builder, tabs + 1);

		if (op != null && exprChild != null) {
			Utils.addIndentedStringLine(builder, op.toString(), tabs + 1);
			this.exprChild.buildString(builder, tabs + 1);
		}
	}
}
