class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows table of sets
        Set<Character>[] rows = new HashSet[9];
        // cols table of sets
        Set<Character>[] cols = new HashSet[9];
        // squares table of sets
        Set<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Character>();
            cols[i] = new HashSet<Character>();
            squares[i] = new HashSet<Character>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];
                if(rows[row].contains(c) 
                || cols[col].contains(c) 
                || squares[(row / 3) * 3 + (col / 3)].contains(c)) {
                    return false;
                }

                if(Character.isDigit(c)) {
                    rows[row].add(c);
                    cols[col].add(c);
                    squares[(row / 3) * 3 + (col / 3)].add(c);
                }
            }
        }

        return true;
    }
}
