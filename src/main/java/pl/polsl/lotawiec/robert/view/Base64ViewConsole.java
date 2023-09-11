
package pl.polsl.lotawiec.robert.view;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;

import java.util.Scanner;


/**
 * View for the Base64 encoding
 * Contains methods used for input and output.
 * 
 * @author Robert Lotawiec
 * @version 1.2
 */
public class Base64ViewConsole {

    private boolean decryptMode = false;

    /**
    * Ask user if want to decrypt or encrypt
    * Defaults to encrypt.
    * @deprecated (since = "1.2", forRemoval = true)
    * @return true for decryption and false for encryption.
    */
    public boolean checkIfDecryptMode() {
        Base64ViewConsole view=new Base64ViewConsole();
        boolean validated=false;
        while(!validated)
        {
            view.showMessage("Decrypt or encrypt mode? [d/e]: ");
            Scanner scanner = new Scanner(System.in);
            String mode = scanner.next();
            try
            {
               view.modeValidation(mode);
            }
            catch (IllegalCharacterException error)
            {
                view.printErrorMessage(error);
                continue;
            }
            this.decryptMode = "d".equals(mode);
            validated=true;
        }
      
        return decryptMode;
        
    }
    
    
    /**
    * This method check if chosen by the user mode exists 
    * if such mode exists the program can proceed to the next step
    * 
    *@param s string with mode given by the user
    *@throws pl.polsl.lotawiec.robert.model.IllegalCharacterException
    */
    public void modeValidation(String s) throws IllegalCharacterException
    {
        if(("e".matches(s))||("d".matches(s)))
        {
           
        }
        else throw new IllegalCharacterException("Invalid mode selected, please try again \n");
    
    }
    
    
    /**
    * Prints given message to console
    * @deprecated (since = "1.2", forRemoval = true)
    * @param message to print to the console
    */
    public void showMessage(String message){
        System.out.println(message);
    }
    
    /**
    * Retrieves the text entered by the user
    * @deprecated (since = "1.2", forRemoval = true)
    * @return string entered by user
    */
    public String getText(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: \n");
        return scanner.nextLine();
    }
    
    /**
     * Method user to print out a message with resulting decoded message.
     * @deprecated (since = "1.2", forRemoval = true)
     * @param message resulting decoded message.
     */
    public void printDecodedData(String message){
        System.out.println("Decrypted message: " + message);
    }
    
    /**
     * Method user to print out a message with resulting encoded message.
     * @deprecated (since = "1.2", forRemoval = true)
     * @param message resulting encoded message.
     */
    public void printEncodedData(String message){
        System.out.println("Encrypted message: " + message);
    }
    
    /**
    * Prints default message of exception.
    * @deprecated (since = "1.2", forRemoval = true)
    * @param exception which value will be printed.
    */
    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    } 
    
}
