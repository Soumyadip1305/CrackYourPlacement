class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();
        String[] ans = new String[logs.length];

        for (String log : logs) {
            String[] curr = log.split(" ", 2);
            if (Character.isDigit(curr[1].charAt(0))) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        letter.sort((a, b) -> {
            String[] part1 = a.split(" ", 2);
            String[] part2 = b.split(" ", 2);
            int cmp = part1[1].compareTo(part2[1]);
            if (cmp != 0) {
                return cmp;
            }
            return part1[0].compareTo(part2[0]);
        });

        int ind = 0;
        for (String str : letter) {
            ans[ind++] = str;
        }

        for (String str : digit) {
            ans[ind++] = str;  // Maintain the original order of digit logs
        }

        return ans;
    }
}