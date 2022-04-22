package pl.polsl.lotawiec.robert.controller;

import pl.polsl.lotawiec.robert.view.Base64View;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;
import pl.polsl.lotawiec.robert.model.Base64Model;

 
/**
 * Base64 Controller.
 *
 * @author Robert Lotawiec
 * @version 1.0
 */
public class Controller 
{
    /** A regex that the input string has to match to be encoded from ASCII to BASE64*/
    private static final String PATTERN_BASE64 = "^([A-Za-z0-9+_]{4})*([A-Za-z0-9+_]{3}=|[A-Za-z0-9+_]{2}==)?$";
    /** A regex that the input string has to match to be dencoded from BASE64 to ASCII*/
    private static final String PATTERN_ASCII = "^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*";
    
    /** Field for view of application. */
    private Base64View view = new Base64View();
    /** Field for model of application. */
    private Base64Model model = new Base64Model();
    /** String used as a keyword in data encryption and decryption for console parameters*/
    private String keyword;
    /** Message to operate on, given by user through console parameters*/
    private String inputText;   
    
    /**
    * This method validate if in the command line has been passed arguments. 
    * If there are any arguments in the command line, 
    * then the number of given arguments and keyword (d or e) is checked.
    * 
    * @param args arguments from console
    * @throws pl.polsl.lotawiec.robert.model.IllegalCharacterException
    */
public void commandLineArgs(String[] args) throws IllegalCharacterException{
        if(args.length==0)
        {
            throw new IllegalCharacterException("No command line arguments has been passed");
        }
        else if(args.length == 2)
        {       //check if there are any passed parameters
                //load keyword
                keyword = args[0];
                if(!keyword.equals("e") && !keyword.equals("d"))
                {
                    throw new IllegalCharacterException("Wrong keyword parameter");
                }
                //load all other parameters as a message
                inputText=args[1];
                
        }
        else
        { 
            throw new IllegalCharacterException("Wrong number of parameters");
        }
    }

/**
 * This method is launched when the control of arguments in commandLineArgs method
 * has been succesfully passed. Here the second argument (the input string)
 * is passed to validateString method whether it contains 
 * only valid characters for encoding/decoding.
 * 
 * @throws IllegalCharacterException 
 */
private void validateInfoFromCommandLine() throws IllegalCharacterException {
    if(keyword.equals("d"))
        {
            //decrypt mode
            view.showMessage("Decrypt Mode selected \n");
            model.validateString(inputText, PATTERN_BASE64);
            view.printDecodedData(model.decode(inputText));

        }
        else
        {
            //encrypt mode
            view.showMessage("Encrypt Mode selected \n");
            model.validateString(inputText, PATTERN_ASCII);
            view.printEncodedData(model.encode(inputText));

        }
}

/**
* Method for getting input after getting invalid parameters in command line.
* After receiving the input string, it is passed to validateString method 
* whether it contains only valid characters for encoding/decoding.
* This method works until it finally receives an input that meets the requirements.
*
*/
private void getInfoFromInput(){
    boolean isValidated = false;
    String text;
    
    while(!isValidated)
    { 
        
        if(view.checkIfDecryptMode())
        {   
            //decrypt mode
            view.showMessage("Decrypt Mode selected \n");
            text = view.getText();
            try 
            {
                model.validateString(text, PATTERN_BASE64);
            } 
            catch (IllegalCharacterException error) 
            {
                view.printErrorMessage(error);
                continue;
            }
                       
            view.printDecodedData(model.decode(text));
                       
        }
        else
        {
            //encrypt mode
            view.showMessage("Encrypt Mode selected \n");
            text = view.getText();
            
            try 
            {
                model.validateString(text, PATTERN_ASCII);
            } 
            catch (IllegalCharacterException error) 
            {
                view.printErrorMessage(error);
                continue;
            }
            
            view.printEncodedData(model.encode(text));
           
        }
        isValidated = true;
    }   
}

/**
* Main method of program, which construct controller 
* and controls the processing of the arguments
*
* @param args table of strings with two arguments: 
* keyword for encryption/decryption mode (d or e) and string to encode/decode
*/
public static void main(String[] args)
 {
    Controller controller =  new Controller();

    try
    {
        controller.commandLineArgs(args);
        controller.validateInfoFromCommandLine();
    }
    catch(IllegalCharacterException error)
    {
       controller.view.printErrorMessage(error);
       controller.getInfoFromInput(); 
    } 
 }
}

