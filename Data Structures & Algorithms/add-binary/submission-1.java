class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        int bitA = 0;
        int bitB = 0;

        StringBuilder result = new StringBuilder();

        while (idxA >= 0 || idxB >= 0 || carry == 1) {
            int sum = carry;
            if (idxA >= 0) {
                sum += a.charAt(idxA) - '0';
                idxA--;
            }
            
            if (idxB >= 0) {
                sum += b.charAt(idxB) - '0';
                idxB--;
            }

            result.append(sum % 2);
            
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}