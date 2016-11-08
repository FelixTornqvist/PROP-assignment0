/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;

import java.util.ArrayList;

public class BlockNode implements INode {
	ArrayList<StatementsNode> children = new ArrayList<>();

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {

	}

	public void addStatement(StatementsNode node){
		children.add(node);
	}
}
