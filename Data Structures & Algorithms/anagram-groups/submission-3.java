class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use HashMap<counts, list> return the hashmap value list
        // go through each string, find its count, 
        // add new key if absent
        // if count exists, add to group
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (char c : str.toCharArray()) counts[c - 'a']++;
            String countsAsString = Arrays.toString(counts);
            groups.putIfAbsent(countsAsString, new ArrayList<String>());
            groups.get(countsAsString).add(str);
        }
        return new ArrayList<>(groups.values());

    }
}
