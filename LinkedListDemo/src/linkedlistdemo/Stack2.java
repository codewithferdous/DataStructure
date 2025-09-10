package linkedlistdemo;

public class Stack2<T>
{
    class Node
    {
        T data;
        Node next;
    }
    Node top = null;
    int size = 0;
    
    public boolean isEmpty()
    {
        return (top == null);
    }
    
    public void push(T value)
    {
        Node n = new Node();
        n.data  = value;
        n.next = top;
        top = n;
        size++;
    }
    
    public T pop()
    {
        if(isEmpty())
            return null;
        else
        {
            T value = top.data;
            top = top.next;
            size--;
            return value;
        }
    }
    
    public T peek()
    {
        if(isEmpty())
            return null;
        else  
            return top.data;
    }
    
    public int size()
    {
        return size;
    }
    
}
