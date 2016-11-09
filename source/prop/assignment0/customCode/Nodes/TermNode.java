/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;

public class TermNode implements INode {

	private FactorNode factorNode;
	private Lexeme op;
	private TermNode termNode;

	public TermNode(FactorNode factorNode) {
		this.factorNode = factorNode;
	}


	public TermNode(FactorNode factorNode, Lexeme op, TermNode termNode) {
		this.factorNode = factorNode;
		this.op = op;
		this.termNode = termNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "TermNode", tabs);

		if (factorNode != null) {
			factorNode.buildString(builder, tabs + 1);

			if (op != null && termNode != null) {
				Utils.addIndentedStringLine(builder, op.toString(), tabs + 1);
				termNode.buildString(builder, tabs + 1);
			}
		}

	}
}
