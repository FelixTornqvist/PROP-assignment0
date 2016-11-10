/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class BlockNode implements INode {
	private StatementsNode statementsChild;
	private Lexeme right, left;

	public BlockNode(StatementsNode statementsNode) {
		this.statementsChild = statementsNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "BlockNode", tabs);
		Utils.addIndentedStringLine(builder, "LEFT_CURLY {", tabs + 1);

		this.statementsChild.buildString(builder, tabs + 2);
		Utils.addIndentedStringLine(builder, "RIGHT_CURLY }", tabs + 1);
	}



}
