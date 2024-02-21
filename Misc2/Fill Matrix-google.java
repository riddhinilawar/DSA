Given a NxN matrix. Fill the integers from 1 to n*n to this matrix that makes the sum of each row, each column and the two diagonals equal.

Example 1:

Input: n = 2
Output: null
Explanation: We need to fill [1, 2, 3, 4] into a 2x2 matrix, which is not possible so return null.
Example 2:

Input: n = 3
Output:
[[8, 3, 4],
 [1, 5, 9],
 [6, 7, 2]]
Explanation: We need to fill [1, 2, 3... 9] into a 3x3 matrix. This is one way to do it
Each row [8, 3, 4] [1, 5, 9] [6, 7, 2] sum is 15.
Each column [8, 1, 6] [3, 5, 7] [4, 9, 2] sum is 15.
The two diagonals [8, 5, 2] [4, 5, 6] sum is 15.
  
int[][] fillMatrix(int n) {
    
}
I tested with input n being from 1 to 1626, and this code returned correct 2D array whose sum of each row, each column, two diagonals are all the same.
There are three functions:

fillMatrixOdd for n being odd
fillMatrixDoublyEven for n being doubly even; multiples of 4
fillMatrixSinglyEven for n being singly even; 4*k + 2 where an integer k >= 0
For singly even case, I found this link(https://en.wikipedia.org/wiki/Strachey_method_for_magic_squares) very helpful.
  bool check_current_row(int arr[100][100],int row, int n)
{
    int sum=0;
    for(int i=0;i<n;i++)
    sum+=arr[row][i];
    return (sum==(n*n*n+n)/2);
}


bool is_Valid(int arr[100][100], int n)
{
    // check the columms and the diagonals;
    int value =(n*n*n+n)/2;
    for(int j=0;j<n;j++)
    {
        int temp=0;
        for(int i=0;i<n;i++)
        temp+=arr[i][j];
        
        if(temp!=value)
        return false;
    }
    
    int dia1=0,dia2=0;
    for(int i=0;i<n;i++)
    {
        dia1+=arr[i][i];
        dia2+=arr[i][n-1-i];
    }
    
    if(dia1!=value or dia2!=value) return false;
    
    return true;
}


bool solve(int arr[100][100], bool vis[], int row, int col, int n)
{
    
    if(col==n)
    {
        //check current row sum
        bool b = check_current_row(arr,row,n);
        if(b)
        {
            if(solve(arr,vis,row+1,0,n))
            return true;
        }
        else
        return false;
    }
    
    if(row==n)
    return is_Valid(arr,n);
    
    for(int i=1;i<=n*n;i++)
    {
        if(vis[i]==false)
        {
            arr[row][col]=i;
            vis[i]=true;
            if(solve(arr,vis,row,col+1,n))
            return true;
            vis[i]=false;
            
        }
    }
    
    return false;
    
}

int main() {
   int n; cin>>n;
   bool vis[n*n+1]; memset(vis,false,sizeof(vis));
   int arr[100][100]; memset(arr,-1,sizeof(arr));
   if(solve(arr,vis,0,0,n))
   {
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           cout<<arr[i][j]<<" ";
           cout<<"\n";
       }
   }
   else
   cout<<"Not possible"<<"\n";
}
