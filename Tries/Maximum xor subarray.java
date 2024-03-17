class Solution{

    static int maxSubarrayXOR(int N, int arr[]){
        Helper ob = new Helper();
        return ob.maxSubarrayXOR(N, arr);
    }
}
class Helper {

    static class Node {
        int bit;
        Node one, zero;

        Node(int bit) {
            this.bit = bit;
            this.one = null;
            this.zero = null;
        }
    }

    int getMax(int num, Node root) {
        Node node = root;
        int maxi = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 1 && node.zero != null) {
                node = node.zero;
                maxi += (1 << i);
            } else if (bit == 0 && node.one != null) {
                node = node.one;
                maxi += (1 << i);
            } else {
                node = (node.zero == null) ? node.one : node.zero;
            }
        }
        return maxi;
    }

    void insert(int num, Node root) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (bit == 1) {
                if (node.one == null) {
                    node.one = new Node(bit);
                }
                node = node.one;
            } else {
                if (node.zero == null) {
                    node.zero = new Node(bit);
                }
                node = node.zero;
            }
        }
    }

    int maxSubarrayXOR(int n, int[] arr) {
        int answer = Integer.MIN_VALUE;
        int prefix = 0;
        Node root = new Node(0);
        insert(prefix, root);

        for (int i = 0; i < n; i++) {
            prefix ^= arr[i];
            insert(prefix, root);
            answer = Math.max(answer, getMax(prefix, root));
        }
        return answer;
    }
}
=====================================================
//Initial template for C++

#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++



class Solution{   
public:


    struct Node{
            
        int bit;
        struct Node *one=NULL, *zero=NULL;
    };
    
    
    int getMax(int num, struct Node *root){
        
        struct Node *node = root;
        int maxi = 0;
        for(int i=31;i>=0;i--){
            int bit = (num >> i)&1;
            
            if( bit==1 && node->zero != NULL ){
                node = node->zero;
                maxi += (1<<i);
            }
            else if( bit==0 && node->one!=NULL ){
                node = node->one;
                maxi += (1<<i);
            }
            else{
                node = (node->zero==NULL)? node->one : node->zero;
            }
        }
        return maxi;
    }
    
    void insert(int num, struct Node *root){
        
        struct Node *node = root;
        for(int i=31;i>=0;i--){
            int bit = (num >> i)&1;
            
            if( bit ){
                if( node->one == NULL ){
                    struct Node newNode = (struct Node)malloc(sizeof(struct Node));
                    newNode->bit = bit;
                    node->one = newNode;
                }
                node = node->one;
            }
            else{
                if( node->zero == NULL ){
                    struct Node newNode = (struct Node)malloc(sizeof(struct Node));
                    newNode->bit = bit;
                    node->zero = newNode;
                }
                node = node->zero;
            }
        }
    }
    
    
    int maxSubarrayXOR(int n, int arr[]){    
        //code here
        int answer=INT_MIN, prefix=0;
        struct Node root = (struct Node)malloc(sizeof(struct Node));
        insert(prefix, root);
        
        for(int i=0;i<n;i++){
            prefix = prefix xor arr[i];
            insert(prefix, root);
            answer = max(answer, getMax(prefix, root));
        }
        return answer;
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N, X;
        cin >> N;
        int arr[N];
        for(int i = 0; i < N; i++){
            cin >> arr[i];
        }

        Solution ob;
        cout << ob.maxSubarrayXOR(N, arr) << endl;
    }
    return 0; 
}
