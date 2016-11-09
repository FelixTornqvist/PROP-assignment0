package prop.assignment0.customCode.Nodes;

/**
 * Created by Annika Svedin and Felix Törnqvist.
 */

public class Utils {

	public static void tabIndenter(StringBuilder builder, int tabs) {
		for (int t = 0; t < tabs; t++ ) {
			builder.append('\t');
		}
	}

	public static void addIndentedStringLine(StringBuilder builder, String str, int tabs){
		tabIndenter(builder, tabs);
		builder.append(str);
		builder.append(System.getProperty("line.separator"));
	}
}
