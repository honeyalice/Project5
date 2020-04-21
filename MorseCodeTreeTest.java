package Project5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeTreeTest {
  
    MorseCodeTree tree = new MorseCodeTree();

    @Before
    public void setUp() throws Exception {
      
    }

    @After
    public void tearDown() throws Exception {
      
        tree = null;
    }

    @Test
    public void testInsert() {
      
        tree.insert(".....", "5");
        String letter = tree.fetch(".....");
          
        assertEquals("5", letter);
    }

    @Test
    public void testGetRoot() {
        String root;
        root = tree.getRoot().getData();
        assertEquals("", root);
      
    }

    @Test
    public void testSetRoot() {
              
        String newR;
        assertEquals("", tree.getRoot().getData());
        TreeNode<String> name = new TreeNode <String> ("Nabeel");
        tree.setRoot(name);
        newR = tree.getRoot().getData();
        assertEquals("Nabeel", newR);
   }

    @Test
    public void testFetch() {
      
        String letter;
        letter = tree.fetch(".-");
        assertEquals("a", letter);
        String letter2;
        letter2 = tree.fetch(".");
        assertEquals("e", letter2);

   }


    @Test
    public void testToArrayList() {
            
        ArrayList<String> list = new ArrayList<String>();
        list = tree.toArrayList();
      
        assertEquals("h", list.get(0));
        assertEquals("s", list.get(1));
        assertEquals("v", list.get(2));
        assertEquals("i", list.get(3));
        assertEquals("f", list.get(4));
        assertEquals("u", list.get(5));
        assertEquals("e", list.get(6));
        assertEquals("l", list.get(7));
        assertEquals("r", list.get(8));
        assertEquals("a", list.get(9));
        assertEquals("p", list.get(10));
        
        

   }
}


