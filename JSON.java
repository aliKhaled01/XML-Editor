import java.util.ArrayList;
import java.util.Stack;

public class JSON {
    public static void main(String... args) {
        String xml = "<book>\n" +
                "    <title>Some title</title>\n" +
                "    <description>some description </description>\n" +
                "    <author>\n" +
                "        <id>1</id>\n" +
                "        <name>some author name</name>\n" +
                "    </author>\n" +
                "    <review>nice book</review>\n" +
                "    <review>this book sucks</review>\n" +
                "    <review>amazing work</review>\n" +
                "</book>";


        System.out.println(XMLToJSON(xml));
    }

    public static String XMLToJSON(String xml) {
        ArrayList<Node> arr = XMLToArr(xml);
        Node node = arrToTree(arr);
        StringBuilder sb = new StringBuilder();
        treeToJSON(node, 0, sb);
        return "{\n" + sb + "\n}";
    }

    private static String repeat(String st, int count){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append(st);
        }
        return sb.toString();
    }
    private static void treeToJSON(Node node, int tabCount, StringBuilder ans) {
        tabCount++;

        ans.append(repeat("    ", tabCount));
        if (node.type == NodeType.DATA) {
            ans.append("\"" + node.data + "\"");
            return;
        }


        if (node.type == NodeType.DATAELEMENT) {
            ans.append("\"" + node.data + "\": \"" + node.children.get(0).data + "\"");
            return;
        }

        if (node.data != "") ans.append("\"" + node.data + "\": ");

        if (node.type == NodeType.REPEATEDTAG)
            ans.append("[\n");
        else
            ans.append("{\n");

        for (int i = 0; i < node.children.size(); i++) {
            treeToJSON(node.children.get(i), tabCount, ans);

            if (i < node.children.size() - 1)
                ans.append(", \n");
            else {
                ans.append('\n');
                ans.append(repeat("    ", tabCount));

                if (node.type == NodeType.REPEATEDTAG)
                    ans.append("]");
                else
                    ans.append("}");
            }
        }
    }

    private static Node arrToTree(ArrayList<Node> arr) {
        Stack<Node> stack = new Stack<>();
        for (Node curr : arr) {
            if (curr.type == NodeType.CLOSINGTAG) {
                Node temp = new Node(NodeType.ELEMENT, curr.data);
                Node top = stack.pop();
                while (top.type != NodeType.OPENINGTAG) {
                    temp.children.add(top);
                    top = stack.pop();
                }
                top = stack.isEmpty() ? null : stack.peek();
                if (!stack.isEmpty() && top.data.equals(curr.data)) {
                    top.type = NodeType.REPEATEDTAG;
                    if (temp.children.size() == 1)
                        top.children.add(temp.children.get(0));
                    else {
                        temp.data = "";
                        if (top.notFirst)
                            top.children.add(temp);
                        else {
                            Node ele = new Node(NodeType.ELEMENT, "");
                            ele.children = top.children;
                            top.children = new ArrayList<>();
                            top.children.add(ele);
                            top.children.add(temp);
                            top.notFirst = true;
                        }
                    }

                } else if (temp.children.size() == 1 && temp.children.get(0).type == NodeType.DATA) {
                    temp.type = NodeType.DATAELEMENT;
                    stack.push(temp);
                } else
                    stack.push(temp);

            } else {
                stack.push(curr);
            }

        }
        return stack.pop();
    }

    private static ArrayList<Node> XMLToArr(String xml) {
        ArrayList<Node> arr = new ArrayList<>();
        for (int i = 0; i < xml.length(); i++) {
            if (xml.charAt(i) == ' ' || xml.charAt(i) == '\n')
                continue;
            StringBuilder sb = new StringBuilder();
            if (xml.charAt(i) == '<') {
                i++;
                boolean ct = false;
                if (xml.charAt(i) == '/') {
                    ct = true;
                    i++;
                }
                while (xml.charAt(i) != '>')
                    sb.append(xml.charAt(i++));
                Node n = new Node(ct ? NodeType.CLOSINGTAG : NodeType.OPENINGTAG, sb.toString().trim());
                arr.add(n);
            } else {
                while (xml.charAt(i) != '<')
                    sb.append(xml.charAt(i++));
                Node n = new Node(NodeType.DATA, sb.toString().trim());
                arr.add(n);
                i--;
            }
        }
        return arr;
    }

    private enum NodeType {OPENINGTAG, CLOSINGTAG, DATA, ELEMENT, REPEATEDTAG, DATAELEMENT}

    private static class Node {
        private NodeType type;
        private String data;
        private ArrayList<Node> children;
        private boolean notFirst = false;

        public Node(NodeType t, String d) {
            type = t;
            data = d;
            children = new ArrayList<>();
        }
    }

}
