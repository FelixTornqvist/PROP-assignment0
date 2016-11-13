/**
 * Authors: Annika Svedin & Felix Törnqvist
 * */

package prop.assignment0;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VariableContainer {
	private static HashMap<String, Float> variables = new HashMap<>();

	public static Float getValue(String varName) {
		Float value = variables.get(varName);

		if (value == null) {
			value = new Float(0);
			variables.put(varName, value);
		}
		return value;
	}

	public static void setValue(String varName, Float value) {
		variables.put(varName, value);
	}

	public static Set<Map.Entry<String, Float>> getKeySet() {
		return variables.entrySet();
	}
}
