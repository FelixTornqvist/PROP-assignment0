/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;

public class StatementsNode implements INode {
	private AssignmentNode assignmentNode;
	private StatementsNode statementsNode;

	public StatementsNode() {

	}

	public StatementsNode(AssignmentNode assignmentNode, StatementsNode statementsNode) {
		this.assignmentNode = assignmentNode;
		this.statementsNode = statementsNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.tabIndenter(builder, tabs);
		builder.append("StatementsNode");
		builder.append(System.getProperty("line.separator"));
		tabs++;

		if (assignmentNode != null && statementsNode != null) {
			assignmentNode.buildString(builder, tabs);
			statementsNode.buildString(builder, tabs);
		}



	}
}
