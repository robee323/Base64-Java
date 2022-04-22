package pl.polsl.lotawiec.robert.model.tests;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
/*import pl.polsl.bartosz.groffik.model.CipherData;
import pl.polsl.bartosz.groffik.model.IncorrectParameterFormatException;
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    /** an instance of CiperData class */
    Base64Test testInstance;
    
    /**
     * Sets up environment so that tests can be executed .
     */
    @BeforeEach
    public void setUp() {
        List<String> myList = Arrays.asList(new String[]{"random","message"});
        testModel = new CipherData("keyword", myList);
    }
    
    /**
     * Test checking whether data encoding is correct.
     */
    @Test
    void testEncoding(){
        testModel.matchKeywordLengthToText(testModel.getKeyword(),testModel.getInputText());
        testModel.encodeData(testModel.getGeneratedKeyword(), testModel.getInputText());
        assertEquals("belzcd powqwuv",testModel.getCipheredText(), "Message encoding is not correct!");
    }
    
    /**
     * Test checking whether data decoding works correctly.
     */
    @Test
    void testDecoding(){
        testModel.matchKeywordLengthToText(testModel.getKeyword(),testModel.getInputText());
        testModel.encodeData(testModel.getGeneratedKeyword(), testModel.getInputText());
        testModel.decodeData(testModel.getGeneratedKeyword(), testModel.getCipheredText());
        assertEquals(testModel.getDecipheredText(), testModel.getInputText());
    }
    
    /**
     * Tests if input data is given in a correct format
     * @throws IncorrectParameterFormatException custom exception handling incorrect string variable format.
     */
    @Test
    void testDataCorrectness() throws IncorrectParameterFormatException{
        testModel.validateData();
    }
    
    /**
     * Test checking for a single string validation
     */
    @Test
    void testStringValidation(){
        assertTrue(testModel.validateString(testModel.getInputText()));
    }
    
    /**
     * Parametrized test checking if for given pairs of variables a keyword of correct size will be generated.
     * @param keyword string used to encode/decode a message.
     * @param inputText string containing message to operate on.
     */
    @ParameterizedTest
    @CsvSource({"apple,bartosz", "orange,tested"})
    void testSizeOfGeneratedKeyword(String keyword, String inputText){
        List<String> testList = Arrays.asList(new String[]{});
        testList = new ArrayList<>();
        String[] testArray = inputText.split(" ");
        for(String test:testArray){
            testList.add(test);
        }
        CipherData testedModel = new CipherData(keyword, testList);
        String testString = inputText;
        testedModel.matchKeywordLengthToText(keyword, testString);
        String outputKeyword = testedModel.getGeneratedKeyword();
        assertEquals(outputKeyword.length(),testString.length(), "Size of generated keyowrd is not equal to its message!");
    }
    
}

