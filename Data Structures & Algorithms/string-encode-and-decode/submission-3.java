class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str.length());
            result.append("#");
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> result = new ArrayList<>();
        while (index < str.length()) {
            int delimIndex = str.indexOf("#", index);
            int length = Integer.parseInt(str.substring(index, delimIndex));
            result.add(str.substring(delimIndex + 1, delimIndex + 1 + length));
            index = delimIndex + 1 + length;
        }
        return result;
    }
}