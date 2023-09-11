package pl.polsl.lotawiec.robert.model.tests;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pl.polsl.lotawiec.robert.model.Base64Model;

import pl.polsl.lotawiec.robert.model.IllegalCharacterException;

/**
 * Test class validating correct operation of methods used during program's operation. 
 * @author Robert Lotawiec
 * @version 1.1
 */
public class Base64Test {
    
    /**
    * Default constructor
    */
    Base64Test(){};
    
    /**
    * An instance of Base64Model class
    */
    Base64Model testInstance;
    
    /**
    * Sets up environment so that tests can be executed .
    */
    @BeforeEach
    public void setUp() {
        testInstance = new Base64Model();
    }
    
    /**
    * This test checks whether data encoding works correctly.
    */
    @Test
    void testEncoding(){
        String beforeEncoding = "Samsung";
        String afterEncoding = "U2Ftc3VuZw==";

        String encodedString = testInstance.encode(beforeEncoding);
        assertEquals(afterEncoding, encodedString);
    }
    
    /**
    * This test checks whether data decoding works correctly.
    */
    @Test
    void testDecoding(){
        String beforeDecoding = "Tm9raWE=";
        String afterDecoding = "Nokia";

        String decodedString = testInstance.decode(beforeDecoding);
        assertEquals(afterDecoding, decodedString);
    }
    
    /**
    * This test checks a single string validation
    */
    @Test
    void testStringValidationCorrectString(){
     try {
            testInstance.validateString("Samsung", "[A-Za-z0-9+/]*");
        } 
        catch (IllegalCharacterException e) {
            fail(e.getMessage());
        }   
           
    }
    
    /**
    * Exception test that validates a string with invalid characters for decoding
    * exception should be thrown
    * 
    */
    @Test
    void testStringValidationInvalidString(){
        try {
            testInstance.validateString("Tm9raWE= U2Ftc3VuZw==", "^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*");
            fail("Should be exception.");
        } 
        catch (IllegalCharacterException e) {
            assertTrue(e.getMessage() != null);
        }
    }
    
    /**
    * Parametrized Test that encrypts and then decrypts strings which contain white spaces
    * 
    * @param input string used for testing
    */
    @ParameterizedTest
    @ValueSource(strings = {"L o r e m    i p s u m   dolor sit amet consectetur         adipiscing       elit"})
    void testStringValidationWithWhitespace(String input){
      
        String encodedOutput = testInstance.encode(input);
        String decodedOutput = testInstance.decode(encodedOutput);
        assertEquals(input,decodedOutput);
    }
    
    /**
    * Parametrized test that encrypts and then decrypts different strings
    * 
    * @param input string used for testing
    * @param result string used for testing
    */
    @ParameterizedTest
    @CsvSource(value = {"Samsung:true", "Java:true", "515-140-185:false", "123456789:true"}, delimiter = ':')
    void testEncryptWithValidation(String input, String result){
        
        try {
            testInstance.validateString(input, "[A-Za-z0-9+/]*");
            
        } catch (IllegalCharacterException e) {
            if (!result.equals("false")) {
                fail(e.getMessage());
            }
        }
        String output = testInstance.decode(testInstance.encode(input));
        assertEquals(input, output);
    }
    
}

