// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman

public class BTQueue<dataType>
{   
   BTQueueNode<dataType> head;
   BTQueueNode<dataType> tail;
      /**BTQueue object which creates a new BTQueue object*/
   public BTQueue ()
   {
      head = null;
      tail = null;
   }
   /**This method returns the next BinaryTreeNode object stored in the BTQueue*/
   public BinaryTreeNode<dataType> getNext ()
   {
      if (head == null)
         return null;
      BTQueueNode<dataType> qnode = head;
      head = head.next;
      if ( head == null )
         tail = null;
      return qnode.node;
   }
   /**This method adds the parameterized BinaryTreeNode object to the end of the BTQueue object*/
   public void enQueue ( BinaryTreeNode<dataType> node )
   {
      if (tail == null)
      {   
         tail = new BTQueueNode<dataType> (node, null);
         head = tail;
      }   
      else
      {
         tail.next = new BTQueueNode<dataType> (node, null);
         tail = tail.next;
      }   
   }   
}
