class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // recursive
        // change x,y
        // for each neighbor is in bounds that matches original color 
        // flood fill.
        // if already target color, do nothing

        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        // update cell
        image[sr][sc] = color;
        // 
        if (sr - 1 >= 0 && image[sr - 1][sc] == originalColor) {
            image = floodFill (image, sr - 1, sc, color);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == originalColor) {
            image = floodFill (image, sr + 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == originalColor) {
            image = floodFill (image, sr, sc - 1, color);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == originalColor) {
            image = floodFill (image, sr, sc + 1, color);
        }

        return image;
    }
}