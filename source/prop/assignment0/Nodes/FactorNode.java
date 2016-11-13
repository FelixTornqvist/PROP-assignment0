/**
 * Authors: Annika Svedin & Felix Törnqvist
 * */

package prop.assignment0.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;
import prop.assignment0.Token;
import prop.assignment0.VariableContainer;

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
		Float result = new Float(0);

		if (lexeme != null) {
			if (lexeme.token() == Token.IDENT) {
				String varName = lexeme.value().toString();
				result = VariableContainer.getValue(varName);
			} else if (lexeme.token() == Token.INT_LIT){
				result = (Float) lexeme.value();
			}
		} else if(exprChild != null) {
			result = (Float) exprChild.evaluate(null);
		}
		return result;
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
