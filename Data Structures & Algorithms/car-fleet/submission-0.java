class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][];
        for (int i = 0; i < position.length; i++) {
            pair[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double currentFleetMaxTime = 0.0;
        for (int i = 0; i < pair.length; i++) {
           double time = (target - pair[i][0]) / (double) pair[i][1];
           if (time > currentFleetMaxTime) {
            fleets++;
            currentFleetMaxTime = time;
           }

        }
        return fleets;
    }
}