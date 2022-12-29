import java.util.*;
import java.io.*;
import java.util.regex.*;

public class lab2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int weberror=0, emailerror=0, linenum =1; 
        System.out.println("How many lines");
        int line = sc.nextInt();
        
        String str[] = new String[line];
        
        for (int i = 0 ; i < line ; i++){
            System.out.println("Web or Email:");
            str[i] = sc.next();
        } 
        
        for (int i = 0 ; i < line ; i++){
            if(str[i].startsWith("www.") && str[i].endsWith(".com")){
                String[] check = str[i].split("\\." );
                char[] c = check[1].toCharArray();
                
                for(int j = 0 ; j < c.length ; j++){
                    int a = (int) c[j];
                    if((a>=65 && a <=90) || (a>=97 && a<=122) || (a>=48 && a<=57)){    
                    }
                    
                    else{
                        weberror++;
                    }
                }
                if(weberror == 0){
                    System.out.println("Web," + linenum++ );
                }
            }//lowercase banaisi thn alphabetic kina dekhsi r check korsi @ ase kina thn seshe .com acche kina
            else if(Character.isLowerCase(str[i].charAt(0))&& Character.isAlphabetic(str[i].charAt(0)) && str[i].contains("@") && str[i].endsWith(".com")){
                String[] check = str[i].split("\\@" );
                char[] c = check[0].toCharArray();
                for(int j = 0 ; j < c.length ; j++){
                    int a = (int) c[j];
                    if(a==45|| a==46|| a==95||(a>=65 && a <=90) || (a>=97 && a<=122) || (a>=48 && a<=57)){
                    }
                    else{
                        emailerror++;
                    }           
                }
                if(emailerror == 0){
                    System.out.println("Email," + linenum++ );
                }
                
            }
        }
    }
}