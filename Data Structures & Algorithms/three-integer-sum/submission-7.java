class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // no duplicate triplets
        // if I store triplets as HashSets, duplicates will be auto handled

        // for each unique digit NUM in nums, run every 
        // twosum with NUM * -1 as the target
        HashSet<List<Integer>> result = new HashSet<>();
        // set of starting digits seen
        Set<Integer> seen1 = new HashSet<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length -2; i++) {
        // from left to right, have I used this digit as a starting digit before?
            int current = nums[i];
            // if yes, skip 
            if (!seen1.contains(current)){
            // if no, run twosum starting after the current number
                int target = current * -1;
                seen1.add(current);
                List<Integer> triple = new ArrayList<>();
                triple.add(current);
                // complements
                Set<Integer> seen2 = new HashSet<>();

                // create a seenBefore set
                Set<Integer> added = new HashSet<>();
                for (int j = i + 1; j < nums.length; j++) {
                    // if !seenBefore & hasComplement
                    if(!added.contains(nums[j]) && seen2.contains(target - nums[j])) {
                        // add to return list
                        triple.add(nums[j]);
                        triple.add(target - nums[j]);
                        result.add(triple);
                        triple = new ArrayList<>();
                        triple.add(current);
                        
                        // and add this number and complement to seen before
                        added.add(nums[j]);
                        added.add(target - nums[j]);
                    }
                    seen2.add(nums[j]);
                }
            }
        }                
        // return result
        return new ArrayList<>(result);
    }
}
