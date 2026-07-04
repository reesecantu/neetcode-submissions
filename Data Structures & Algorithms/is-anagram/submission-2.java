class Solution {
    public boolean isAnagram(String s, String t) {
        // can use sorting for O(nlogn)
        // use counts for O(n)

        if (s.length() != t.length()) return false;

        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int i : counts) {
            if (i != 0) return false;
        }
        return true;
    }
}
