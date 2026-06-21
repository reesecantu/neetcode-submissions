class Solution {
    public int longestConsecutive(int[] nums) {
        
        // goal, identify the start of a chain and count length
        // keep running maximum
        
        // method, convert to hashset
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int maxLength = 0;

        for (int num : nums) {
            if (!numsSet.contains(num - 1)) {
                int currentLength = 0;
                int curr = num;
                while(numsSet.contains(curr)) {
                    currentLength++;
                    curr++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;

    }
}
