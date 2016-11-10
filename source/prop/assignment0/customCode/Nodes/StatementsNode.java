/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.customCode.VariableContainer;
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
		System.out.println("statement begin");

		if(assignmentNode != null && statementsNode != null) {
			assignmentNode.evaluate(null);
			statementsNode.evaluate(null);
		}

		System.out.println("statement end");
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "StatementsNode", tabs);

		if (assignmentNode != null && statementsNode != null) {
			assignmentNode.buildString(builder, tabs + 1);
			statementsNode.buildString(builder, tabs + 1);
		}



	}
}
