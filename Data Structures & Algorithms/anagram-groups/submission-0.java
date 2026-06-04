class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                map.put(sorted, new ArrayList<>(Arrays.asList(str)));
            }
        }

        return new ArrayList<>(map.values());
    }
}
