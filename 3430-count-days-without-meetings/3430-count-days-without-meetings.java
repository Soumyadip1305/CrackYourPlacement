class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> mergedIntervals = new ArrayList<>();

        mergeMeetings(meetings, mergedIntervals);

        return calculateFreeDays(days, mergedIntervals);
    }

    private static void mergeMeetings(int[][] meetings, ArrayList<int[]> mergedIntervals) {
        int start = meetings[0][0];
        int end = meetings[0][1];
        int earliestStart = start;

        for (int i = 1; i < meetings.length; i++) {
            int currentStart = meetings[i][0];
            int currentEnd = meetings[i][1];

            if (currentStart > end) {
                mergedIntervals.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            } else {
                start = Math.min(start, currentStart);
                end = Math.max(end, currentEnd);
            }
            earliestStart = Math.min(currentStart, earliestStart);
        }
        mergedIntervals.add(new int[]{start, end});
    }

    private static int calculateFreeDays(int totalDays, ArrayList<int[]> mergedIntervals) {
        int freeDays = 0;
        int earliestStart = mergedIntervals.get(0)[0];
        int lastMeetingEnd = mergedIntervals.get(mergedIntervals.size() - 1)[1];

        for (int i = 1; i < mergedIntervals.size(); i++) {
            int gap = mergedIntervals.get(i)[0] - mergedIntervals.get(i - 1)[1] - 1;
            freeDays += Math.max(0, gap);
        }

        freeDays += (earliestStart - 1);
        freeDays += (totalDays - lastMeetingEnd);

        return freeDays;
    }
}