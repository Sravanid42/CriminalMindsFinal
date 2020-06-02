package Util;

/**
 * Write a description of class ConsoleIO here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.io.*;
import java.util.Scanner;

public class ConsoleIO  
{ 
    public static void ScanPassword()  
    { 
        String str; 
        //Scanner sc = new Scanner(System.in);
        
        Console console = System.console(); 
        if(console == null)  
        { 
            System.out.println("No console available"); 
            return; 
        } 
     
        str = console.readLine("Enter your name: "); 
        console.printf("Here is your name: %s\n", str); 
  
        
        System.out.println("Enter the password: "); 
        char[] ch=console.readPassword(); 
  
       
        String pass = String.valueOf(ch); 
        System.out.println("Password is: " + pass); 
    } 
    
    static public String readString(String prompt)
    {
        String s;
        Scanner sc = new Scanner(System.in); 

        // Character input 
        System.out.println(prompt);

        s = sc.nextLine();

        return s;
    }
    
    static public int readInt(String prompt)
    {
        int n;
        Scanner sc = new Scanner(System.in); 

        // Character input 
        System.out.println(prompt);

        n = sc.nextInt(); 

        return n;
    }
     
    static public void println(String prompt)
    {
        Scanner sc = new Scanner(System.in); 

        // Character input 
        System.out.println(prompt);
    }}

