/**
 * Authors: Annika Svedin & Felix Törnqvist
 * */

package prop.assignment0.Nodes;

import prop.assignment0.INode;
import prop.assignment0.VariableContainer;
import java.util.Map;

public class BlockNode implements INode {
	private StatementsNode statementsChild;

	public BlockNode(StatementsNode statementsNode) {
		this.statementsChild = statementsNode;
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		String ret = "";
		statementsChild.evaluate(null);

		for (Map.Entry var : VariableContainer.getKeySet()) {
			ret += var.getKey() + " = " + roundOneDecimal((Float) var.getValue()) + '\n';
		}
		return ret;
	}

	private float roundOneDecimal(float val){
		return Math.round(val * 10f) / 10f;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		Utils.addIndentedStringLine(builder, "BlockNode", tabs);
		Utils.addIndentedStringLine(builder, "LEFT_CURLY {", tabs + 1);

		this.statementsChild.buildString(builder, tabs + 1);
		Utils.addIndentedStringLine(builder, "RIGHT_CURLY }", tabs + 1);
	}
}
