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
		Utils.addIndentedStringLine(builder, "FactorNode", tabs);
		tabs++;

		if (expressionNode != null) {
			Utils.addIndentedStringLine(builder, "LEFT_PAREN (", tabs + 1);
			expressionNode.buildString(builder, tabs + 2);
			Utils.addIndentedStringLine(builder, "RIGHT_PAREN )", tabs + 1);
		}

	}
}
