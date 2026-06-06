class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // is anagram
            // same size?
            // array
        // output list initially empty
        // for each string in strs, cycle through existing groups in output list
            // if match, add to list
            // if the string doesn't belong to any, make a new list

        List<List<String>> output = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            boolean found = false;
            String currentString = strs[i];
            for (int j = 0; j < output.size(); j++) {
                List<String> currentGroup = output.get(j);
                if (isAnagram(currentGroup.get(0), currentString)) {
                    output.get(j).add(currentString);
                    found = true;
                    break;
                }
            }

            if (!found) {
                ArrayList<String> ret = new ArrayList<>();
                ret.add(currentString);
                output.add(ret);
            }
        }
        return output;
    }

    private boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counts = new int[26];
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i] - 'a']++;
            counts[arr2[i] - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
