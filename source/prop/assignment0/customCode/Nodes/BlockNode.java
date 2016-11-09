/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;
import prop.assignment0.Token;

import java.util.ArrayList;

public class BlockNode implements INode {
	private StatementsNode child;
	private Lexeme right, left;

	public BlockNode(StatementsNode statementsNode) {
		this.child = statementsNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		builder.append("BlockNode");
		builder.append(System.getProperty("line.separator"));
		tabs ++;
		Utils.tabIndenter(builder, tabs);
		builder.append("LEFT_CURLY {");
		builder.append(System.getProperty("line.separator"));
		tabs ++;
		this.child.buildString(builder, tabs);

		builder.append("RIGHT_CURLY }");
	}



}
