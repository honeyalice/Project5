package Project5;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english 
 * @author Bingying Jiang
 */

import java.util.ArrayList;


public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
    private String result;
    private TreeNode<String> root; 
      
    /**
    * calls the buildTree method
    */
    public MorseCodeTree(){
    	setRoot(new TreeNode<String>(""));
        buildTree(); 
    }
    
    /**
     * Returns a reference to the root
     * @return reference to root
     */
     @Override
     public TreeNode<String> getRoot()
     {
         return this.root;
     }
     

     /**
      * sets the root of the MorseCodeTree
      * @param newNode a copy of newNode will be the new root
      */
     @Override
     public void setRoot(TreeNode<String> newNode) {
        
         root = newNode;  
     }
     
     /**
      * This is a recursive method that adds element to the correct position in the tree based on the code. A '.' (dot) means traverse to the left. A "-" (dash) means traverse to the right. The code ".-" would be stored as the right child of the left child of the root Algorithm for the recursive method:
	  *1. if there is only one character
      *a. if the character is '.' (dot) store to the left of the current root
      *b. if the character is "-" (dash) store to the right of the current root
      *c. return
      *2. if there is more than one character
      *a. if the first character is "." (dot) new root becomes the left child
      *b. if the first character is "-" (dash) new root becomes the right child
      *c. new code becomes all the remaining charcters in the code (beyond the first character)
      *d. call addNode(new root, new code, letter)
      *@param root the root of the tree for this particular recursive instance of addNode
      *@param code the code for this particular recursive instance of addNode
      *@param  the data of the new TreeNode to be added
      */
     @Override
     public void addNode(TreeNode<String> root, String code, String letter)
     {  
       if(code.length() == 1){
           if (code.equals(".")){
               root.left = new TreeNode<String>(letter);
           }
           else{
               root.right = new TreeNode<String>(letter);
           }
          
           return;
        }
        else{  
           if(code.substring(0, 1).equals(".")){
               addNode(root.left, code.substring(1), letter);
           }
           else{
               addNode(root.right, code.substring(1), letter);      
           }      
       }          
   }
   
    /**
    * Adds element to the correct position in the tree based on the code 
    * This method will call the recursive method addNode
    * @param code the code for the new node to be added, example ".-."
    * @param letter the letter for the corresponding code, example "r"
    * @return the MorseCodeTree with the new node added
    */
    @Override
    public MorseCodeTree insert(String code, String letter){
        addNode(root, code, letter);
        return this;      
    }

    /**
     * Fetch the data in the tree based on the code 
     * This method will call the recursive method fetchNode
     * @param code the code that describes the traversals to retrieve the string (letter)
     * @return the string (letter) that corresponds to the code
     */
    @Override
    public String fetch(String code){
        String letter = fetchNode(root, code);
        return letter;
    }

    /**
    * This is the recursive method that fetches the data of the TreeNode that corresponds with the code
    * A '.' (dot) means traverse to the lc. A "-" (dash) means traverse to the right.
    * The code ".-" would fetch the data of the TreeNode stored as the right child of the left child of the root
    *
    * @param root the root of the tree for this particular recursive instance of addNode
    * @param code the code for this particular recursive instance of fetchNode
    * @return the string (letter) corresponding to the code
    */
    @Override
    public String fetchNode(TreeNode<String> root, String code){  
        if(code.length() == 1){
           if (code.equals(".")){
               result = root.left.getData();
           }
           else{
               result = root.right.getData();
           }
       }
        else{             
        	if(code.substring(0, 1).equals(".")){
               fetchNode(root.left, code.substring(1));
           }else{
               fetchNode(root.right, code.substring(1));      
           }      
       }
        return result;  
   }
   
   /**
    * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code. 
    * The root will have a value of "" (empty string) level one: insert(".", "e"); insert("-", "t"); level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m"); etc. 
    */
   @Override
   public void buildTree(){
       root = new TreeNode<String>("");
      
       insert(".", "e");
       insert("-", "t");
      
       insert("..", "i");
       insert(".-", "a");
       insert("-.", "n");
       insert("--", "m");
      
       insert("...", "s");
       insert("..-", "u");
       insert(".-.", "r");
       insert(".--", "w");
       insert("-..", "d");
       insert("-.-", "k");
       insert("--.", "g");
       insert("---", "o");

       insert("....", "h");
       insert("...-", "v");
       insert("..-.", "f");
       insert(".-..", "l");
       insert(".--.", "p");
       insert(".---", "j");
       insert("-...", "b");
       insert("-..-", "x");
       insert("-.-.", "c");
       insert("-.--", "y");
       insert("--..", "z");
       insert("--.-", "q");                  
   }
  
    /**
    * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order. 
    * Used for testing to make sure tree is built correctly
    *
    * @return an ArrayList of the items in the linked Tree
    */
    @Override
    public ArrayList<String> toArrayList()
    {
        ArrayList<String> result = new ArrayList<String>();
        LNRoutputTraversal(root, result);      
        return result;
    }

  
    /**
    * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
    *
    * @param root the root of the tree for this particular recursive instance
    * @param list the ArrayList that will hold the contents of the tree in LNR order
    */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
    {
        if(root != null){
            LNRoutputTraversal(root.left, list);
            list.add(root.getData());
            LNRoutputTraversal(root.right, list);
       }
   }
    /**
     * @return null
     */
    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        return null;
    }

    /**
     * @return null
     */
    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
       return null;
    }

}
