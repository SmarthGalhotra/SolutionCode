/* 
Problem: https://www.spoj.com/problems/JNEXT/
Resources:
https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
https://stackoverflow.com/questions/1622532/algorithm-to-find-next-greater-permutation-of-a-given-string/1622539#1622539 
*/

import java.util.*;
import java.lang.*;

class SpojJustNext
{
	public static void main (String[] args) throws java.lang.Exception
	{
        int []array = {0, 1, 2, 5, 3, 3, 0};
        System.out.println(Arrays.toString(array));
        boolean ans = nextPermutation(array);
        System.out.println(ans);
	}

public static boolean nextPermutation(int[] array) {
    // Find longest non-increasing suffix
    int i = array.length - 1;
    while (i > 0 && array[i - 1] >= array[i])
        i--;
    // Now i is the head index of the suffix
    
    // Are we at the last permutation already?
    if (i <= 0)
        return false;
    
    // Let array[i - 1] be the pivot
    // Find rightmost element that exceeds the pivot
    int j = array.length - 1;
    while (array[j] <= array[i - 1])
        j--;
    // Now the value array[j] will become the new pivot
    // Assertion: j >= i
    
    // Swap the pivot with j
    int temp = array[i - 1];
    array[i - 1] = array[j];
    array[j] = temp;
    
    // Reverse the suffix
    j = array.length - 1;
    while (i < j) {
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        i++;
        j--;
    }
    System.out.println(Arrays.toString(array));
    // Successfully computed the next permutation
    return true;
}
}
/* 
BONUS(Learnt while looking for something else)

1. Method vs Function

Method: 
always defined with in class
called using instance or object;

Function: 
self contained program
called independently

2. Calculating number of digits using Logarithm 
 n = log10(inputNumber) + 1;  
*/