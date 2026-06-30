class Solution {
    public boolean isPalindrome(String s) {
        // brute force is copy and reverse the string
        // two pointers 
        int l = 0;
        int r = s.length() - 1;

        s.replaceAll("//s", "");

        while (l <= r) {
            while(l < s.length() && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (r >= 0 && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (l <= r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) return false;
            l++;
            r--;
        }

        return true;
    }
}
