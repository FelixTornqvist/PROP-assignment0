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
		Utils.tabIndenter(builder, tabs);
		builder.append("AssignmentNode");
		builder.append(System.getProperty("line.separator"));


//		ident
//		ASSIGN_OP =
		tabs++;


		expressionNode.buildString(builder, tabs);
	}
}
