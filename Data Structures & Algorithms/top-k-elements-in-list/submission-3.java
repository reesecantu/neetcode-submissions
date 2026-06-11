class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // hashmap, number -> count             O(n)
        // put numbers in to frequency table    O(n)
        // scan through the top k elements freq O(n)

        // get counts
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // add number to it's count bucket
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        //initialize each index with a list
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<Integer>();
        }
        // build buckets
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] topKElements = new int[k];
        int index = 0;
        for (int i = nums.length; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                topKElements[index] = n;
                index++;
                if (index == k) {
                    return topKElements;
                }
            }
        }

        return topKElements;



    }
}
