/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlistmid;

/**
 *
 * @author XPS
 */
public class LinkedListMid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyList<Integer> s = new DoublyList<>();
         System.out.println(s.isEmpty());
      s.insertAtStart(10);
        s.insertAtStart(20);
        
        s.insertAtStart(30);
        
        s.insertAtEnd(10);
           
        s.insertAtEnd(90);
           
         //  s.deleteAtStart(); 
     s.treverse();
//        System.out.println(s.isEmpty());
    }
    
}
class DoublyList<T>{
    Node start=null;
    Node end=null;
    class Node{
        T data;
        Node next;
        Node prev;
    }
    public boolean isEmpty() {
        return start==null;
    }
    public void insertAtStart(T value) {
        Node n = new Node();
        n.data=value;
        n.prev=null;
        if(isEmpty()){
            start=end=n;
        }
        else{
            n.next=start;
            start.prev=n;
            start=n;
        }
    }
public void insertAtEnd(T value) {
        Node n = new Node();
        n.data=value;
        n.next=null;
        if(isEmpty()){
            start=end=n;
        }
        else{
            n.prev=end;
            end.next=n;
            end=n;
        }
    }
    public void treverse()
    {
        if(isEmpty())
        {
            System.out.println("LinkedList is Empty");
        }
        else{
            Node temp=start; 
            if(temp.next!=null){
                System.out.print(temp.data +"=>  ");
                temp=temp.next;
            }
            System.out.print("null");
        }
    }
    
    public T deleteAtStart() {
        if(isEmpty()){
            System.out.println("linkedlist is empty");
            return null;
        }
        else if(start==end){
            T value=start.data;
            start=end=null;
            return value;
        }
        else{
            T value=start.data;
            start=start.next;
            start.prev=null;
            return value;
        }
    }
     public T deleteAtEnd() {
        if(isEmpty()){
            System.out.println("linkedlist is empty");
            return null;
        }
        else if(start==end){
            T value=start.data;
            start=end=null;
            return value;
        }
        else{
            T value=end.data;
            end=end.prev;
            end.next=null;
            return value;
        }
    }
     

}
class SinglyLinkedList<T>{
    Node start=null;
    class Node{
        T data;
        Node next;
    }
    
    public boolean isEmpty() {
        return start==null;
    }
    public void insertAtStart(T value) {
        Node n = new Node();
        n.data=value;
        n.next=start;
        start=n;
    }
    public void insertAtEnd(T value) {
         Node n = new Node();
         n.next=null;
         n.data=value;
         if(isEmpty()){
             start=n;
         }
         else{
             Node temp=start;
             while(temp.next!=null){
                 temp=temp.next;
             }
             temp.next=n;
         }
    }
    public T deleteAtStart() {
       T value=start.data;
       start=start.next;
       return value;
        
    }
    public T deleteAtEnd() {
        if(isEmpty()){
            return null;
        }
        Node temp=start;
        Node temp2=null;
        while(temp.next!=null){
            temp2=temp;
            temp=temp.next;
        }
        temp2.next=null;
        return temp.data;
    }
    public boolean search(T key) {
         Node temp=start;
             while(temp!=null){
                 if(temp.data==key){
                     return true;
                 }
                 temp=temp.next;
             }
             return false;
    }
  public void treverse()
    {
       if(isEmpty()){
           System.out.println("LInkedList is Empty");
       }
       else{
           Node temp =start;
           while(temp!=null){
               System.out.print(temp.data+" -> ");
               temp=temp.next;
           }
           System.out.print("NULL");
           System.out.println("");
       }
    }
}
class CircularList<T>{
    Node start=null;
    class Node{
        T data;
        Node next=null;
        Node prev=null;
    }
    public boolean isEmpty() {
        return start==null;
    }
     public void insertAtStart(T value) {
         Node n = new Node();
         n.data=value;
         if(isEmpty()){
             start=n;
             start.next=n;
             start.prev=n;
         }
         else{
             n.next=start;
             n.prev=start.prev;
             start.prev.next=n;
             start.prev=n;
             start=n;
         }
    }
     public void insertAtEnd(T value) {
         Node n = new Node();
         n.data=value;
         if(isEmpty()){
             start=n;
             start.next=n;
             start.prev=n;
         }
         else{
             n.next=start;
             n.prev=start.prev;
             start.prev.next=n;
             start.prev=n;
          
         }
    }
     public T dleteAtStart() {
        if(isEmpty()){
            System.out.println("linkedlist is empty");
            return null;
        }
        else if(start.prev==start.next){
            T value=start.data;
            start.prev=start.next=null;
            start=null;
            return  value;
        }
        else{
            T value=start.data;
            start.prev.next=start.next;
            start.next.prev=start.prev;
            start=start.next;
            return value;
        }
    }
     public T dleteAtEnd() {
        if(isEmpty()){
            System.out.println("linkedlist is empty");
            return null;
        }
        else if(start.prev==start.next){
            T value=start.data;
            start.prev=start.next=null;
            start=null;
            return  value;
        }
        else{
            T value=start.prev.data;
            start.prev.prev.next=start;
            start.prev=start.prev.prev;
            return value;
        }
    }
     
     
    
    
}