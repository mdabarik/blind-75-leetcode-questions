/*
Design an algorithm to encode a list of strings to a string. 
The encoded string is then sent over the network and is decoded back to the original list of strings.

Example 1:
Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"

Example 2:
Input: ["we", "say", ":", "yes"]
Output: ["we", "say", ":", "yes"]
Explanation:
One possible encode method is: "we:;say:;:::;yes"
*/

/*
https://www.lintcode.com/problem/659/description
*/

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        String encoded = ""; // ["lint","code","love","you"] -> "4#lint4#code4#love3#you"
        for (String s : strs) {
            encoded = encoded + s.length() + "#" + s;
        }
        return encoded;
    } // TC: O(n), SC: O(n)

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str, i, j, 10);
            list.add(str.substring(j + 1, j + len + 1));
            i = j + len + 1;
        }
        return list;
    }// TC: O(n), SC: O(n)
}
