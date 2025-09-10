/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testarraylist;

/**
 *
 * @author WALEED TRADERS
 */
public class TestArrayList
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        ArrayList a = new ArrayList();
        a.insert(12);
        a.insert(11);
        a.insert(10);
        a.insert(19);
     
        
        a.print();
        System.out.println("");
        a.InsertAtIndex(2, 70);
        a.print();
        System.out.println("");
        a.InsertAtIndex(9, 90);
        a.print();
        
    }
    
}

class ArrayList
{

    int[] arr=new int[5];
    int top = -1;

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public boolean isFull()
    {
        return (top == arr.length - 1);
    }
    
    public ArrayList()
    {
      
    }

    public void insert(int num)
    {
        if (isFull())
        {
            this.greaterTheArraySize();
        }
         arr[++top] = num;
    }

    public void greaterTheArraySize()
    {
        
        int[] arr1 = new int[arr.length + 5];
        for (int i = 0; i < arr.length; i++)
        {
            arr1[i] = arr[i];
        }
        arr = arr1;
    }

    public void print()
    {
        for (int i = 0; i <= top; i++)
        {
            System.out.print(arr[ i] + " ");
        }
    }
    public void InsertAtIndex(int index,int value)
    {
        if(isEmpty()){
            arr=new int[index+1];
            arr[index]=value;
             top=index;
            return;
        }
        else if(index>arr.length-1){
          int[]   arr1=new int[index+1];
             for (int i = 0; i <= top; i++)
            {
              arr1[i]=arr[i];  
            }
             arr1[index]=value;
             arr=arr1;
             top =index;
             return;
        }
        else
        {
           arr[index]=value;
        }
       
    }
    
}
