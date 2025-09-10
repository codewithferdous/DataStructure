package linkedlistdemo;

public class Stack <T>
{
    T[] arr = (T[]) new Object[5];
    int top = -1;
    
    public boolean isFull()
    {
        return (top >= arr.length-1);
    }
    
    public boolean isEmpty()
    {
        return (top <= -1);
    }
    
    public void push(T value)
    {
        if(isFull())
            System.out.println("Stack Overflow");
        else
            arr[++top] = value;
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else
            return arr[top--];
    }
    
    public T peek()
    {
        if(isEmpty())
            return null;
        else
            return arr[top];
    }
    
    public int size()
    {
        return top+1;
    }
    
    public void print()
    {
        for(int i = top; i>=0; i--)
        {
            System.out.println("|\t"+arr[i]+"\t|");
            System.out.println("----------------");
        }
    }
}
