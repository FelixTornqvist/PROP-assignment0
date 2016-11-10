/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class AssignmentNode implements INode {

	private ExpressionNode expressionNode;
	private Lexeme id;

	public AssignmentNode(Lexeme id, ExpressionNode expressionNode) {
		this.id = id;
		this.expressionNode = expressionNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "AssignmentNode", tabs);
		Utils.addIndentedStringLine(builder, id.token() + " " + id.value(), tabs + 1);
		Utils.addIndentedStringLine(builder, "ASSIGN_OP =", tabs + 1);

		expressionNode.buildString(builder, tabs + 1);
	}
}
