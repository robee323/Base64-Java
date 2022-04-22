package pl.polsl.lotawiec.robert.model;

/** 
 * Class for encoding a given string from ASCII into Base64,
 * for decoding a given string from Base64 into ASCII
 * and for validation of input strings for encoding and decoding.
 * 
 * @author Robert Lotawiec
 * @version 1.0
 */
public class Base64Model {
    /** Constant with characters used for encoding/decoding Base64 */
    private static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+_";
    
    /**
      * In base64 encoding, the character set is [A-Z, a-z, 0-9, and + /].
      * If the rest length is less than 4, the string is padded with '=' characters.
      * ^([A-Za-z0-9+/]{4})* means the string starts with 0 or more base64 groups.
      * ([A-Za-z0-9+/]{4}|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)$ 
      * means the string ends in one of three forms:
      * [A-Za-z0-9+/]{4}, [A-Za-z0-9+/]{3}= or [A-Za-z0-9+/]{2}==
      * 
      * When giving a string encoded in Base64, spaces are not allowed, 
      * because in this encoding whitespace characters are part of the encoded message, 
      * so the user must not give them to decode the message unchanged.
      * 
      * For ASCII text, the user can specify a string of characters 
      * consisting of multiple words separated by a space (at least one word), 
      * and there can (but doesn't have to) be any whitespace character at the end.
      * ^([ A-Za-z0-9+_]{1,})+[ \\t\\n\\x0B\\f\\r]*
      * 
      * @param str Input string
      * @param pattern A regex that the input string has to match 
      * @throws IllegalCharacterException
      */
    public void validateString(String str, String pattern) throws IllegalCharacterException{
      
      if (str.isEmpty()) 
      {
        throw new IllegalCharacterException("Given string is empty.");
      }
      else if(!str.matches(pattern))
      {
        throw new IllegalCharacterException("Given string contains illegal characters.");
      }
      
    }
    
    /**
     * Method transform a  string in ASCII encoding into Base64 encoding
     * 
     * @param s input string
     * @return a string in Base64 encoding
     */
    public String encode(String s) {

	// the result/encoded string, the padding string, and the pad count
	String r = "", p = "";
	int c = s.length() % 3;

	// add a right zero pad to make this string a multiple of 3 characters
	if (c > 0) {
	    for (; c < 3; c++) {
		p += "=";
		s += "\0";
	    }
	}

	// increment over the length of the string, three characters at a time
	for (c = 0; c < s.length(); c += 3) {

	    // these three 8-bit (ASCII) characters become one 24-bit number
	    int n = (s.charAt(c) << 16) + (s.charAt(c + 1) << 8)
		    + (s.charAt(c + 2));

	    // this 24-bit number gets separated into four 6-bit numbers
	    int n1 = (n >> 18) & 63, n2 = (n >> 12) & 63, n3 = (n >> 6) & 63, n4 = n & 63;

	    // those four 6-bit numbers are used as indices into the base64 character list 
            
	    r += "" + BASE_64_CHARS.charAt(n1) + BASE_64_CHARS.charAt(n2)
		    + BASE_64_CHARS.charAt(n3) + BASE_64_CHARS.charAt(n4);
	}

	return r.substring(0, r.length() - p.length()) + p;
    }
    
    /**
     * Method transform a string in Base64 encoding into ASCII encoding
     * 
     * @param s input string
     * @return a string in ACII encoding
     */
    public String decode(String s) {

	// remove/ignore any characters not in the base64 characters list or 
        //the pad character -- particularly newlines
        
	s = s.replaceAll("[^" + BASE_64_CHARS + "=]", "");

	// replace any incoming padding with a zero pad (the 'A' character is zero)
	String p = (s.charAt(s.length() - 1) == '=' ? 
		(s.charAt(s.length() - 2) == '=' ? "AA" : "A") : "");
	String r = "";
	s = s.substring(0, s.length() - p.length()) + p;

	// increment over the length of this encoded string, four characters at a time
	for (int c = 0; c < s.length(); c += 4) {

	    // each of these four characters represents a 6-bit index in the
	    // base64 characters list which, when concatenated, will give the
	    // 24-bit number for the original 3 characters
            
	    int n = (BASE_64_CHARS.indexOf(s.charAt(c)) << 18) //18-23
		    + (BASE_64_CHARS.indexOf(s.charAt(c + 1)) << 12) //12-17
		    + (BASE_64_CHARS.indexOf(s.charAt(c + 2)) << 6) //6-11
		    + BASE_64_CHARS.indexOf(s.charAt(c + 3)); //0-5

	    // split the 24-bit number into the original three 8-bit (ASCII) characters
           
	    r += "" + (char) ((n >>> 16) & 0xFF) + (char) ((n >>> 8) & 0xFF)
		    + (char) (n & 0xFF);
	}

	// remove any zero pad that was added to make this a multiple of 24 bits
	return r.substring(0, r.length() - p.length());
    }
}
