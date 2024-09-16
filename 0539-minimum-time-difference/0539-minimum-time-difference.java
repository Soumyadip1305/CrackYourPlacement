class Solution {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size(); i++) {
            mini = Math.min(mini, get(timePoints.get(i)) - get(timePoints.get(i - 1)));
        }
        int cirDiff = 1440 - get(timePoints.get(timePoints.size() - 1)) + get(timePoints.get(0));
        mini = Math.min(mini, cirDiff);

        return mini;
    }

    private static int get(String s) {
        String[] sb = s.split(":");
        int hours = Integer.parseInt(sb[0]);
        return Integer.parseInt(sb[1]) + hours * 60;
    }
}