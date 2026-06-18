class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // frequency O(n)
        // +
        // place frequencies into bucket O(n)
        // bucket sort, where bucket = freq, bounded by nums.length
        // O(n)
        // return the top k elements

        // number, count
        Map<Integer, Integer> counts = new HashMap<>();
        
        for (int num : nums) { 
            counts.put(num, counts.getOrDefault(num, 0) + 1); 
        }

        ArrayList<Integer>[] frequency = new ArrayList[nums.length + 1];
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            // add the entry's key to the array list at frequency[value]
            frequency[entry.getValue()].add(entry.getKey());
        }

        int[] topK = new int[k];
        int index = 0;
        for (int i = frequency.length - 1; i > 0 && index <= k; i--) {
            // starting at the largest frequency bucket, add all the elements 
            for (Integer n : frequency[i]) {
                topK[index] = n;
                index++;
                if (index == k) {
                    return topK;
                }
            }
        }

        return topK;

    }
}
