
public class Minifying 
{
	public static String minify(String xml) {
		/* if the XML file is empty */
		if (xml == null || xml.trim().length() == 0) return "";
		
		StringBuilder sb = new StringBuilder();

		/* Separate the XML into Rows */
		String[] rows = xml.trim().replaceAll(">", ">\n").replaceAll("<", "\n<").split("\n");

		for (int i = 0; i < rows.length; i++)
		{	
			/* if the row is empty */
			if (rows[i] == null || rows[i].trim().length() == 0) 
				continue;

			rows[i] = rows[i].trim();
			
			sb.append(rows[i]);
		}
		return sb.toString();
	}


	public static void main(String[] args) {

		String s = "<users>\r\n"
				+ "    <user>\r\n"
				+ "        <id>1</id>\r\n"
				+ "        <name>Ahmed Ali</name>\r\n"
				+ "        <posts>\r\n"
				+ "            <post>\r\n"
				+ "                <body>\r\n"
				+ "                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\n"
				+ "                </body>\r\n"
				+ "                <topics>\r\n"
				+ "                    <topic>\r\n"
				+ "                        economy\r\n"
				+ "                    </topic>\r\n"
				+ "                    <topic>\r\n"
				+ "                        finance\r\n"
				+ "                    </topic>\r\n"
				+ "                </topics>\r\n"
				+ "            </post>\r\n"
				+ "            <post>\r\n"
				+ "                <body>\r\n"
				+ "                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\n"
				+ "                </body>\r\n"
				+ "                <topics>\r\n"
				+ "                    <topic>\r\n"
				+ "                        solar_energy\r\n"
				+ "                    </topic>\r\n"
				+ "                </topics>\r\n"
				+ "            </post>\r\n"
				+ "        </posts>\r\n"
				+ "        <followers>\r\n"
				+ "            <follower>\r\n"
				+ "                <id>2</id>\r\n"
				+ "            </follower>\r\n"
				+ "            <follower>\r\n"
				+ "                <id>3</id>\r\n"
				+ "            </follower>\r\n"
				+ "        </followers>\r\n"
				+ "    </user>\r\n"
				+ "    <user>\r\n"
				+ "        <id>2</id>\r\n"
				+ "        <name>Yasser Ahmed</name>\r\n"
				+ "        <posts>\r\n"
				+ "            <post>\r\n"
				+ "                <body>\r\n"
				+ "                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\n"
				+ "                </body>\r\n"
				+ "                <topics>\r\n"
				+ "                    <topic>\r\n"
				+ "                        education\r\n"
				+ "                    </topic>\r\n"
				+ "                </topics>\r\n"
				+ "            </post>\r\n"
				+ "        </posts>\r\n"
				+ "        <followers>\r\n"
				+ "            <follower>\r\n"
				+ "                <id>1</id>\r\n"
				+ "            </follower>\r\n"
				+ "        </followers>\r\n"
				+ "    </user>\r\n"
				+ "    <user>\r\n"
				+ "        <id>3</id>\r\n"
				+ "        <name>Mohamed Sherif</name>\r\n"
				+ "        <posts>\r\n"
				+ "            <post>\r\n"
				+ "                <body>\r\n"
				+ "                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\n"
				+ "                </body>\r\n"
				+ "                <topics>\r\n"
				+ "                    <topic>\r\n"
				+ "                        sports\r\n"
				+ "                    </topic>\r\n"
				+ "                </topics>\r\n"
				+ "            </post>\r\n"
				+ "        </posts>\r\n"
				+ "        <followers>\r\n"
				+ "            <follower>\r\n"
				+ "                <id>1</id>\r\n"
				+ "            </follower>\r\n"
				+ "        </followers>\r\n"
				+ "    </user>\r\n"
				+ "</users>";

		System.out.println(Minifying.minify(s));
	}
}
