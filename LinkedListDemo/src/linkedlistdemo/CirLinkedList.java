package linkedlistdemo;

public class CirLinkedList <D>
{
    class Node
    {
        D data;
        Node prev;
        Node next;
    }
    Node start = null;
    
    public boolean isEmpty()
    {
        return (start == null);
    }
    
    public void insertAtStart(D value)
    {
        Node n = new Node();
        n.data = value;
        if(isEmpty())
        {
            n.next = n;
            n.prev = n;
            start = n;
        }
        else
        {
            n.next = start;
            n.prev = start.prev;
            n.prev.next = n;
            start.prev = n;
            start = n;
        }
    }
    
    public void insertAtEnd(D value)
    {
        Node n = new Node();
        n.data = value;
        if(isEmpty())
        {
            n.next = n;
            n.prev = n;
            start = n;
        }
        else
        {
            n.next = start;
            n.prev = start.prev;
            n.prev.next = n;
            start.prev = n;
        }
    }
    
    public D deleteAtStart()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return null;
        }
        else if(start.next == start)
        {
            D value = start.data;
            start = null;
            return value;
        }
        else
        {
            D value = start.data;
            start.next.prev = start.prev;
            start.prev.next = start.next;
            start = start.next;
            return value;
        }
    }
    
    public D deleteAtEnd()
    {
        if(isEmpty())
        {
            System.out.println("List is Empty");
            return null;
        }
        else if(start.next == start)
        {
            D value = start.data;
            start = null;
            return value;
        }
        else
        {
            Node t = start.prev;
            D value = t.data;
            t.next.prev = t.prev;
            t.prev.next = t.next;
            return value;
        }
    }
    
    public void traverse()
    {
        if(isEmpty())
            return;
        Node t = start;
        do
        {
            System.out.print(t.data + " <->");
            t = t.next;
        }
        while(t != start);
    }
    
    public boolean search(D key)
    {
        if(isEmpty())
            return false;
        Node t = start;
        do
        {
            if(t.data == key)
                return true;
            t = t.next;
        }
        while(t != start);
        return false;
    }
    
    public Node searchNode(D key)
    {
        if(isEmpty())
            return null;
        Node t = start;
        do
        {
            if(t.data == key)
                return t;
            t = t.next;
        }
        while(t != start);
        return null;
    }
}

