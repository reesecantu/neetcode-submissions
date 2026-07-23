class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 0 overlap, trivial
        // 1 overlap, min(start1, start2), max(end1, end2)
        // 2+ overlaps, min(start_of_first, start_of_new), max(end_of_last, ...)

        // first, end_new < start1

        List<int[]> result = new ArrayList<>();
        boolean done = false;

        for (int[] curr : intervals) {
            if (curr[1] < newInterval[0] || done) {
                result.add(curr);
            } else if (newInterval[1] < curr[0]) {
                done = true;
                result.add(newInterval);
                result.add(curr);
            } else {
                newInterval = new int[]{Math.min(newInterval[0], curr[0]),
                                        Math.max(newInterval[1], curr[1])};
            }
        }
        if (!done) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][]);
    }
}
