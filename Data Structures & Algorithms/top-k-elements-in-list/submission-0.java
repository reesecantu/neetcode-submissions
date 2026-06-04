class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        // count all the integers
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // Build the frequency arrays from counts
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        // build result array from frequencies
        int[] result = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int val : freq[i]) {
                result[index] = val;
                index++;
                if(index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
