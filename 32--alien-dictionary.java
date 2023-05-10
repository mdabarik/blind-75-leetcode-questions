/*
URL(GFG): https://practice.geeksforgeeks.org/problems/alien-dictionary/1
URL (LintCode): https://www.lintcode.com/problem/892
*/

/* Alien Dictionary Problem Statements:
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. 
If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. 
If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.

Input: 
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
Output: "wertf".

Input:
[
  "z",
  "x"
]
Output: "zx"

Input:
[
  "z",
  "x",
  "z"
]
Output: "" 
Explanation: The order is invalid, so return "".

Input:
[
  "A",
  "B",
  "C"
]
Output: "ABC"

Input:
[
  "abc"
  "ab"
]
Output: ""

Input:
[
  "ab"
  "abc"
]
Output: "abc"

Input:
[
  "apes"
  "ape"
]
Output: ""

Input:
[
  "ape"
  "apes"
]
Output: "aeps"

Input: ["abc","bcd","qwert","ab"]
Output: ""

*/


public class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";

        Map<Character, List<Character>> graph = new HashMap<>();
        int[] indegree = new int[26];
        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String curr = words[i];
            if (prev.length() == curr.length() + 1 && prev.substring(0, curr.length()).equals(curr)) return "";
            for (int k = 0; k < Math.min(prev.length(), curr.length()); k++) {
                char c1 = prev.charAt(k);
                char c2 = curr.charAt(k);
                if (c1 != c2) {
                    if (!graph.containsKey(c1))
                        graph.put(c1, new ArrayList<>());
                    graph.get(c1).add(c2);
                    indegree[c2 - 'a']++;
                    break;
                }
            }
        }

        Set<Character> uniqueCh = new HashSet<>();
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                uniqueCh.add(ch);
            }
        }

        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        for (char letter : uniqueCh) {
            if (indegree[letter - 'a'] == 0)
                minHeap.add(letter);
        }

        String topSort = "";
        while (!minHeap.isEmpty()) {
            char currCh = minHeap.poll();
            topSort += currCh;
            if (graph.get(currCh) == null) continue;
            for (char neighbor : graph.get(currCh)) {
                if (--indegree[neighbor - 'a'] == 0) {
                    minHeap.add(neighbor);
                }
            }
        }

        return topSort.length() == uniqueCh.size() ? topSort : "";
    }
}
