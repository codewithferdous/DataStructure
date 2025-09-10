/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testqueue;

/**
 *
 * @author WALEED TRADERS
 */
public class TestQueue
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
   
    }

}

class Queue<T>
{

    T[] arr = (T[]) new Object();
    int head = 0;
    int tail = -1;
    public int size()
    {
        return (tail-head);
    }
    
    public boolean isEmpty()
    {
        return (tail <= -1);
    }

    public boolean isFull()
    {
        return (tail >= arr.length - 1);
    }

    public void enqueue(T num)
    {
        if (isFull())
        {
            System.out.println("Queue is full");
            return;
        }
        arr[++tail] = num;
    }

    public T front()
    {
        return arr[head];
    }

    public T dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        return arr[head++];
    }

    public void print()
    {
        for (int i = head; i <= tail; i++)
        {
            System.out.print(arr[i] + "  ");
        }
    }

}

class CircularQueue
{

    int[] arr = new int[5];
    int head = 0;
    int tail = 0;
    public boolean isEmpty()
    {
        return (tail == head);
    }

    public boolean isFull()
    {
        return ((tail - head) == arr.length);
    }

    public void enqueueAtTail(int num)
    {
        if (isFull())
        {
            System.out.println("Queue is full");
            return;
        }

        arr[tail++ % arr.length] = num;
        
    }
    public void enqueueAtHead(int value)
    {
        if(isFull())
            return ;
        arr[--head%arr.length]=value;
    }
    
    public int front()
    {
        return arr[head % arr.length];
    }

    public int dequeueAtHead()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return -9999;
        }

        return arr[head++ % arr.length];

    }
    public int dequeueAtTail()
    {
       return arr[tail--%arr.length] ;
    }
    
    public void print()
    {
        for (int i = head % arr.length; i <= i + (tail - head) % arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
    }

}

class PriorityQueue<T>
{

    Queue q1 = new Queue();
    Queue q2 = new Queue();
     Queue q3 = new Queue();
    Queue q4 = new Queue();
    Queue q5 = new Queue();
    public void enqueue(T data, int priorty)
    {
    if(!q1.isFull()&& (priorty++)==0){
        q1.enqueue(data);
    }
    else if((priorty++)==1&&!q2.isFull()){
        q2.enqueue(data);
    }
    else if((priorty++)==2&&!q3.isFull())
    {
        q3.enqueue(data);
    }
    
    else if((priorty++)==3&&!q4.isFull())
    {
        q4.enqueue(data);
    }
    else{
        q5.enqueue(data);
    }
    }
    public T dequeue()
    {
        if (!q1.isEmpty())
        {
           return(T) q1.dequeue();
        } 
        else
        {
          return(T)  q2.dequeue();
        }
    }
    public T method()
    {
       if (!q1.isEmpty())
        {
           return(T) q1.front();
        } 
        else
        {
          return(T)  q2.front();
        }  
    }
    public int size()
    {
        return q1.size()+q2.size();
    }
    
}
class NotShrinkQueue<T>{
    T[] arr = (T[])new Object[5];
    int head =0;
    int tail=-1;
        public boolean isEmpty()
    {
        return tail==-1;
    }
        public boolean isFull()
    {
        return tail>=arr.length-1;
    }
        public void enqueueAtTail(T value)
    {
        if(isFull())
            return ;
        arr[++tail]=value;
    }
        public T dequeueAtHead()
    {
        if(isEmpty())
            return null;
        T value =arr[head];
        moveForward();
        return value;
    }
     public void enqueueAtHead(T value)
    {
        if(isFull())
            return ;
        moveBackword();
        
        arr[head]=value;   
    }
     public T dequeueAtTail()
    {
        if(isEmpty())
            return null;
        return arr[tail--];
    }
    
    
      public void moveBackword()
    {
        for (int i = tail; i >= 0; i--)
        {
            arr[i+1] = arr[i];
        }
        tail++;
    }
     public void moveForward()
    {
        for (int i = 1; i < arr.length; i++)
        {
            arr[i-1]=arr[i];
        }
        tail--;
    }
     
}