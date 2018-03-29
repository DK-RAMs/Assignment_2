// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueueNode<dataType>
{
   BinaryTreeNode<dataType> node;
   BTQueueNode<dataType> next;
   /**Constructor which makes a BTQueueNode Object*/
   public BTQueueNode ( BinaryTreeNode<dataType> n, BTQueueNode<dataType> nxt )
   {
      node = n;
      next = nxt;
   }
}
