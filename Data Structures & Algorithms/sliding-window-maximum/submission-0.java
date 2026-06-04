class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // max in window
            // if we slide past, we need to have the runner up (could be equal)
            // if we slide over a bigger number, thats the biggest


        // 1 1 1 1 2 2 1 1 1 1 
        // return array is nums.length - k + 1
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[nums.length - k + 1];
        // initial window
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        result[0] = maxHeap.peek();

        for (int right = k; right < nums.length; right++) {
            maxHeap.remove(nums[right-k]);
            maxHeap.offer(nums[right]);
            result[right - k + 1] = maxHeap.peek();
        }

        return result;
    }
}
