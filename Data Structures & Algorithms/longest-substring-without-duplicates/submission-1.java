class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int start = 0;
        int result = 0;
         
        for (int end = 0; end < s.length(); end++) {
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
