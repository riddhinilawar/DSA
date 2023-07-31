Word Ladder-I

Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:
A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.
Note: If no possible way to transform sequence from startWord to targetWord return 0

Example 1:
Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".
Example 2:
Input:
wordList = {"geek", "gefk"}
startWord = "gedk", targetWord= "geek", 
Output:
2
Explanation:
gedk -> geek
Example 3:
Input: 
wordList = {"poon", "plee", "same", "poie","plea","plie","poin"}
startWord = "toon", targetWord= "plea",
Output: 7 
Explanation:
toon -> poon -> poin -> poie -> plie -> plee -> plea 
 
Your Task:
You don't need to read or print anything, Your task is to complete the function wordLadderLength() which takes startWord, targetWord and wordList as input parameter and returns the length of the shortest transformation sequence from startWord to targetWord. If not possible return 0.

Expected Time Compelxity: O(N2 * M)
Expected Auxiliary Space: O(N * M) where N = length of wordList and M = |wordListi|

Constraints:
1 ≤ N ≤ 100
1 ≤ M ≤ 10


class Solution
{
	public int wordLadderLength(String startWord, String targetWord, String[] wordList)
	{
		HashSet<String> set=new HashSet<>();  
		for(String word:wordList)
			set.add(word);

		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(startWord,1));
		set.remove(startWord);


		while(!q.isEmpty()){
			String word=q.peek().word;
			int weight=q.peek().level;
			q.remove();
			for(int i=0;i<word.length();i++){
				for(int j=97;j<=122;j++){
					char wordArr[]=word.toCharArray();
					wordArr[i]=(char)j;
					String newWord=String.valueOf(wordArr);
					if(set.contains(newWord)==true){
						//System.out.println(word+" "+newWord+" "+ans);
						q.add(new Pair(newWord,weight+1));
						set.remove(newWord);
						if(newWord.equals(targetWord)==true)return weight+1;
					}
				}
			}
		}
		return 0;
	}
}
class Pair{
	String word;
	int level;
	Pair(String word,int level){
		this.word=word;
		this.level=level;
	}
}
