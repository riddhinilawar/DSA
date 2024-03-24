This is a question I havent seen on leetcode. Essentially, you are given a complete list of directories and files in the file system, and then a subset of files. Return an augmented list of the subset, where if all files in a directory are listed in the subset, replace those file names with the directory name.

Example input & output:
allFiles = [
"a/b/c/d.txt",
"a/b/c/e.txt",
"a/b/b.txt",
"a/b/e.txt",
"b/c/d.txt"
]

subsetFiles = [
"a/b/c/d.txt",
"a/b/c/e.txt",
"a/b/b.txt",
"b/c/d.txt"
]

output=[
"a/b/c",
"a/b/b.txt",
"b"
]

This is a solution I made after the interview, I wasn't able to code up a working solution within the time allotment. Please reply if you have a more efficient/effective solution, or if you can identify a similar problem on leetcode!

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        String allFile[]={"a/b/c/d.txt","a/b/c/e.txt","a/b/b.txt","a/b/e.txt","b/c/d.txt"};
        String subFile[]={"a/b/c/d.txt","a/b/c/e.txt","a/b/b.txt","b/c/d.txt","a/b/e.txt"};

        
        Trie obj = new Trie();
        for(String str:allFile){
            obj.insert(str);
        }
        for(String str:subFile){
            obj.visited(str);
        }
        
        HashSet<String> ans = new HashSet<>();
        
        for(String subStr:subFile){
            String temp=obj.calculate(subStr);
            ans.add(temp);
            
        }
        
        System.out.println(ans);
    }
}
class Trie{
    Node root;
    Trie(){
        root=new Node();
    }
    
    public void insert(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            
            char c=str.charAt(i);
            
            if(c=='/')continue;
            if(c=='.')break;
            
            
            
            if(curr.contains(c)==false){
                curr.setNode(c);
            }
            curr=curr.getNode(c);
            curr.incrementI();
        }
        curr.setFile();
    }
    public void visited(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            
            char c=str.charAt(i);
            
            if(c=='/')continue;
            if(c=='.')break;
            
            curr=curr.getNode(c);
            curr.incrementV();
        }
    }
    
    public String calculate(String str){
        Node curr=root;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            
            if(c=='/')continue;
            if(c=='.')break;
            
            curr=curr.getNode(c);
            
            sb.append(c+"/");
            
            if(curr.isFile()==true){
                return sb.toString().substring(0,sb.length()-1)+".txt";
            }
            
            if(curr.getI()==curr.getV()){
                return sb.toString();
            }
        }
        return sb.toString().substring(0,sb.length()-1)+".txt";
    }
    
}
class Node{
    Node node[];
    boolean isFile;
    int countI;
    int countV;
    
    Node(){
        node=new Node[26];
        isFile=false;
        countI=0;
        countV=0;
    }
    
    public boolean contains(char c){
        return node[c-'a']!=null;
    }
    public Node getNode(char c){
        return node[c-'a'];
    }
    public void setNode(char c){
        node[c-'a']=new Node();
    }
    public boolean isFile(){
        return isFile;
    } 
    public void setFile(){
        isFile=true;
    }
    public void incrementI(){
        this.countI++;
    }   
    public void incrementV(){
        this.countV++;
    }
    public int getI(){
        return this.countI;
    }
    public int getV(){
        return this.countV;
    }
}
