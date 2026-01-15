class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int[]hxHy=longestConsecutive(hBars);
        int[]vxVy=longestConsecutive(vBars);

        int mini=Math.min(hxHy[1]-hxHy[0]+2,vxVy[1]-vxVy[0]+2);
       // System.out.println(mini);
        return mini*mini;

    }
    public static int[] longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int it : nums) set.add(it);

        int maxLen = 0;
        int x = 0, y = 0;

        for (int it : set) {
            if (!set.contains(it - 1)) {
                int curr = it;
                while (set.contains(curr)) curr++;

                int len = curr - it;
                if (len > maxLen) {
                    maxLen = len;
                    x = it;
                    y = curr - 1;
                }
            }
        }
        return new int[]{x, y};
    }

    
}