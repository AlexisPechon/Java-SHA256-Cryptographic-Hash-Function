/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sha256_encryption;

//Imports that are necessary for the functionality of the Cryptographic Hash Algorithm
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * SHA256_Encryption_App.java
 * 10/11/2021
 * @authors Alexis Pechon - x19358953, Stephen Costello - x19111371, Sean McDonnell - x19490822 and Eoghan Feighery - x19413886
 */
public class SHA256_Encryption_App {
    
    //** CREDITS **//
    //Hash Function Implementation and Debugging = Alexis Pechon(x19358953) and Stephen Costello(x19111371)
    //JOptionPane Implementation and Debugging = Eoghan Feighery(x19413886) and Sean McDonnell(x19490822)
    
    //**STATIC VARIABLES**//
    //The static variables can be used globally all throughout the project
    public static JPanel panel = new JPanel(); //Declaring and assigning a JPanel object and calling it panel, this is used to create a custom error window in JOptionPane
    public static String passwordToHash = ""; //Declaring and assigning a variable to hold the user's password
    public static boolean flag = false; //Declaring and assigning a variable to a boolean for error checking
    
    //The following static variables are necessary for the functionality of the SHA256 Encryption Algorithm
    public static MessageDigest messageDigest; //The MessageDigest variable is needed to provide the functionality of a message digest algorithm for the SHA-256
    public static BigInteger number; //The BigInt Variable number is used to contain a bigger integer value than the normal int variable could contain
    public static StringBuilder hexToString; //StringBuilder variable is needed to convert the hexadecimal format into a string for the user to read
    
     public static void main(String args[]){
        //Code inside of the main method will be executed first when the application is running
        try{

            JOptionPane.showMessageDialog(null, "Welcome to the SHA-256 Password Encryption!\n"); //Welcome message is printed to the user
            
            do{
                //The code under the do-while loop will keep on looping if the user 
                passwordToHash = JOptionPane.showInputDialog(null, "Please put in your password: "); //Asks the user for their password
                
                if(passwordToHash == null){
                    //If the user clicks on Cancel in the JOptionPane window, they will exit the application
                    JOptionPane.showMessageDialog(panel, "Terminating the application...","Alert!", JOptionPane.WARNING_MESSAGE); //Displays a message to notify the user that the application is closing
                    JOptionPane.showMessageDialog(null,"Thank you for using the SHA-256 Encryption Algorithm!"); //Displays a closing message when the user terminates the application
                    System.exit(0); //Exits out of the application
                }                
                else if(passwordToHash.isEmpty()){
                    flag = false; //Sets the flag to false which will loop the program again
                    JOptionPane.showMessageDialog(panel, "You cannot submit an empty field. Please try again...", "Error", JOptionPane.ERROR_MESSAGE); //Notifies the user they cannot leave an empty field
                }
                else{
                    flag = true; //Breaks free from the do-while loop if the user inputs a valid password
                    JOptionPane.showMessageDialog(null,"Password Hash = " + hexToStringConversion(getSHA(passwordToHash))); //Shows the user their hashed password   
                    JOptionPane.showMessageDialog(null,"Thank you for using the SHA-256 Encryption Algorithm!"); //Displays a closing message when the user finishes using the application
                }
                
            }while(flag == false); //If the flag is false, then the do-while loop will continue
            
        }catch(NoSuchAlgorithmException e){
            //If there is no cryptographic algorithm present in the application, the catch statement will print out an error message
            System.out.println(e);
        }      
    } //End of Main class
    
    //Static methods that are needed to run the class are found below:
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    { 
        // Static getInstance method is called with hashing SHA 
        messageDigest = MessageDigest.getInstance("SHA-256"); 
  
        // digest() method called 
        // to calculate message digest of an input 
        // and return array of byte
        return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8)); 
    } //end of public static byte
    
    public static String hexToStringConversion(byte[] hash)
    {
        
        // Converts the hash byte array into sign number representation 
        number = new BigInteger(1, hash); 
  
        // Convert message digest into hex value 
        hexToString = new StringBuilder(number.toString(16)); 
  
        return hexToString.toString(); //Converts the hex value back into a String
    } //end of public static String
} //End of class
