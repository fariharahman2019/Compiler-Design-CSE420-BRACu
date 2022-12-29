import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Pattern;

public class Assignment_Lab03{
  
  public static void main(String[] args) throws FileNotFoundException {
    Assignment_Lab03 F = new Assignment_Lab03();
    F.Regex();
  }
  
  public void Regex() throws FileNotFoundException{
    Scanner input = new Scanner(new File("C:\\Users\\Fariha Rahman\\Desktop\\Lab Assignment 03\\input.txt"));
    int a = input.nextInt();
    input.nextLine();
    String stringArray[] = new String[a];
    for(int i=0; i<a; i++){
      stringArray[i] = input.nextLine().trim();
    }
    int b = input.nextInt();
    input.nextLine(); 
    for(int i=0; i<b; i++){
      boolean flag = false;
      String S1 = "";
      String S2 = input.nextLine().trim();
      for(int j=0; j<a; j++){
        if(Pattern.matches(stringArray[j],S2)){
          flag = true;
          S1 = S1+(j+1)+" ";
        }
      }
      if(flag==true){
        System.out.println("YES, "+S1);
      }  
      else{
        System.out.println("NO, "+0);
      }
    }
  }
}