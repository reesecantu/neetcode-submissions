class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        boolean extra = false;
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() % 2 == 1) extra = true;
            length += entry.getValue() / 2 * 2;
        }

        if (extra) length++;
        return length;
    }
}