/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class FactorNode implements INode {
	private Lexeme lexeme;
	private ExpressionNode expressionNode;

	public FactorNode(Lexeme lexeme) {
		this.lexeme = lexeme;
	}

	public FactorNode(ExpressionNode expressionNode) {
		this.expressionNode = expressionNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.tabIndenter(builder, tabs);
		builder.append("FactorNode");
		builder.append(System.getProperty("line.separator"));
		tabs++;

		if (expressionNode != null) {
			builder.append("(");
			builder.append(System.getProperty("line.separator"));
			tabs++;
			expressionNode.buildString(builder, tabs);

			builder.append(")");
			builder.append(System.getProperty("line.separator"));
		}

	}
}
