/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teststack;

/**
 *
 * @author WALEED TRADERS
 */
public class TestStack
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        Stack<Character> stack = new Stack<>();
        
        String exp="(((2+(4*5))-(6/1))+3)";
        String ans="";
  /*      for (int i = 0; i < exp.length(); i++) // infix to post fix
        {
            char c =exp.charAt(i);
            if(Character.isDigit(c)){
                ans+=c;
            }
            else{
                switch (c)
                {
                    case '(':
                        stack.push(c);
                        break;
                    case ')':
                        while (stack.peak()!='(')
                        {
                            ans+=stack.pop();
                        }
                        stack.pop();
                    break;
                    default:
                        while(prec(stack.peak())>prec(c)){
                            ans+=stack.pop();
                        }
                        stack.push(c);
                }
            }
        }
        System.out.println("Answer :"+ans);*////infix to pri fix
       /* for (int i = exp.length()-1; i >=0; i--)
        {
            char c=exp.charAt(i);
            if(Character.isDigit(c)){
                ans+=c;
            }
            else{
                switch (c)
                {
                    case ')':
                        stack.push(c);
                                           
                        break;
                        case '(':
                            while(stack.peak()!=')'){
                                ans+=stack.pop();
                            }
                            stack.pop();
                            break;
                    default:
                      while(prec(stack.peak())>prec (c)){
                          ans+=stack.pop();
                      }
                      stack.push(c);
                }
            }
            
        }
        System.out.println(ans);
        String st="";
        for (int i = ans.length()-1; i >= 0; i--)
        {
            st+=ans.charAt(i);
        }
        System.out.println(st);*/
       
        
}
    public static double prievaluate(String exp){
        Stack<Double> st = new Stack<>();
        String [] exp1=exp.split(" ");
        for (int i = exp1.length-1; i >=0; i--)
        {
            if(Character.isDigit(exp1[i].charAt(0))){
                st.push(Double.parseDouble(exp1[i]));
            }
            else{
                double num1=st.pop();
                double num2=st.pop();
                switch (exp1[i])
                {
                    case "+":
                        st.push(num1+num2);
                        
                        break;
                        case "-":
                        st.push(num1-num2);
                        
                        break;
                        case "*":
                        st.push(num1*num2);
                        break;
                        case "%":
                        st.push(num1%num2);
                        
                        break;
                    default:
                        System.out.println("Invlaid entry");
                }
            }
            
        }
        return st.pop();
    }
    public static int prec(char opr)
    {
          if(opr=='%'|| opr=='*'){
              return 4;
          }
          else if(opr=='+'|| opr=='-'){
              return 3;
          }
          else{
              return 1;
          }
    }
}






class Evalution
{

    Stack<Double> stack = new Stack<>();
  public double PostEvalute(String exp1)
    {
        //String exp1 = " anything in po";
        String[] exp = exp1.split(" ");

        for (int i = 0; i < exp.length; i++)
        {

            if (Character.isDigit(exp[i].charAt(0)))
            {

                stack.push(Double.parseDouble(exp[i]));
            } else
            {
                double num2 = stack.pop();
                double num1 = stack.pop();

                switch (exp[i])
                {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        System.err.println("NO operator or Number");
                }

            }

        }
        return stack.pop();//answer  print
    }
    public double PriEvalute(String exp1)
    {
        //String exp1 = " anything in po";
        String[] exp = exp1.split(" ");

        for (int i = exp.length - 1; i >= 0; i--)
        {

            if (Character.isDigit(exp[i].charAt(0)))
            {

                stack.push(Double.parseDouble(exp[i]));
            } else
            {
                double num1 = stack.pop();
                double num2 = stack.pop();

                switch (exp[i])
                {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        System.err.println("NO operator or Number");
                }

            }

        }
        return stack.pop();//answer  print
    }

}

class Stack<T>
{

    T[] arr = (T[]) new Object[26];
    int top = -1;

    public boolean isEmpty()
    {
        if (top == -1)
        {
            return true;
        }
        return false;
    }

    public void push(T val)
    {
        if (top >= arr.length - 1)
        {
            System.out.println("Stack is overFlow");
            return;
        }
        arr[++top] = val;
    }

    public T pop()
    {
        if (top == -1)
        {
            System.out.println("Stack is underFlow");
            return null;
        }
        T val = arr[top--];
        return val;
    }

    public T peak()
    {
        return arr[top];
    }

    public void treverse()
    { 
        for (int i = top; i >= 0; i--)
        {
            System.out.println("| " + arr[i] + " |");
            System.out.println("_________________");
        }
    }

    
}
//String exp1  = "( ( ( 21 + ( 40 * 5 ) ) - ( 6 / 15 ) ) + 39 )";
//        String[] exp =exp1.split(" ");
//        String ans = "";
//        for (int i = exp.length-1; i >=0 ; i--)
//        {
//            
//            if (Character.isDigit(exp[i].charAt(0)))
//            {
//                ans = ans + exp[i];
//                ans+=" ";
//            } else
//            {
//                switch (exp[i].charAt(0))
//                {
//                    case ')':
//                    case '+':
//                    case '-':
//                    case '*':
//                    case '/':
//                        stack.push(exp[i].charAt(0));
//                        break;
//                    case '(':
//
//                        while (stack.peak() != ')')
//                        {
//                            ans = ans + stack.pop()+" ";
//                        }
//                        stack.pop();
//                        break;
//                    default:
//                        System.out.println("Wrong Entry");
//                }
//            }
//        }
//        System.out.println(ans);
//        String[] str2 = ans.split(" ");
//        String str="";
//        for (int i = str2.length-1; i >= 0; i--)
//        {
//            str+=str2[i]+" ";
//        }
//        System.out.println(str);
//        Evalution e = new Evalution();
//        System.out.println(e.PriEvalute(str));