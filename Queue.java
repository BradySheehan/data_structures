/**
*    Program written by Brady Sheehan 
*/

import java.util.Vector;
public class Queue{ 
     private Vector<Object> queue; 
     private int queuePtr; //used to keep track of where to add/remove
     private int size;
     private String name;
     public Queue(){
          queue = new Vector<Object>();
          queuePtr = 0;
     }
     
     public Queue(int s, String n){
          queue = new Vector<Object>(s);
          queuePtr = 0;
          size = s;
          name = n;
     }
     
     public void enqueue(Object person){
//add item to end of queue
          queue.insertElementAt(person, 0);
          queuePtr++;
          if(queue.size() > size)
               System.out.println("ERROR: too many people on " + name + ".");
     }

     public int size(){
          return queue.size();
     }

     public boolean frontIs(Object person){
          if(person.equals(queue.lastElement()))
               return true;
          return false;
     }

     public boolean full(){
          if(queue.size() < size)
               return true;
          return false;
     }

     public boolean empty(){
          if(queue.isEmpty())
               return true;
          return false;
     }
     
     public Object dequeue(){
          //removes element at index = queuePtr
          if(!queue.isEmpty()){
               return queue.get(queuePtr--);
          }
          System.out.println("You tried removing from an empty queue");
          return 0;
     } 
}