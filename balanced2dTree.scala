/**
 * Balanced 2-D tree.
 * This is a Scala Program to implement a balanced 2-d tree by finding the median of the data for 
 * each recursive subdivision of those data.
 * <p>
 * @author Ahmed Alia <abualia4@najah.edu>
 */
 
 
class Node(var value:Array[Int]){
    
  var point:Array[Int]=new Array[Int](2)
 
  for(i<-0 to 1)
   point(i)=value(i)
   
  var left:Node=null
  var right:Node=null
 
}


 
 
import util.control.Breaks._

 class DBTree{
    var root:Node=null
    /**
     * This mehod for creating balanced 2-D tree using the
     * median strategy  .
     * @param points
     *               list of the 2d points
     * @param depth
     *               of the node
     */
    def buildKDTree( points: List[(Int,Int)], depth: Int ):Node  ={
         
        if(points.length==0 || points==null)
             return null
            
            
             
       println("depth"+depth)  
       var sortedPoints:List[(Int,Int)] =List()
          
        var cd = depth%2
        if(cd == 0){
             sortedPoints=points.sortBy(x=>(x._1))
            
        }
        else{
             sortedPoints=points.sortBy(x=>(x._2))
        }
        var node:Node=null
        var leftSubtree:  List[(Int,Int)]=List()
        var rightSubtree: List[(Int,Int)]=List() 
        if(points.length>0){
            var medianIndex:Int=(sortedPoints.length)/2
            var arr:Array[Int]=Array(sortedPoints(medianIndex)._1,sortedPoints(medianIndex)._2)
            node=new Node(arr)
           
            leftSubtree =sortedPoints.take(medianIndex)
            rightSubtree =sortedPoints.takeRight(sortedPoints.length-(medianIndex+1))
           
             println(node.value(0)+","+node.value(1)) 
             println(sortedPoints)
             println(leftSubtree)
             println(rightSubtree)
           
           if(medianIndex-1>=0 &&leftSubtree.length>0){
             node.left= buildKDTree(leftSubtree,depth+1) 
              
           }
           
           if(medianIndex-1<sortedPoints.length &&rightSubtree.length>0){
             node.right= buildKDTree(rightSubtree,depth+1) 
           } 
         } //end of if(points.length>0)
     
          
        
   return node
   
        
    } 
    
    
     /**
     * This mehod for printing the content of a binary tree,
     * (Root, left subtree and right subtree)
     */ 
    def printTree(node: Node, start:Int):Unit={
        if(node!=null) {
            if(node.value(0)==start)
               println("Root: "+node.value(0)+"," +node.value(1))
            else if(node.value(0)<start)
                           println("Left subtree: " +node.value(0)+"," +node.value(1))
                 else
                    println("Right subtree: " +node.value(0)+"," +node.value(1) )
                   
        printTree(node.left,start)
        printTree(node.right,start)
      }
    }
     
 }
 
 //Main part  
object test{
    def main(args:Array[String]){
        val points   = List((1, 7),(19,22),(4, 9), (12, 4),(5, 13),(7, 20),(14, 35),(15,39))  
        val dt:DBTree=new DBTree()
        
        val  bt= dt.buildKDTree(points,0) 
        println(bt.value(0))
         
        dt.printTree(bt, bt.value(0) )  
        
       
      
    }
    
}

test.main(Array("test"))
