import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Assignment_Lab02 {
  
  public static void main(String[] args) throws FileNotFoundException {
    
    try {
    Scanner sc = new Scanner(new File("C:\\Users\\Fariha Rahman\\Desktop\\Lab Assignment 02\\input.txt"));
    int lineNum=sc.nextInt();
    sc.nextLine();
    int LineNumber=1;

      while(sc.hasNext()&& LineNumber<=lineNum){
        String s = sc.nextLine().trim();
        
        if(web(s)&& email(s)){
          System.out.print("Web and Email Address: "+LineNumber);
        }
        else if(web(s)){
          System.out.print("Web Address: "+LineNumber);
        }
        else if(email(s)){
          System.out.print("Email Address : "+LineNumber);
        }
        else if(web(s)==false && email(s)==false){
          System.out.print("Invalid Address : "+LineNumber);
        }
        LineNumber++;
        System.out.println();
      }    
    } catch(Exception e){
      System.out.println("Input file not found \n ****Specify the correct file directory for the input file**** \n ****source code and input file ar in the same directory****");
    }
  }
  
  public static boolean web(String s){
    boolean website=false;
    int x=0;
    int state=0;
    
    while(x < s.length()){
      switch(state){
        
        case 0: if(s.charAt(x) == 'w') {
          state=1;          
        } else{
          state=0;
        }
        x++;
        break;
        
        case 1: if(s.charAt(x)=='w') {
          state=2;
        } else{
          state=0;
        }
        x++;
        break;
        
        case 2: if(s.charAt(x)=='w') {
          state=3;  
        } else{
          state=0;
        } 
        x++; 
        break; 
        
        case 3: if(s.charAt(x)=='.' ) {
          state=4;  
        }else{
          state=0;
        }  
        x++;
        break;
        
        case 4: if(((int)s.charAt(x)>64 && (int)s.charAt(x)<91) || ((int)s.charAt(x)>96 && (int)s.charAt(x)<123)){
          state=5;
        } else{
          state=0;
        }  
        x++;
        break;   
        
        case 5: if(((int)s.charAt(x)>64 && (int)s.charAt(x)<91) || ((int)s.charAt(x)>96 && (int)s.charAt(x)<123) || ((int)s.charAt(x)>47 && (int)s.charAt(x)<58) ) {
          state=5;  
        }
        else if(s.charAt(x)=='.'){
          state=6;
        }
        else{
          state=0;
        }
        x++;
        break;
        
        case 6: if(s.charAt(x)=='c') {
          state=7; 
        } else{
          state=0;
        }    
        x++;  
        break;
        
        case 7: if(s.charAt(x)=='o') {
          state=8;  
        } else{
          state=0;
        }     
        x++;
        break;
        
        case 8: if(s.charAt(x)=='m') {  
          website=true;
          state=0;
        } else{
          state=0;
        }   
        x++;
        break;
      }
    }
    return website;
  }
  
  public static boolean email(String s){
    boolean email=false;
    int x=0;
    int state=0;
    
    while(x<s.length()){
      switch(state){
        
        case 0: if(((int)s.charAt(x)>64 && (int)s.charAt(x)<91) || ((int)s.charAt(x)>96 && (int)s.charAt(x)<123)  ) {
          state=1;
        } else{
          state=0;
        } 
        x++; 
        break;
        
        case 1: if(((int)s.charAt(x)>64 && (int)s.charAt(x)<91) || ((int)s.charAt(x)>96 && (int)s.charAt(x)<123) || ((int)s.charAt(x)>47 && (int)s.charAt(x)<58) ) {
          state=1;
        }
        else if(s.charAt(x)=='@'){
          state=2;
        }
        else{
          state=0;
        } 
        x++;
        break;
        
        case 2: if(((int)s.charAt(x)>64 && (int)s.charAt(x)<91) || ((int)s.charAt(x)>96 && (int)s.charAt(x)<123)  ) {
          state=2;
        }
        else if(s.charAt(x)=='.'){
          state=3;
        }
        else{
          state=0;
        } 
        x++;  
        break; 
        
        case 3:if(s.charAt(x)=='c') {
          state=4;
        } else{
          state=0;
        }  
        x++;  
        break; 
        
        case 4:if(s.charAt(x)=='o') {
          state=5;
        } else{
          state=0;
        }
        x++; 
        break; 
        
        case 5:if(s.charAt(x)=='m'){
          email=true;
          state=0;
        } else{
          state=0;
        }  
        x++;  
        break;        
      }
    }    
    return email;
  }
}