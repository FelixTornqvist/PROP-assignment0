/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

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
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "ExpressionNode", tabs);
		this.termChild.buildString(builder, tabs + 1);

		if (op != null && exprChild != null) {
			Utils.addIndentedStringLine(builder, op.toString(), tabs + 1);
			System.out.println(op.toString());
			this.exprChild.buildString(builder, tabs + 1);
		}
	}
}
