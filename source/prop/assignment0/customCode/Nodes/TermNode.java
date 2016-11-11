/*
* Authors: Annika Svedin, Felix Törnqvist
* */

package prop.assignment0.customCode.Nodes;

import prop.assignment0.INode;
import prop.assignment0.Lexeme;
import prop.assignment0.Token;

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
		System.out.println("        term begin: "+((op != null)?op.token():"factor only"));

		Float result = new Float(0);

		Float factor = (Float) factorNode.evaluate(null);

		// only a factor with division would send an argument
		if(args != null) {
			Float parentFac = (Float) args[0];
			factor = parentFac / factor;
		}

		if (op != null && termNode != null) {
			if (op.token() == Token.MULT_OP){
				Float termEval = (Float) termNode.evaluate(null);
				result = factor * termEval;

			} else if (op.token() == Token.DIV_OP){
				Object[] childArgs = new Float[]{factor};
				result = (Float) termNode.evaluate(childArgs);
			}
		} else {
			result = factor;
		}


		System.out.println("        term end: "+result);
		return result;
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
