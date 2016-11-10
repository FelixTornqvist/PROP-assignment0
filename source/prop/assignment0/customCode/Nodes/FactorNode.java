/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class FactorNode implements INode {
	private Lexeme lexeme;
	private ExpressionNode exprChild;

	public FactorNode(Lexeme lexeme) {
		this.lexeme = lexeme;
	}

	public FactorNode(ExpressionNode exprChild) {
		this.exprChild = exprChild;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "FactorNode", tabs);

		if (lexeme != null) {
			Utils.addIndentedStringLine(builder, lexeme.toString(), tabs + 1);
		}

		if (this.exprChild != null) {
			Utils.addIndentedStringLine(builder, "LEFT_PAREN (", tabs + 1);

			/** looks weird to me to not add tabs with 2 but according to facit it's correct */
			this.exprChild.buildString(builder, tabs + 1);
			Utils.addIndentedStringLine(builder, "RIGHT_PAREN )", tabs + 1);
		}
	}
}
