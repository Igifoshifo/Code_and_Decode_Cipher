package ciphercodeanddecode;

import java.util.Scanner;
import java.io.*;

public class CipherCodeandDecode 
{

    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String choice = "";
        int k = 0;
        String cipher ="";
        String encoded = "";
        MyCipher P = new MyCipher();
        File file = new File("c:\\CSC191Files\\cipher.txt");
        if (file.exists()) 
        {
            System.out.println("File already exists");
            System.exit(0);
        }
        
        System.out.println("Hello!");

        do 
        {
            System.out.println("What would you like to do?");
            System.out.println("1. Enter a key.");
            System.out.println("2. Enter a password to encode");
            System.out.println("3. Write cipher to a file, then print");
            System.out.println("4. Quit");
            choice = in.next();

            switch (choice.charAt(0)) 
            {
                case '1':
                    System.out.println("Enter a key:");
                    k = in.nextInt();
                    P.setKey(k);
                    break;
                case '2':
                    System.out.println("Enter a password to encode:");
                    cipher = in.nextLine();
                    in.nextLine();
                    break;
                case '3':
                    try 
                    {
                        FileWriter fwriter = new FileWriter(file);
                        PrintWriter output = new PrintWriter(fwriter);
                        
                        String temp = P.encodeString(cipher);
                        output.print(temp);
                        
                        Scanner input = new Scanner(file);
                        
                        System.out.println("Your cipher:");
                        while(input.hasNext())
                        {
                            encoded = input.next();
                            System.out.println(""+encoded);
                        }
                        
                        input.close();
                    }
                    catch(Exception ex)
                    {
                        System.out.println("Ya dun goofed!");
                    }
                    break;
                case '4':
                    System.out.println("Take care");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (choice.charAt(0) != '4');
    }

}