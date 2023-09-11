package pl.polsl.lotawiec.robert.controller;

import java.util.Arrays;
import java.util.List;
import pl.polsl.lotawiec.robert.view.Base64ViewConsole;
import pl.polsl.lotawiec.robert.view.Base64ViewGUI;
import pl.polsl.lotawiec.robert.model.IllegalCharacterException;
import pl.polsl.lotawiec.robert.model.Base64Model;
import pl.polsl.lotawiec.robert.annotations.ProgramDocumentation;

 
/**
 * Base64 Controller.
 *
 * @author Robert Lotawiec
 * @version 1.2
 */
public class Controller 
{
    /** A regex that the input string has to match to be encoded from ASCII to BASE64*/
    private static final String PATTERN_BASE64 = "^([A-Za-z0-9+_]{4})*([A-Za-z0-9+_]{3}=|[A-Za-z0-9+_]{2}==)?$";
    /** A regex that the input string has to match to be dencoded from BASE64 to ASCII*/
    private static final String PATTERN_ASCII = "^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*";
    
    /** Field for view of application. */
    private Base64ViewConsole view = new Base64ViewConsole();
    /** Field for model of application. */
    private Base64Model model = new Base64Model();
    /** String used as a keyword in data encryption and decryption for console parameters*/
    private String keyword;
    /** Message to operate on, given by user through console parameters*/
    private String inputText;
    /** An instance of Base64ViewGUI class*/
    Base64ViewGUI mainGUI = new Base64ViewGUI();
    
    
    /**
    * This method validate if in the command line has been passed arguments. 
    * If there are any arguments in the command line, 
    * then the number of given arguments and keyword (d or e) is checked.
    * @deprecated (since = "1.2", forRemoval = true)
    * @param args arguments from console
    * @throws pl.polsl.lotawiec.robert.model.IllegalCharacterException
    */
public void commandLineArgs(List<String> args) throws IllegalCharacterException{
        if(args.size()!=2)
        {
            throw new IllegalCharacterException("Wrong number of parameters, it should be 2 parameters");
        }
        else
        {       //There are two passed parameters and there are loaded below for its validation
                //load keyword
                keyword = args.get(0);
                if(!keyword.equals("e") && !keyword.equals("d"))
                {
                    throw new IllegalCharacterException("Wrong keyword parameter");
                }
                //load second parameter as a message
                inputText=args.get(1);
                
        }
    }

/**
 * This method is launched when the control of arguments in commandLineArgs method
 * has been succesfully passed. Here the second argument (the input string)
 * is passed to validateString method whether it contains 
 * only valid characters for encoding/decoding.
 * @deprecated (since = "1.2", forRemoval = true)
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
* @deprecated (since = "1.2", forRemoval = true)
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

/**
* Annotating a full annotation about program information
*/
@ProgramDocumentation(
        abbreviation="Base64", 
        fullName="Encoding and Decoding Program in Base64 cipher", 
        publishedYear=2021) 
public static void main(String ... args)
 {
    // Initialization of Base64ViewGUI window
    Base64ViewGUI.setView(null);
    
    //In the argument of the main method the String[] args array must remain, 
    //because of the the characteristics of providing arguments to the command line
    Controller controller =  new Controller();
    List<String> arguments = Arrays.asList(args);
    try
    {
        controller.commandLineArgs(arguments);
        controller.validateInfoFromCommandLine();
    }
    catch(IllegalCharacterException error)
    {
       controller.view.printErrorMessage(error);
       controller.getInfoFromInput(); 
    } 
 }
}

