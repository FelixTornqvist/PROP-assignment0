/**
 * Authors Annika Svedin & Felix Törnqvist.
 */

package prop.assignment0.customCode;

import prop.assignment0.Lexeme;
import prop.assignment0.Token;

import java.util.HashMap;

public class Evaluator {

	private HashMap<Object, Float> identifiers;

	public Evaluator() {
		this.identifiers = new HashMap<>();
	}

	public void addIdentifier(Lexeme identifier) {
		identifiers.put(identifier.value(), null);
	}




}
