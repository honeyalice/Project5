package Project5;
	
/**
 * Convert morse code to English.
 * @author Bingying Jiang
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter
{
	
	private static MorseCodeTree converter = new MorseCodeTree();
	
	/**
     * returns a string with all the data in the tree in LNR order with an space in 
     * between them. Uses the toArrayList method in MorseCodeTree It should return the 
     * data in this order:"h s v i f u e l r a p w j b d x n c k y t z g q m o"
     * @return the data in the tree in LNR order separated by a space.
     */
    public static String printTree()
    {
    	String tree = "";
        ArrayList<String> letters = converter.toArrayList();
        for(int i = 0; i < letters.size(); i++)
        {
           tree += letters.get(i);
           if(i + 1 < letters.size())
        	   tree += " ";
        }
      
        return tree;
    }
      
   
    /**
     * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). 
     * Each word is delimited by a ‘/’.
     * @param code the morse code
     * @return the English translation
     */
    public static String convertToEnglish(String code)
    {
        String output = "";
        String[] chars; 
        String[] word = code.split(" / ");
        for(int i = 0; i < word.length; i++){  
    	    chars = word[i].split(" ");
            for(int j = 0; j < chars.length; j++){      
                output += converter.fetch(chars[j]);  
            }
            output += " ";
        }  
        output = output.trim();
        return output;
    }
    /**
     * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
     * @param codeFile name of the File that contains Morse Code
     * @return the English translation of the file
     * @throws java.io.FileNotFoundException
     */
    public static String convertToEnglish(File codeFile) 
    		throws java.io.FileNotFoundException{
        ArrayList<String> arr = new ArrayList<String>();
    	String output = "";
        String[] morse; 
        String[] chars; 
       
        Scanner input = new Scanner(codeFile);;
        while (input.hasNext()){  
            arr.add(input.nextLine());
        }
        input.close();
       
        for(int i = 0; i < arr.size(); i++){
            morse = arr.get(i).split(" / ");
           
            for(int j = 0; j < morse.length; j++){
                chars = morse[j].split(" ");
               for(int k = 0; k < chars.length; k++){
                    output += converter.fetch(chars[k]);  
                }
               
                output += " ";
            }
        }
        output = output.trim();
       
        return output;
    }
     }

    	