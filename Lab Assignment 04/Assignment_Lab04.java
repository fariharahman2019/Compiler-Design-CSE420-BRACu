import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileNotFoundException;

public class Assignment_Lab04 {
  public static void main(String[] args) {
    try{    
      Scanner input = new Scanner(new File("C:\\Users\\Fariha Rahman\\Desktop\\Lab Assignment 04\\input.txt"));
      
      String s = "([a-z]+?) (([a-z]+?)\\(.*?\\))";// ([a-z]+?) grp 1,(([a-z]+?)\\(.*?\\)) grp 2, ([a-z]+?) grp 3
      Pattern p = Pattern.compile(s);
      
      System.out.println("Methods:");
      
      while (input.hasNextLine()){
        String s2 = input.nextLine();
        //System.out.println(s2);
        Matcher m = p.matcher(s2);
        
        if (m.find() && !"main".equals(m.group(3))) {
          System.out.println(m.group(2) + ", " + "return type: " + m.group(1));
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}