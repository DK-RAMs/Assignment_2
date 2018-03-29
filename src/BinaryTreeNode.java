// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

/* This class is used to store and handle data in a BinaryTree. This class is very important when it comes to creating
   a BinaryTree object. Use of this class is more specific to an AVLTree, but it can be used in a BinaryTree and BinarySearchTree */
public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   
   /**This constructor creates a new BinaryTreeNode object with parameterised values as it's attributes*/ 
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = 0;
   }
   
   /**This method returns the BinaryTreeNode left attribute from this BinaryTreeNode object*/
   BinaryTreeNode<dataType> getLeft () { return left; } 
   
   
   /**This method returns the BinaryTreeNode right attribute from this BinaryTreeNode object*/
   BinaryTreeNode<dataType> getRight () { return right; }
   

}
