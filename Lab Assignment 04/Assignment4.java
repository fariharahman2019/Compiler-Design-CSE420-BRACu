import java.io.File;
import java.net.URL;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;
public class Assignment4 {
public static void main(String[] args) {
      try {
            Scanner y=new Scanner(new File("input.txt"));
            System.out.println("Methods:");
            while (y.hasNextLine()) {
                Stack<String> a = new Stack<String>();
                String string1 = "";
                String string2 = y.nextLine();

                if (string2.contains(".") || string2.contains(("=")) || string2.contains("if")
                        || string2.contains("else") || string2.contains("for") || string2.contains("while")) {

                } else if (string2.contains("(") && string2.contains(")")) {
                    StringTokenizer token = new StringTokenizer(string2, " ()", true);
                    while (token.hasMoreTokens()) {
                        try {
                            a.push(token.nextToken());
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                } else {
                }

                while (!a.empty()) {
                    try {
                        String b = (String) a.pop();
                        if (b.equals("(")) {
                            string1 = b + string1;
                            while (a.peek().equals(" ")) {
                                a.pop();
                            }
                            string1 = (String) a.pop() + string1;
                            System.out.print(string1.trim() + ", ");
                            while (a.peek().equals(" ")) {
                                a.pop();
                            }
                            System.out.println("return type: " + (String) a.pop());
                            break;
                        } else {
                            string1 = b + string1;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}