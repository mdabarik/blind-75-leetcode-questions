class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch_arr = str.toCharArray();
            Arrays.sort(ch_arr);
            String sortedStr = new String(ch_arr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr)F.add(str);
        }
        return new ArrayList<>(map.values());
    }
} // TC: O(n * k * log k), SC: O(n * k)
