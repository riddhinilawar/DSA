Given an array, write a program to generate a random permutation of array elements. This question is also asked as “shuffle a deck of cards” or “randomize a given array”. Here shuffle means that every permutation of array element should be equally likely. 

shuffle-array

Let the given array be arr[]. A simple solution is to create an auxiliary array temp[] which is initially a copy of arr[]. Randomly select an element from temp[], copy the randomly selected element to arr[0], and remove the selected element from temp[]. Repeat the same process n times and keep copying elements to arr[1], arr[2], … . The time complexity of this solution will be O(n^2).

Fisher–Yates shuffle Algorithm works in O(n) time complexity. The assumption here is, we are given a function rand() that generates a random number in O(1) time. The idea is to start from the last element and swap it with a randomly selected element from the whole array (including the last). Now consider the array from 0 to n-2 (size reduced by 1), and repeat the process till we hit the first element. 


// Java Program to shuffle a given array
import java.util.Random;
import java.util.Arrays;
public class ShuffleRand 
{
	// A Function to generate a random permutation of arr[]
	static void randomize( int arr[], int n)
	{
		// Creating a object for Random class
		Random r = new Random();
		
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			
			// Pick a random index from 0 to i
			int j = r.nextInt(i+1);
			
			// Swap arr[i] with the element at random index
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		// Prints the random array
		System.out.println(Arrays.toString(arr));
	}
	
	// Driver Program to test above function
	public static void main(String[] args) 
	{
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int n = arr.length;
		randomize (arr, n);
	}
}
// This code is contributed by Sumit Ghosh
