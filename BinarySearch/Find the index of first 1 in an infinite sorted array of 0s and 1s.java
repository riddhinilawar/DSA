Find the index of first 1 in an infinite sorted array of 0s and 1s


Input : arr[] = {0, 0, 1, 1, 1, 1} 
Output : 2

Input : arr[] = {1, 1, 1, 1,, 1, 1}
Output : 0

Algorithm: 

posOfFirstOne(arr)
    Declare l = 0, h = 1
    while arr[h] == 0
        l = h
    h = 2*h;
    return indexOfFirstOne(arr, l, h)
}

Note:: Here we don't know the range ..because we don't know where is high located... so we are shifting towards the right gradually


  public class Main {
    // function to find the index of first 1 in an infinite sorted array of 0's and 1's
    static int posOfFirstOne(int[] arr) {
        // find the upper and lower bounds between which the first '1' would be present
        int l = 0, h = 1;

        // as the array is being considered infinite, 'h' index will always exist in the array
        while (arr[h] == 0) {
            // lower bound
            l = h;

            // upper bound
            h = 2 * h;
        }

        // required index of first '1'
        return indexOfFirstOne(arr, l, h);
    }

    // function to find the index of first '1'
    static int indexOfFirstOne(int[] arr, int low, int high) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;

            // if true, then 'mid' is the index of first '1'
            if (arr[mid] == 1 && (mid == 0 || arr[mid - 1] == 0))
                return mid;

            // first '1' lies to the left of 'mid'
            else if (arr[mid] == 1)
                high = mid - 1;

            // first '1' lies to the right of 'mid'
            else
                low = mid + 1;
        }

        // required index
        return -1; // Return -1 if not found (not necessary if it's guaranteed to find a 1)
    }

    // Driver program to test above
    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 1 };
        System.out.println("Index = " + posOfFirstOne(arr));
    }
}


