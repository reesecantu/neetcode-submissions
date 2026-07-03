class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window 
        
        HashMap<Character, Integer> set = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxL = 0;
        
        while (r < s.length()) {
            if(set.containsKey(s.charAt(r))) {
                l = Math.max(set.get(s.charAt(r)) + 1, l);
            }
            set.put(s.charAt(r), r);
            maxL = Math.max(maxL, r - l + 1);
            r++;
        }

        return maxL;

    }
}
