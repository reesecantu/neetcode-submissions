class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int prev = Integer.MIN_VALUE;
        // for each number, find all triplets using that number
        for (int i = 0; i < nums.length; i++) {
            // if current number is the same as previous, continue
            int current = nums[i];
            if(prev != current) {
                prev = current;
                int target = 0 - current;
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == target) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1] && nums[r] == nums[r - 1]) {
                            if(l < nums.length - 1 && nums[l] == nums[l + 1]) l++;
                            if(i > 0 && nums[r] == nums[r - 1]) r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < target) {
                        while (l < nums.length - 1 && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                    } else if (nums[l] + nums[r] > target) {
                        while (i > 0 && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        return result;
    }
}
