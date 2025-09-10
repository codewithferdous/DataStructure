/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testrandomiser;

import java.util.Random;

/**
 *
 * @author WALEED TRADERS
 */

public class TestRandomiser
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
//Group 12
//Muhammad Asim Ilyas (FA22-BSE-111)          (1st Member)    Group Leader
//Muhammad Faizyab    (FA22-BSE-017)          (3rd Member)  
//Fahim ullah         (SP22-BSE-024)          (2nd Member)
        
        Randomizer r = new Randomizer(5);
        r.treverse();
        r.input(-12);
        r.input(92);
        r.input(122);
        r.input(923);
        r.input(34);
        r.input(12);
        r.treverse();
        System.out.println("Deleted value :" + r.output());
        r.treverse();

        System.out.println("Deleted value :" + r.output());
        r.treverse();

        System.out.println("Deleted value :" + r.output());
        r.treverse();
        System.out.println("Deleted value :" + r.output());
        r.treverse();
    }

}

class Randomizer
{
    int[] arr ;
    Random rand = new Random();
    int count = -1;

    public Randomizer(int size)
    {
        arr = new int[size];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = -1;
        }
    }

    public boolean IsEmpty()
    {
        return count == -1;
    }

    public boolean IsFull()
    {
        return count == (arr.length - 1);
    }

    public void input(int value)
    {
        if (value < 0)
        {
            System.out.println("Nagetive Nomber cannot be insert in Randmozir array");
            return;
        } else
        {
            if (IsFull())
            {
                System.out.println("Randomizer is OverFlow");
                return;
            }

            int index;
            do
            {
                index = rand.nextInt(arr.length);
            } while (arr[index] != -1);

            arr[index] = value;
            count++;
        }

    }

public void treverse() {
    if (IsEmpty()) {
        System.out.println("Randomizer is UnderFlow");
    }
    for (int i = arr.length - 1; i >= 0; i--) {
        if (arr[i] >= 0) {
            System.out.println("| " + arr[i] + " |");
        } else {
            System.out.println("|  NULL   |");
        }
        System.out.println("_________________");
    }
}


    public int output()
    {
        if (IsEmpty())
        {

            System.out.println("Randomizer is UnderFlow");
            return -1;
        }
        int index;
        do
        {
            index = rand.nextInt(arr.length);
        } while (arr[index] < 0);
        int value = arr[index];
        arr[index] = -1;
        count--;
        return value;
    }

}
class Randomizerr{
    int [] arr=new int[5];
    Random rand = new Random();
    int count=0;

    public Randomizerr()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=-1;
        }
    }
    public boolean isEmpty()
    {
        return count==0;
    }
    public boolean isFull()
    {
        return count==(arr.length);
    }
    
    public void input(int value)
    {
       if(value<0){
           System.out.println("negative values cant inserted");
           return;
       }
       if(isFull()){
           System.out.println("");
                   return;
       }
       int index;
       do{
           index=rand.nextInt(arr.length);
       }
       while(arr[index]!=-1);
       arr[index]=value;
       count++;
    }
    public int output()
    {
        if(isEmpty()){
            System.out.println("empty");
            return -1;
        }
        int index;
        do{
           index=rand.nextInt(arr.length);
       }
       while(arr[index]<0);
        int value=arr[index];
        arr[index]=-1;
        count--;
        return value;
    }
     
     
    
}