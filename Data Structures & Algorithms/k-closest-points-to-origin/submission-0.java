class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // iterate and put points in a distances map
        List<Pair<Double, int[]>> map = new ArrayList<>();
        
        for (int[] point : points) {
            double distance = Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
            map.add(new Pair<>(distance, point));
        }
        // sort by distance
        Collections.sort(map, (a, b) -> Double.compare(a.getKey(), b.getKey()));
        // return the first k
        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = map.get(i).getValue();
        }
        return result;
    }
}
