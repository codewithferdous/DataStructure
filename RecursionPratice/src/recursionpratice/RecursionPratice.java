/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursionpratice;

/**
 *
 * @author WALEED TRADERS
 */
public class RecursionPratice
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        System.out.println(fib(7));
    }
//print 1 to 10

    public static int print(int x)
    {
        if (x > 20)
        {
            return 0;
        }

        return x + print(x + 2);
    }

    public static int power(int num, int pow)
    {
        if (pow <= 1)
        {
            return num;
        }

        return num * power(num, pow - 1);
    }

    public static int reverse(int num)
    {
        if (num <= 0)
        {
            return 0;
        }
        int digit = num % 10;
        System.out.println(+digit);
        return reverse(num / 10);
    }

    public static int fib(int num)
    {
        if (num == 0 || num == 1)
        {
            System.out.println(num);
            return num;
        }
      
        return fib(num - 1) + fib(num - 2);
        
    }

    public static void FibPrint(int num)
    {
        if (num >= 10)
        {
            return;
        }
        System.out.println(num + "   ->   " + fib(num));
        FibPrint(num + 1);
    }
}
