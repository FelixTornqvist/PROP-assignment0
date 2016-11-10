/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;
import prop.assignment0.customCode.VariableContainer;

public class AssignmentNode implements INode {

	private ExpressionNode expressionNode;
	private Lexeme id;

	public AssignmentNode(Lexeme id, ExpressionNode expressionNode) {
		this.id = id;
		this.expressionNode = expressionNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		System.out.println("    assign begin: "+id.value());

		Float exprEval = (Float) expressionNode.evaluate(null);

		VariableContainer.setValue(id.value().toString(), exprEval);

		System.out.println("    assign end: "+exprEval);
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "AssignmentNode", tabs);
		Utils.addIndentedStringLine(builder, id.toString(), tabs + 1);
		Utils.addIndentedStringLine(builder, "ASSIGN_OP =", tabs + 1);

		expressionNode.buildString(builder, tabs + 1);

		Utils.addIndentedStringLine(builder, "SEMICOLON ;", tabs + 1);
	}
}
