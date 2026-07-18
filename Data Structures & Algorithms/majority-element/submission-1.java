class Solution {
    public int majorityElement(int[] nums) {
        //Boyer-Moore Voting Algorithm
        int res = nums[0], count = 0;
        for (int num : nums) {
            if(num == res) count++;
            else count--;

            if (count == 0) {
                res = num;
                count++;
            }
        }

        return res;
    }
}