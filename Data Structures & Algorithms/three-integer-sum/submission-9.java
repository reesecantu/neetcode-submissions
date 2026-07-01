class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // sort the array
        // for int i where num[i] != i - 1
            // use a two pointer two sum problem
            // if sum too big, r--
            // if sum too small, l++
            // if sum == 0, add the triplet to res, l++ until unique
        // return res
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && i < nums.length && nums[i - 1] == nums[i]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum > 0) r--;
                else if (sum < 0) l++;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && l < nums.length && nums[l] == nums[l - 1]) l++;
                }
            }

        }

        return res;
    }
}
