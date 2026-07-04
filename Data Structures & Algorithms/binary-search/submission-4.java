class Solution {
    public int search(int[] nums, int target) {
        // maintaining a high and low pointer.
        // check the index in the middle of those pointer
            // if too high, then high = mid - 1
            // if too low, then low = mid + 1
            // if target, yay!
            // if low > high
        
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else return mid;
        }

        return -1;
    }
}
