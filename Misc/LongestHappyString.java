package Misc;
import java.util.*;
//https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16


//A string s is called happy if it satisfies the following conditions:
//
//s only contains the letters 'a', 'b', and 'c'.
//s does not contain any of "aaa", "bbb", or "ccc" as a substring.
//s contains at most a occurrences of the letter 'a'.
//s contains at most b occurrences of the letter 'b'.
//s contains at most c occurrences of the letter 'c'.
//Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
//
//A substring is a contiguous sequence of characters within a string.


//Example 1:
//
//Input: a = 1, b = 1, c = 7
//Output: "ccaccbcc"
//Explanation: "ccbccacc" would also be a correct answer.
//Example 2:
//
//Input: a = 7, b = 1, c = 0
//Output: "aabaa"
//Explanation: It is the only correct answer in this case.
// 

public class LongestHappyString {
	public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((aa,bb) -> bb.cnt - aa.cnt);
        if(a > 0) pq.add(new Pair(a,'a'));
        if(b > 0) pq.add(new Pair(b,'b'));
        if(c > 0) pq.add(new Pair(c,'c'));
        StringBuilder sb = new StringBuilder("");
        
        while(pq.size() > 0){
            Pair p = pq.remove();
            int currcnt = p.cnt;
            char currchar = p.c;
            int size = sb.length();
            if(size >= 2 && sb.charAt(size - 1) == p.c && sb.charAt(size - 2) == p.c){
                if(pq.size() == 0) {
                    break;
                }
                Pair next = pq.remove();
                int nxtcnt = next.cnt;
                char nxtchar = next.c;
                sb.append(nxtchar);
                --nxtcnt;
                if(nxtcnt > 0) pq.add(new Pair(nxtcnt, nxtchar));
            }else{
                sb.append(currchar);
                --currcnt;
            }

            if(currcnt > 0){
                pq.add(new Pair(currcnt, currchar));
            }
        }

        return sb.toString();
    }

    class Pair implements Comparable<Pair>{
    int cnt;
    char c;
    Pair(int cnt, char c){
        this.cnt = cnt;
        this.c = c;
    }

    public int compareTo(Pair p){
        return p.cnt - this.cnt;
    }

}
}
