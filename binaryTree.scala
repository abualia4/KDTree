/**
 * Binary Tree Implementation.
 * This is a Scala Program to implement a Binary Tree. 
 * <p>
 * @author Ahmed Alia <abualia4@najah.edu>
 */
class Node(var value: Int){
    var valuex: Int=value
    var left: Node =null
    var right: Node=null
   
}


class BinaryTree{
    
    var  root: Node =null
   /**
     * This mehod for insering new node to a binary tree
     * @param node
     *               new node or the current binary tree
     * @param value
     *               of the new point
     */
    def addRecursive(current: Node, value: Int ): Node={
        
        if(current==null)
        return new Node(value)
        
        if(value< current.value)
        current.left=addRecursive(current.left,value)
        
        else if(value>current.value)
        current.right=addRecursive(current.right,value)
        
        
        return current
    }
    
     /**
     * This mehod for insering new a point to a binary tree
     * @param value
     *               is a new node
     */    
     def add(value: Int):Unit={
        root=addRecursive(root,value)
     }
    
     /**
     * This mehod for creatinga binary tree 
     */    
         def createBT(): BinaryTree={
       val bt: BinaryTree=new BinaryTree()
        
        bt.add(35)
        bt.add(5)
        bt.add(30) 
        bt.add(38)
        bt.add(13) 
        bt.add(90)
        bt.add(2)
        bt.add(9)
        
        return bt
    }
    /**
     * This mehod for searching of a point in a binary tree
     * @param node
     *               is a binary tree
     * @param value
     *               is a searched point
     */     
     def findNode(current: Node, value: Int):Boolean={
      if(current==null)
        return false
      
      if(value==current.value)
        return true
      
      else if(value<current.value)
        return findNode(current.left,value)
      
      else 
        return findNode(current.right,value)
      
    }
    
    
    /**
     * This mehod for printing the content of a binary tree
    */
    def printDFS(node: Node):Unit={
      if(node!=null) {
          println(node.value)
          printDFS(node.left)
          printDFS(node.right)
      }
    }
    
    /**
     * This mehod for sdeleting a point in a binary tree
     * @param node
     *               is a binary tree
     * @param value
     *               is a deleted point
     */
    def deleteRec(current: Node, value:Int):Node={
        if(current==null)
        return null
        
        if(value==current.value){
            if(current.left==null && current.right==null)
             return null
           
            else if(current.right==null)
            return current.left
           
            else if(current.left==null)
            return current.right
            
            else {
                var smallestValue:Int=findSmallest(current.right)
                current.value=smallestValue
                current.right=deleteRec(current.right,smallestValue)
                return current
            }
           
 
        }
         else 
             if(value<current.value){
                  current.left=deleteRec(current.left,value)
                  return current
         }
         
        else
           {
             current.right=deleteRec(current.right,value)
             return current  
            }
         
            
 
     } //end deleteRec
     
     /**
     * This mehod for finding  the smallest point in a binary tree
     * @param node
     *               is a binary tree
     
     */
    
    def findSmallest(root: Node):Int={
        if(root.left==null)
           return root.value
         else 
            return findSmallest(root.left)
    }
    
    /**
     * This mehod for determining a point that will be delete    
    
     * @param value
     *               is a deleted point
     */
    def delete(value:Int):Unit={
        root=deleteRec(root,value)
    }

}


 object test{
    def main(args:Array[String]){
        var bt=new BinaryTree()
         var bt1=bt.createBT()
         bt1.printDFS(bt1.root )
         bt1.delete(38)
         println("======================")
         bt1.printDFS(bt1.root )
         
        //print(bt.findNode(bt.root,201))
      
    }
}
test.main(Array("ok"))


