import java.util.Scanner;

/**
 *  Caesar Cipher EncryptionMachine.java
 * @author Alex
 *
 */
public class EncryptionMachine {
	
	
	// Class Constants
	private static String KEY = "";
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private static int SHIFT = 3;
	
    /**
     *  #1 The method encryptChar() is used to encrypt a single letter passed to it
     *  @param single character
     *  @return encrypted character
     */
    public static char encryptChar(char c) {
    	
		int newIndex = c - 'a';
		newIndex = (newIndex + SHIFT) % 26;
		char ch = (char)(newIndex + 'a');
		
    	return ch;
    	
    }
	
	/**
	 * #2 The method encrypt() is used to encrypt multiple words, 
	 * text is cleaned and transformed to lower case,
	 * if a space is detected it's written as a space,
	 * if input is non ALPHABET defined character an error is produced.
	 * @param raw input text
	 * @return encrypted text
	 */
    public static StringBuffer encrypt(String text)
    {
        StringBuffer result= new StringBuffer();
        text = text.toLowerCase();    

        for (int i=0; i<text.length(); i++)
        {
        	char c = text.charAt(i);
        	if (ALPHABET.indexOf(c)!=-1) {									
        		result.append(encryptChar(c));
        	} else {
            	
            	if (Character.isWhitespace(c)) {
            		
            		result.append(" ");
            		
            	} else  {
            		if (ALPHABET.indexOf(c)==-1) {
    	    			System.err.println("Invalid input detected, only 'abcdefghijklmnopqrstuvwxyz' characters allowed.\nExiting program");
    	    			System.exit(1);
            		}
        		}
        	}
        }
        
        return result;
    }
    
    /**    
     * The method getInput() will get any kind of user input
     * @param message to display
     * @return input
     */
    private static String getInput(String message) {
    	
    	
		Scanner myInput = new Scanner(System.in);
    	System.out.println(message);
    	
    	return myInput.nextLine();
    	
    	
    }
    /**
     * The method getKey() requests user's key and returns the encrypted key.
     */
    private static void getKey() {
		KEY = getInput("Enter Key: ");
    	
    	System.out.println("Encrypted KEY: " + encrypt(KEY));
    }
    

    /**
     * The method textToEncrypt() requests the text from the user and returns the encrypted text
     */
    public void textToEncrypt() {
    	
        String text = getInput("Enter Text To Encrypt: ");
      
        System.out.println("Encrypted Text: " + encrypt(text));
    }
    
    public EncryptionMachine() {
    	getKey();
    }
    
    /**
     *  Main
     */
    public static void main(String[] args)
    {
    	EncryptionMachine en = new EncryptionMachine();
    	en.textToEncrypt();

    }

}
