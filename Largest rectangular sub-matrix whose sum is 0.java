Given a matrix mat[][] of size N x M. The task is to find the largest rectangular sub-matrix by area whose sum is 0.

If there are multiple solutions return the rectangle which starts from minimum column index. If you still have multiple solutions return the one starting from minimum row index. If you still have multiple solutions return the one having greatest row number. If no such matrix is present return a zero (0) size matrix.

Example 1:

Input: N = 3, M = 3
mat[][] =  1, 2, 3
          -3,-2,-1
           1, 7, 5

Output:  1, 2, 3
        -3,-2,-1

Explanation: This is the largest sub-matrix,
whose sum is 0.
Example 2:

Input: N = 4, M = 4
mat[][] = 9, 7, 16, 5
          1,-6,-7, 3
          1, 8, 7, 9
          7, -2, 0, 10

 Output: -6,-7
          8, 7
         -2, 0 
Your Task:
You don't need to read input or print anything. You just have to complete the function sumZeroMatrix() which takes a 2D matrix mat[][], its dimensions N and M as inputs and returns a largest sub-matrix, whose sum is 0.

Expected Time Complexity: O(N*M*M).
Expected Auxiliary Space: O(N*M).


Constraints:
1 <= N, M <= 100
-1000 <= mat[][] <= 1000
 



class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int maxElements=-1;
        
        int ansrow=-1;
        int anscol=-1;
        int ansrowlen=-1;
        int anscollen=-1;
        
        int n=a.length;
        int m=a[0].length;
        
       
        
        long sumarr[][]=new long[n][m];
        
        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum+=a[i][j];
                sumarr[i][j]=sum;
            }
        }
        
        long temp[]=new long[m];
        
        HashMap<Long,Integer> map;
        long sum=0l;
        
        for(int i=0;i<n;i++){
            
            for(int k=0;k<i;k++){
                
                map=new HashMap<>();
                map.put(0l,-1);
                sum=0;
                //System.out.println(i+" "+k);
                for(int j=0;j<m;j++){
                    temp[j]=sumarr[i][j]-sumarr[k][j];
                    sum+=temp[j];
                    
                    if(map.containsKey(sum)==true){
                        
                        int col=j-map.get(sum);
                        int row=i-k;
                        
                        //System.out.println("In "+i+" "+j+" "+row+" "+col+" "+maxElements+" "+(ansrow-ansrowlen+1)+" "+(i-row+1));
                        if(maxElements<(row*col)
                        || (maxElements==(row*col) && anscol-anscollen+1>j-col+1)
                        || (maxElements==(row*col) && anscol-anscollen+1==j-col+1 && ansrow-ansrowlen+1>i-row+1) 
                        || (maxElements==(row*col) && ansrow-ansrowlen+1==i-row+1 && anscol-anscollen+1==j-col+1 && ansrow<row)
                        ){
                            //System.out.println(i+" "+j+" "+row+" "+col+" "+maxElements);
                            
                            maxElements=row*col;
                            anscollen=col;
                            ansrowlen=row;
                            anscol=j;
                            ansrow=i;
                        }
                        
                    }
            
                    map.putIfAbsent(sum, j);
                }
                
                
                
            }
            
            map=new HashMap<>();
            map.put(0l,-1);
            sum=0;
            
            for(int j=0;j<m;j++){
                temp[j]=sumarr[i][j];
                sum+=temp[j];
                    
                if(map.containsKey(sum)==true){
                    int col=j-map.get(sum);
                    int row=i+1;
                    
                    if(maxElements<(row*col)
                        || (maxElements==(row*col) && anscol-anscollen+1>j-col+1)
                        || (maxElements==(row*col) && anscol-anscollen+1==j-col+1 && ansrow-ansrowlen+1>i-row+1) 
                        || (maxElements==(row*col) && ansrow-ansrowlen+1==i-row+1 && anscol-anscollen+1==j-col+1 && anscol>col)
                        ){
                        //System.out.println(i+" "+j+" "+row+" "+col+" "+maxElements);
                        maxElements=row*col;
                        anscollen=col;
                        ansrowlen=row;
                        anscol=j;
                        ansrow=i;
                    }
                    
                }
            
                map.putIfAbsent(sum, j);
            }
            
            
        }
        
        if(ansrow==-1)return ans;
        
        for(int i=ansrow-ansrowlen+1;i<=ansrow;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=anscol-anscollen+1;j<=anscol;j++){
                list.add(a[i][j]);
            }
            ans.add(list);
        }
        
        return ans;
    }
}
