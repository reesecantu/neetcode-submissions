class Solution {
    public String minWindow(String s, String t) {
        // counts HashMap<Character, Integer>
        // valid window: counts of window are at least t

        if(t.isEmpty() || s.length() < t.length()) return "";

        HashMap<Character, Integer> freqT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }

        // build initial window
        for (int i = 0; i < t.length(); i++) {
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c, 0) + 1);
        }

        if (validWindow(freqT, window)) return (s.substring(0, t.length()));

        int left = 0;
        String result = null;
        for (int right = t.length(); right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (validWindow(freqT, window)) {
                if(result == null || result.length() > right - left) {
                    result = s.substring(left, right + 1);
                }
                window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                left++;
            }
        }
        if (result == null) result = "";
        return result;
    }
    private boolean validWindow(HashMap<Character, Integer> freqT, HashMap<Character, Integer> window) {
        for (Character c : freqT.keySet()) {
            if (window.getOrDefault(c, 0) < freqT.get(c)) {
                return false;
            }
        }
        return true;
    }
}
