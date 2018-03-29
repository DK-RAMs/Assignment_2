// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman


/* This class is used to create a Binary Tree which can be used for different data structure algorithms
   in many ways
*/
public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**This constructor creates a new BinaryTree object and sets the parameterised root node attribute to
      null
   */
   public BinaryTree ()
   {
      root = null;
   }
   /**This method returns the height of the current BinaryTree object by using and overloaded getHeight method
      and setting it's BinaryTreeNode parameter to the current BinaryTree's root attribute*/
      
   public int getHeight ()
   {
      return getHeight (root);
   }
   
   /**This method returns the height of the BinaryTree object by comparing the height of the left
        subtree and the right subree*/
        
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   
   /**This method returns the size of the BinaryTree Object */
   public int getSize ()
   {
      return getSize (root);
   }  
   /**This method recursively traverses the BinaryTree object and returns the size of the BinaryTree object. This method is an overloaded version of the getSize() method*/
    
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   
   /**This method visits the data that is found in a parameterised node
   */
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println (node.data);
   }
   
   /**This method traverses the BinaryTree by first visiting the root node before visiting the the rest of the BinaryTree object's
      nodes. It does this by recursively calling an overloaded version of this method.
   */
   public void preOrder ()
   {
      preOrder (root);
   }
   /**This method is an overloaded version of the preOrder() method.
      This method recursively traverses the BinaryTree by first visiting the root node before visiting the rest of the BinaryTree object's nodes.*/
       
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   
   /**This method recursively traverses the BinaryTree object's nodes by visiting the parent node after visiting it's child nodes. It uses an
      overloaded version of this method*/
      
   public void postOrder ()
   {
      postOrder (root);
   }
   
   /**This method is an overloaded version of the postOrder() method.
      This method recursively traverses the BinaryTree by first visiting the root node after visiting the rest of the BinaryTree object's nodes.*/

   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }
   /**This method recursively traverses the binary tree after the left child node but before the right child node. It uses an overloaded
      version of this method to do the task*/
   
   public void inOrder ()
   {
      inOrder (root);
   }
   /**This method is an overloaded version of the inOrder() method.
      This method recursively traverses the binary tree after the left child node but before the right child node.*/
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }
   
   /**This method uses recursion to traverse the binary tree one level at a time, from left child node to right child node.*/
   
   public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }
}
