
class Solution {
    public int longestConsecutive(int[] nums) {
        
        // traverse array, compile a hashset
        // for the values, check if the previous number exists in the set
        // if it doesn't, start building a set and count its length, 
        
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        
        int count = 0;
        int max = 0;

        for (int num : numsSet) {
            // if its the start of a sequence
            if(!numsSet.contains(num-1)) {
                count = 1;
                int current = num + 1;
                while(numsSet.contains(current)) {
                    count++;
                    current++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
