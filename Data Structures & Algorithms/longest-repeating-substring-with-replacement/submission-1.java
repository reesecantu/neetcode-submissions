class Solution {
    public int characterReplacement(String s, int k) {
        // valid window 
            // at least len - k characters are the same

        // int[26] for counts

        // if valid, grow window
        // else, slide (decrement count for l, increment count for r)

        int[] freq = new int[26];
        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            boolean valid = false;
            for (int num : freq) {
                if (num >= right - left + 1 - k) {
                    valid = true;
                    break;
                }
            }
            if (!valid) {
                freq[s.charAt(left) - 'A']--;
                left++;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }
}
