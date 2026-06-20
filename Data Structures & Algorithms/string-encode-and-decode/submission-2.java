class Solution {


    // edge cases, empty array, empty string

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            int length = str.length();
            result.append(length);
            result.append("#");
            result.append(str);
        }
        return result.toString();
    }

    public List<String> decode(String str) {
        String lengthAsString;
        int index = 0;
        List<String> result = new ArrayList<String>();
        while (index < str.length()) {
            int bufferIndex = str.substring(index).indexOf("#") + index;
            lengthAsString = str.substring(index, bufferIndex);
            int lengthAsInt = Integer.parseInt(lengthAsString);
            result.add(str.substring(bufferIndex + 1, bufferIndex + 1 + lengthAsInt));
            index = bufferIndex + lengthAsInt + 1;
        }
        return result;
    }
}
