/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;

import java.util.ArrayList;

public class BlockNode implements INode {
	private StatementsNode child;

	public BlockNode(StatementsNode statementsNode) {
		this.child = statementsNode;

	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {

	}

}
