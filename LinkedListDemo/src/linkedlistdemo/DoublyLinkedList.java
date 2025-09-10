
package linkedlistdemo;

import java.util.Queue;

public class DoublyLinkedList <D>
{
    class Node
    {
        D data;
        Node prev;
        Node next;
    }
    Node start = null;
    Node end  = null;
    
    public boolean isEmpty()
    {
        return (start == null);
    }
    
    public void insertAtStart(D value)
    {
        Node n = new Node();
        n.data = value;
        n.prev = null;
        if(isEmpty())
        {
            n.next = null;
            start = end = n;
        }
        else
        {
            n.next = start;
            start.prev = n;
            start = n;
        }
    }
    
    public void insertAtEnd(D value)
    {
        Node n = new Node();
        n.data = value;
        n.next = null;
        
        if(isEmpty())
        {
            n.prev = null;
            start = end = n;
        }
        else
        {
            n.prev = end;
            end.next = n;
            end = n;
        }
    }
    
    public D deleteAtStart()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return null;
        }
        else if(start == end)
        {
            D value = start.data;
            start = end = null;
            return value;
        }
        else
        {
            D value = start.data;
            start = start.next;
            start.prev = null;
            return value;
        }
    }
    
    public D deleteAtEnd()
    {
        if(isEmpty())
        {
            System.out.println("List is EMpty");
            return null;
        }
        else if(start == end)
        {
            D value = start.data;
            start = end = null;
            return value;
        }
        else
        {
            D value = end.data;
            end = end.prev;
            end.next = null;
            return value;
        }
    }
    
    public void traverse()
    {
        Node t = start;
        while(t != null)
        {
            System.out.print(t.data + " <->");
            t = t.next;
        }
        System.out.println(" null");
    }
    
    public boolean search(D key)
    {
        Node t = start;
        while(t != null)
        {
            if(t.data == key)
                return true;
            t = t.next;
        }
        return false;
    }
    
    public Node searchNode(D key)
    {
        Node t = start;
        while(t != null)
        {
            if(t.data == key)
                return t;
            t = t.next;
        }
        return null;
    }
}
class SlL<T>{
    class Node{
        T data ;
        Node next;

        public Node(T data)
        {
            this.data = data;
        }
        
    }
    Node start;
    public boolean isEmpty()
    {
        return start==null;
    }
     public void insertAtStart(T data)
    {
        Node newNode = new Node(data);
        if(isEmpty())
            start=newNode;
        else{
            newNode.next=start;
            start=newNode;
        }
    }
     public T deleteAtStart()
    {
        T value;
        if(isEmpty())
            return null;
        else if(start.next==null)
        {value =start.data;
        start=null;
        }
        else
        {
        value=start.data;
        start=start.next;    
        }
        return value;
    }
     
     public void treverse()
    {
        Node temp = start;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.print("NULL");
    }
    
}