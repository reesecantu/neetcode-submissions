class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len <= 1) {
            return len;
        }

        HashSet<Character> seen = new HashSet<>();
        int start = 0;
        int result = 1; 
        seen.add(s.charAt(0));
        for (int end = 1; end < len; end++) {
            while(seen.contains(s.charAt(end))) {
                seen.remove(s.charAt(start));
                start++;
            }  
            seen.add(s.charAt(end));
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
