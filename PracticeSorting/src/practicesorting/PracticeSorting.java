/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicesorting;

/**
 *
 * @author WALEED TRADERS
 */
public class PracticeSorting
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        int arr[] =
        {
            5, 7, 1, 2, 3
        };
        int high = arr.length - 1;
        int low = 0;

        mergeSort(arr, low, high);
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

    }

    public static void mergeSort(int[] arr, int low, int high)
    {
        if (high >= low)
        {
            int mid = (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high)
    {
        int i = 0, j = mid + 1, k = 0;
        int[] merged = new int[arr.length];
        while (i <= mid && j <= high)
        {
            if (arr[i] < arr[j])
            {
                merged[k++] = arr[i++];
            }

            if (arr[j] < arr[j])
            {
                merged[k++] = arr[j++];
            }
        }
        while (i <= mid)
        {
            merged[k++] = arr[i++];
        }

        while (j <= mid)
        {
            merged[k++] = arr[j++];
        }
        for (int w = high; w >= low; w--)
        {
            arr[w] = merged[--k];
        }
    }
}
