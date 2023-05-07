class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>(); // O(n)
        for (int num : nums) { // O(n)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1]; // O(n)
        for (Integer key : freqMap.keySet()) { // O(n)
            int frequency = freqMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> list = new ArrayList<>(); // O(n)
        for (int i = bucket.length - 1; i >= 0; i--) { // O(2n) ~ O(n)
            if (bucket[i] != null) {
                list.addAll(bucket[i]);
            }
            if (list.size() == k) break;
        }
        int[] ans = new int[list.size()]; // O(n)
        for (int i = 0; i < ans.length; i++) { //  O(n)
            ans[i] = list.get(i);
        }
        return ans;
    }
} // TC: O(n), SC: O(n)
