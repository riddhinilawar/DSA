Given an array of size N. The task is to sort the array elements by completing functions heapify() and buildHeap() which are used to implement Heap Sort.

Example 1:

Input:
N = 5
arr[] = {4,1,3,9,7}
Output:
1 3 4 7 9
Explanation:
After sorting elements
using heap sort, elements will be
in order as 1,3,4,7,9.
Example 2:

Input:
N = 10
arr[] = {10,9,8,7,6,5,4,3,2,1}
Output:
1 2 3 4 5 6 7 8 9 10
Explanation:
After sorting elements
using heap sort, elements will be
in order as 1, 2,3,4,5,6,7,8,9,10.
Your Task :
You don't have to read input or print anything. Your task is to complete the functions heapify(), buildheap() and heapSort() where heapSort() and buildheap() takes the array and it's size as input and heapify() takes the array, it's size and an index i as input. Complete and use these functions to sort the array using heap sort algorithm.
Note: You don't have to return the sorted list. You need to sort the array "arr" in place.

Expected Time Complexity: O(N * Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ N ≤ 106
1 ≤ arr[i] ≤ 106

  


class Solution
{
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n){
    // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        
        buildHeap(arr,n);
    
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 }
 
 
