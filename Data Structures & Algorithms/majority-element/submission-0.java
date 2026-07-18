class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            int amount = counts.getOrDefault(num, 0);
            amount++;
            if (amount > length / 2) return num;
            else counts.put(num, amount);
        }

        return Integer.MAX_VALUE;
    }
}