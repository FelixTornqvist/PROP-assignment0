/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class ExpressionNode implements INode {

	private TermNode termNode;
	private Lexeme op;
	private ExpressionNode expr;

	public ExpressionNode(TermNode termNode) {
		this.termNode = termNode;
	}

	public ExpressionNode(TermNode termNode, Lexeme op, ExpressionNode expr) {
		this.termNode = termNode;
		this.op = op;
		this.expr = expr;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.tabIndenter(builder, tabs);
		builder.append("ExpressionNode");
		builder.append(System.getProperty("line.separator"));
		tabs++;

		if (termNode != null) {
			termNode.buildString(builder, tabs);
		}


	}
}
