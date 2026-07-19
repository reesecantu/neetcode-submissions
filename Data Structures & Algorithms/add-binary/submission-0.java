class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        int i1 = 0;
        int i2 = 0;

        StringBuilder result = new StringBuilder();

        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0) i1 = '1' == a.charAt(p1) ? 1 : 0;
            else i1 = 0;
            
            if (p2 >= 0) i2 = '1' == b.charAt(p2) ? 1 : 0;
            else i2 = 0;

            int sum = i1 + i2 + carry;
            if (sum % 2 == 1) result.insert(0, 1);
            else result.insert(0, 0);
            
            if (sum > 1) carry = 1;
            else carry = 0;

            p1--;
            p2--;
        }
        if (carry == 1) result.insert(0, 1);

        return result.toString();
    }
}