
public class Formatting
{
	public static String format(String xml) {
		/* if the XML file is empty */
		if (xml == null || xml.trim().length() == 0) return "";

		int stack = 0;
		StringBuilder sb = new StringBuilder();

		/* Separate the XML into Rows */
		String[] rows = xml.trim().replaceAll(">", ">\n").replaceAll("<", "\n<").split("\n");

		for (int i = 0; i < rows.length; i++)
		{	
			/* if the row is empty */
			if (rows[i] == null || rows[i].trim().length() == 0) 
				continue;

			rows[i] = rows[i].trim();
			
			if (rows[i].startsWith("<?"))
			{
				sb.append(rows[i] + "\n");
			} 

			/* if it's an end-tag */
			else if (rows[i].startsWith("</"))
			{
				String indent = repeatString(--stack);
				sb.append(indent + rows[i] + "\n");
			} 

			/* if it's a start-tag */
			else if (rows[i].startsWith("<")) 
			{
				String indent = repeatString(stack++);
				sb.append(indent + rows[i] + "\n");
			} 

			/* if it's a content */
			else 
			{
				String indent = repeatString(stack);
				sb.append(indent + rows[i] + "\n");
			}
		}
		return sb.toString();
	}

	private static String repeatString(int stack)
	{
		StringBuilder indent = new StringBuilder();
		for (int i = 0; i < stack; i++)
		{
			indent.append("    ");
		}
		return indent.toString();
	} 

	public static void main(String[] args) {

		String s ="<users><user><name>Mohamed</name><id>180</id></user>"
				+ "<user><name>Ahmed</name><id>200</id></user></users>";

		System.out.println(Formatting.format(s));
	}
}

