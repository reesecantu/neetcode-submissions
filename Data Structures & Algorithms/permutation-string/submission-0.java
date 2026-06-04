class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] counts = new int[26];
        
        // Build initial window
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']--;
            counts[s2.charAt(i) - 'a']++;
        }
        
        if (isAllZero(counts)) return true;
        
        // Slide window
        for (int right = s1.length(); right < s2.length(); right++) {
            int left = right - s1.length();
            counts[s2.charAt(right) - 'a']++;
            counts[s2.charAt(left) - 'a']--;
            if (isAllZero(counts)) return true;
        }
        
        return false;
    }
    
    private boolean isAllZero(int[] counts) {
        for (int num : counts) {
            if (num != 0) return false;
        }
        return true;
    }
}