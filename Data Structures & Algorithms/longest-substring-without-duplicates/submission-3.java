class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window 
        
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int maxL = 0;
        
        while (r < s.length()) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxL = Math.max(maxL, set.size());
            r++;
        }

        return maxL;

    }
}
