package udemy.dsa;

import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        int [] intArray = new int [7];
        int choice = 4;

        intArray[0] = -2;
        intArray[1] = 34;
        intArray[2] = 12;
        intArray[3] = -90;
        intArray[4] = 45;
        intArray[5] = 87;
        intArray[6] = -56;

        System.out.println("Array before:");
        int k;
        for (k = 0; k<intArray.length; k++) System.out.println(intArray[k]);

        System.out.println("Please enter");
        System.out.println("1 for Bubble Sort");
        System.out.println("2 for Selection Sort");

        Instant start = Instant.now();


        switch (choice){
            case 1:
                System.out.println("Recursive Bubble Sort");
                recurBubbleSort(intArray, intArray.length );
                break;
            case 2:
                System.out.println("Recursive Selection Sort");
                recurSelectionSort(intArray, intArray.length,0);
            case 3:
                System.out.println("Recursive Insertion Sort");
                recurInsertionSort(intArray, intArray.length, 0);
            case 4:
                System.out.println("Merge Sort");
                mergeSort(intArray);
        }


        Instant finish = Instant.now();


        long timeElapsed = Duration.between(start, finish).toNanos();

        System.out.println("Array after:");
        for (k=0; k<intArray.length; k++) System.out.println(intArray[k]);

        System.out.println("Time elapsed = " +timeElapsed);

    }

    static void  recurBubbleSort(int[] array, int n) {


        if (n == 1)
            return;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                bubbleSwap(array, i , i+1);
            }
        }

        recurBubbleSort(array, n-1);
    }

    static void recurSelectionSort(int[] array, int n, int index){

        if(index == n){
            return;
        }


        int endIndex = n-1; //endIndex = array.length-1

        int indexOfMin = findIndexOfMin(array, index, endIndex);
        if(!(indexOfMin == index)) swap(array , index, indexOfMin);

        recurSelectionSort(array, n, index+1);

    }

    static void recurInsertionSort(int [] array, int n,int index){
        if(index == n){
            return;
        }

        int value = array[index];
        int hole = index;

        while (hole > 0 && array[hole-1] > value){
            array[hole] = array[hole-1];
            hole = hole-1;
        }

        array[hole] = value;

        recurInsertionSort(array, n, index+1);
    }

    static void mergeSort(int[] array){
        System.out.println("-------- MergeSort Starts ----------");
        int n = array.length;
        int i ;
        if(n < 2){
            System.out.println(" -------- Returning ---------- ");
            return;
        }

        int mid = n/2;

        int []left = new int[mid];
        int []right = new int[n-mid];

        for ( i = 0; i< mid; i++){
            left[i] = array[i];
            System.out.println("Left [" + i + "] is = " + left[i]);
        }

        for (i = mid; i< n; i++){
            right[i-mid] = array[i];
            System.out.println("Right [" + (i-mid) + "] is = " + right[i-mid]);

        }


        System.out.println("-------- MergeSort Left Starts ----------");
        mergeSort(left);
        System.out.println("-------- MergeSort Left Ends ----------");

        System.out.println("-------- MergeSort Right Starts ----------");
        mergeSort(right);
        System.out.println("-------- MergeSort Right Ends ----------");

        merge(left, right, array);
        System.out.println("-------- MergeSort Ends ----------");

    }

    static void merge(int []leftArray, int []rightArray , int []array){
        System.out.println("-------- Merge     Starts ----------");
        int k = 0;
        int i = 0;
        int j = 0;

            while ( k< array.length && i < leftArray.length && j< rightArray.length){
                if (leftArray[i] <= rightArray[j]){
                    array[k] = leftArray[i];
                    System.out.println("Inserting "+ leftArray[i] +" to array["+ k +"]");
                    i++;
                }
                else{
                    array[k] = rightArray[j];
                    System.out.println("Inserting "+ rightArray[j] +" to array["+ k +"]");
                    j++;
                }
                k++;
            }
            while (i < leftArray.length){
                array[k] = leftArray[i];
                System.out.println("Inserting "+ leftArray[i] +" to array["+ k +"]");
                i++;
                k++;
            }
            while (j < rightArray.length){
                array[k] = rightArray[j];
                System.out.println("Inserting "+ rightArray[j] +" to array["+ k +"]");
                j++;
                k++;
        }
        System.out.println("-------- Merge     Ends ----------");

    }

    static void quickSort(int[] intArray,int start,int end){
        // Time Complexity:
        // Average case: O(n log(n))
        // Worst case : O (n^2)
        //Space complexity : O(log(n))


        /*
        Pseudo code:

        quickSort(A, start, end){
            if(start < end){

                 pIndex = partition(A, start, end);
                 quickSort(A, 0 , pIndex-1 );
                 quickSort(A, pIndex+1, end);
                 }
         }

          int partition(A, start, end ){
              pivot = A[end]     //Choosing right-most element as pivot
              pIndex  = start;

              for(i = start; i <= end; i++){
                 if(A[i]<= pivot)

         */

    }


    static void bubbleSwap (int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp;

    }

    static  void swap (int[] arr, int i , int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int  findIndexOfMin(int[] arr, int s, int e){


        int min = arr[s];
        int minIndex = s;

        for (int i =s; i<= e; i++){
            if (arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
