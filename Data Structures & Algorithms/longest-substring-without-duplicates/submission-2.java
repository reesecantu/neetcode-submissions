class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window 
        
        HashMap<Character, Integer> counts = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxL = 0;
        
        while (r < s.length()) {
            counts.put(s.charAt(r), counts.getOrDefault(s.charAt(r), 0) + 1);
            boolean unique = true;
            for (int count : counts.values()) {
                if (count > 1) {
                    unique = false;
                    break;
                }
            }
            if (unique)
                maxL = Math.max(maxL, r - l + 1);
            else {
                counts.put(s.charAt(l), counts.get(s.charAt(l)) - 1);
                l++;
            }
            r++;
        }

        return maxL;

    }
}
