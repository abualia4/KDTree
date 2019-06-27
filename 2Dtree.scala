/*
Scala Implementation of 2 Dimensional tree
==================================================================
-Insert
-Print
-Search
-Minimum Node

Version 0
27/6/2019

*/
//A structure of each node
class Node(var value:Array[Int]){
    
  var point:Array[Int]=new Array[Int](2)
 
  for(i<-0 to 1)
   point(i)=value(i)
   
  var left:Node=null
  var right:Node=null
 
}

class Dtree{
    var root:Node=null
    //Insert a new node
    def addRecursive(current: Node, value: Array[Int], depth: Int):Node={
        
        if(current==null)
        return new Node(value)
        
        // find  the current dimension/axes
        var cd=depth%2
        if(value(cd)<current.value(cd))
           current.left=addRecursive(current.left,value,depth+1) 
          
        else if(value(cd)>current.value(cd))
                current.right=addRecursive(current.right,value,depth+1) 

        return current  
    }
    
    //Add new node by user
    def add(value: Array[Int]):Unit={
        root=addRecursive(root,value,0)
     }
     
    
    //This added to create 2d tree easily
    def createDTree(): Dtree={
        var dt: Dtree=new Dtree()
        var a=Array(7,2)
        var b=Array(5,4)
        var c=Array(2,3)
        var d=Array(4,7)
        var e=Array(9,6)
        var f=Array(8,1)
        var g=Array(10,15)
        
        
        dt.add(a)
        dt.add(b)
        dt.add(c)
        dt.add(d)
        dt.add(e)
        dt.add(f)
        dt.add(g)
        
        return dt
    }
    
    //Print all nodes
    def printTree(node: Node):Unit={
      if(node!=null) {
           
        println(node.value(0)+"," +node.value(1)) 
        printTree(node.left)
        printTree(node.right)
      }
    }
      
    // if two Points are the same 
    def same(first: Array[Int], second:Array[Int]):Boolean={
        
        for(i<-0 to 1)
         if(first(i)!=second(i))
           return false
        
        return true
    }
    
    

   
    //Finding an point/node based on dimension/axis
    def findNode(current: Node, value: Array[Int], depth:Int):Boolean={
      
      if(current==null)
        return false
        
      // find  current plane (x or y)
       var cd=depth%2
       
      if(same(value,current.point))
          return true
      else
          if(value(cd)<current.value(cd))
              return findNode(current.left,value, depth+1)
              
    else
         
              return findNode(current.right,value, depth+1)
        

    }
    
    // for user to search for a node
    def search(value:Array[Int]):Boolean={
        return findNode(root,value,0)
    }
    
   
    //Find the smallest node among three points/nodes based on dimension, it will be used by smallestPointTree method.
    def minPoint3(a:Node, b:Node, c:Node, dim:Int):Node={
       
          var minNode:Node=a
         
         if(b!=null&&b.value(dim)<minNode.value(dim))
            minNode=b
         else 
            if(z!=null&&c.value(dim)<minNode.value(dim))
              minNode=c    
           
        return minNode
         
    } 
   
 
   //Find the smallest point in all tree based on dimension
   def smallestPointTree(current:Node, dim:Int, depth:Int) :Node={
        
        if(current.left==null)
          return current
        
       // find  current dimesnsion/axis (x or y)
       var cd=depth%2
       
      if(cd==dim){
           
        if(current.left==null)
             return current
            
         return smallestPointTree(current.left,dim,depth+1)
              
       } 
       else
        
        return minPoint3(current,smallestPointTree(current.left,dim,depth+1),smallestPointTree(current.right,dim,depth+1),dim)
       
       
        
    }   
   // This method for user to find the smallest node baed on dimension
   def smallestPoint(dim:Int):Unit={
       println("The smallest node based on dim "+dim+" is ("+smallestPointTree(root,dim,0).value(0)+","+smallestPointTree(root,dim,0).value(1)+")")
       
   }  
    
}

//Main part  
object test{
    def main(args:Array[String]){
        
       var node:Dtree=new Dtree()
       var dt=node.createDTree()
       
       println("The 2D tree as follows:")
       dt.printTree(dt.root)
       
       var point=Array(1,2)
       if(dt.search(point))
          println(point(0)+","+point(1)+" is  exist")
       else
          println(point(0)+","+point(1)+" is not exist")
         
       dt.smallestPoint(0) //x dimension
       dt.smallestPoint(1) //y dimension

         
               
   
     }
}
 test.main(Array("ok"))
