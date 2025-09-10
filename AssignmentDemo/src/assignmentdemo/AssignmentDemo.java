
package assignmentdemo;
import java.util.Stack;

public class AssignmentDemo
{

    public static void main(String[] args)
    {
        String exp = "+ 2 * 13 4";
        System.out.println("Answer = " + preEval(exp));
    }
    
    public static double preEval(String ex)
    {
        String[] exp = ex.split(" ");
        Stack<Double> st = new Stack<>();
        
        for(int i = exp.length-1;i>=0 ;i--)
        {
            if(exp[i].length() > 1 && Character.isDigit(exp[i].charAt(1)))
            {
                st.push(Double.parseDouble(exp[i]));
            }
            if(Character.isDigit(exp[i].charAt(0)))
            {
                st.push(Double.parseDouble(exp[i]));
            }
            else
            {
                double op1 = st.pop();
                double op2 =st.pop();
                switch(exp[i])
                {
                    case "+":
                        st.push(op1+op2);
                        break;
                    case "-":
                        st.push(op1-op2);
                        break;
                    case "*":
                        st.push(op1*op2);
                        break;
                    case "/":
                        st.push(op1/op2);
                        break;
                    default:
                        System.out.println("Invalid Operator");
                        
                }
            }
        }
        return st.pop();
        
    }
    
    public static double postEval(String ex)
    {
        String[] exp = ex.split(" ");
        Stack<Double> st = new Stack<>();
        
        for(int i = 0; i<exp.length; i++)
        {
            if(Character.isDigit(exp[i].charAt(0)))
            {
                st.push(Double.parseDouble(exp[i]));
            }
            else
            {
                double op2 = st.pop();
                double op1 =st.pop();
                switch(exp[i])
                {
                    case "+":
                        st.push(op1+op2);
                        break;
                    case "-":
                        st.push(op1-op2);
                        break;
                    case "*":
                        st.push(op1*op2);
                        break;
                    case "/":
                        st.push(op1/op2);
                        break;
                    default:
                        System.out.println("Invalid Operator");
                        
                }
            }
        }
        return st.pop();
        
    }
    
    public static int prec(char op)
    {
        if(op == '^')
            return 4;
        else if(op == '*' || op == '/' || op == '%')
            return 3;
        else if(op == '+' || op == '-')
            return 2;
        else
            return 1;
    }
    
    public static String in2Pre(String ex)
    {
        
        String cEx="";
        Stack<Character> st = new Stack<>();
        for(int i = ex.length()-1 ; i>=0; i--)
        {
            char c = ex.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                cEx = cEx + c;
            }
            else if(c == ')')
            {
                st.push(c);
            }
            else if (c == '(')
            {
                while(st.peek() != ')')
                    cEx = cEx + st.pop();
                st.pop();
            }
            else
            {
                while(prec(st.peek()) > prec(c))
                    cEx = cEx + st.pop();
                
                st.push(c);
            }
        }
        String s = "";
        for(int i = cEx.length()-1; i>=0; i--)
        {
            s = s+cEx.charAt(i);
        }
        return s;
    }
    
}
