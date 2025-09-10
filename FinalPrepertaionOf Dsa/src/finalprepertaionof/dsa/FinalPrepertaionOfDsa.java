/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalprepertaionof.dsa;

/**
 *
 * @author WALEED TRADERS
 */
public class FinalPrepertaionOfDsa
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here\
        Stack<Character> st = new Stack<>();
     String str = "(((2+(4*5))-(6/1))+3)";
     String ans="";
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
              ans+=ch;
            }
            else{
                switch (ch)
                {
                    case '(':
                        st.push(ch);
                        break;
                    case ')':
                        while(st.peak()!=')'){
                         ans+=st.pop();
                        }
                        st.pop();
                        break;
                    default:
                        while(pre(st.peak())>pre(ch)){
                            ans+=st.pop();
                        }
                        st.push(ch);
                }
            }
        }
        System.out.println(ans);
    }
    public static int pre(char ch)
    {
        switch (ch)
        {
            case '^':
                return 4;
                            case '*':
                               case '/':
                                   case '%':
                return 3;
                case '+':
                    case '-':
                        return 2;
                
            default:
                return 1;
        }
    }
    
}
class Stack<T>{
    T[] arr = (T[])new Object[20];
    int top =-1;
    public boolean isEmpty()
    {
        return (top<=-1);
    }
    public boolean isFull()
    {
        return (top>=arr.length-1);
    }
     public void push(T value)
    {
      if(isFull()){
          System.out.println("Stack is over flow");
      }
      else{
          arr[++top]=value;
      }
    }
     
       public T pop()
    {
      if(isEmpty()){
          System.out.println("Stack is UnderFlow");
          return null;
      }
      else{
       return  arr[top--];
      }
    }
        public T peak()
    {
      if(isEmpty()){
          System.out.println("Stack is UnderFlow");
          return null;
      }
      else{
       return  arr[top];
      }
    }
       public boolean search(T value)
    {
        if(isEmpty()){
            return false;
        }
        for (int i = 0; i <=top; i++)
        {
            return (value==arr[i]);
            
        }
        return false;
    }
     
     public void treverse()
    {
                if(isEmpty()){
                    System.out.println("stack is empty");
        }
        for (int i = top; i >=0; i--)
        {
            System.out.println(arr[i]+"  ");
            
        }
    }
     
     
}