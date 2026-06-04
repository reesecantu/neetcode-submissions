class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] right = new int[length];
        int[] left = new int[length];
        int[] result = new int[length];

        // build left array
        int productSoFar = 1;
        for (int i = 0; i < length; i++) {
            left[i] = productSoFar;
            productSoFar *= nums[i];
        }

        // build right array
        productSoFar = 1;
        for (int i = length - 1; i >= 0; i--) {
            right[i] = productSoFar;
            productSoFar *= nums[i];
        }

        for (int i = 0; i < length; i++) {
            result[i] = right[i] * left[i];
        }

        return result;
        
    }
}  
