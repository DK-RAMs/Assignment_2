// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman

/**This class is an altered version of Professor Hussein Suleman's Binary Search Tree class. This class
   creates a new Binary Search Tree that can be used to store data items and includes methods that aid
   with interacting with the data structure */

public class BinarySearchTree<dataType extends Comparable<dataType>> extends BinaryTree<dataType>
{

   public int SearchopCount = 0;
   public int InsertopCount = 0;
   
   /**This method inserts dataType d into a BinarySearchTree object. Creates a root node if 
      the BinarySearchTree is empty. This method uses an overloaded insert method.*/
   public void insert ( dataType d )
   {
      if (root == null){
         InsertopCount++;
         root = new BinaryTreeNode<dataType> (d, null, null);
      }
      else{
         InsertopCount = 0;
         insert (d, root);
      }
   }
   
   
   /**This method recursively traverses through the BinarySearchTree to find and insert dataType
      d into BST in the right place */
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (d.compareTo (node.data) <= 0)
      {
         InsertopCount++;
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         InsertopCount++;
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   
      
   
   /**This method searches the BinarySearchTree for parameterised dataType d and returns null if it
      isn't found. Does this by calling an overloaded version of this method */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         SearchopCount = 0;
         return find (d, root);
   }
      
   /**Recursively traverses the BinaryTree to find and return the node holding parameterised
      dataType d */
      
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      if(d.compareTo (node.data) == 0){
         SearchopCount++;
         return node;
      }
      if (d.compareTo (node.data) < 0){
         SearchopCount++;
         return (node.left == null) ? null : find (d, node.left);
      }
      else{
         SearchopCount++;
         return (node.right == null) ? null : find (d, node.right);
      }
   }
   
   
   /**This method removes the parameterised dataType d from the BinarySearchTree. Does this by
      using an overloaded delete method */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }   
   
     
   /**Recursively traverses the BinarySearchTree to find and remove the node holding parameterised
      dataType d and rearranges the BST so that it can still remain functional*/ 
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   
      
   /**This method recursively traverses down the BinarySearchTree to find the minimum value stored in the
      BinarySearchTree object and removes the node containing the minimum value*/
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   
   /**This method recursively traverses down the BinartSearchTree to find the minimum value stored in the AVLTree 
      and returns the node containing the minimum value*/
      
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
      
}