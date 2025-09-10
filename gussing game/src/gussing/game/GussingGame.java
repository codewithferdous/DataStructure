/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gussing.game;

import static java.awt.Color.red;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author WALEED TRADERS
 */
public class GussingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("The Numbers are: ");
        Random random = new Random();
        int[] arr= new int[21];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=random.nextInt(150);
        }
        for (int k = 0; k < arr.length; k++)
            {
                System.err.print(arr[k]+"   ");
            }
        System.out.println("");
        System.out.println("");
        System.out.println("take a number in your mind in given no");
        System.out.println("");
        Scanner input = new Scanner(System.in);
        input.next();
        int count=0;
      while(count<3){
        int arr1[]=new int[7];
        int arr2[]=new int[7];
        int arr3[]=new int[7];
        int j=0;
        for (int i = 0; i < arr1.length;i++) {
            arr1[i]=arr[j++];
            arr2[i]=arr[j++];
            arr3[i]=arr[j++];
        }
          System.out.println("");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+"       ");
            System.out.print(arr2[i]+"       ");
            System.out.print(arr3[i]+"       ");
            System.out.println("");
        }
        System.out.println("");
         for (int i = 0; i < arr2.length; i++) {
        }
         System.out.println("");
          for (int i = 0; i < arr3.length; i++) {
        }
          System.out.println("");
            System.out.println("your number is present in which coloms : ");
          int choice =  input.nextInt();
        System.out.println("");
        
                  if(choice==1){
                      for (int k = 0; k < arr2.length; k++) {
                          arr[k]=arr2[k];
                          arr[k+7]=arr1[k];
                          arr[k+14]=arr3[k];
                      }
                  }
                  else if(choice==2)
                  {
                       for (int k = 0; k < arr2.length; k++) {
                          arr[k]=arr1[k];
                          arr[k+7]=arr2[k];
                          arr[k+14]=arr3[k];
                      }
                  }
                  else if(choice==3)
                  {
                      for (int k = 0; k < arr2.length; k++) {
                          arr[k]=arr1[k];
                          arr[k+7]=arr3[k];
                          arr[k+14]=arr2[k];
                      }
                  }
                  count++;
      }
        System.out.println("");
        System.err.println("YOUR No is  :"+arr[10]);
    
    
}}
