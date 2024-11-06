class Solution {
    public boolean canSortArray(int[] nums) {
          Map<Integer, Integer> calM = createBinaryCountMap(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty()) {
                list.add(num);
            } else {
                List<Integer> qu = new ArrayList<>();
                while (!list.isEmpty() && list.get(list.size() - 1) > num && calM.get(list.get(list.size() - 1)).equals(calM.get(num))) {
                    int x = list.get(list.size() - 1);
                    list.remove(list.size() - 1);
                    qu.add(x);
                }
                list.add(num);
                while (!qu.isEmpty()) {
                    int x = qu.get(qu.size() - 1);
                    qu.remove(qu.size() - 1);
                    list.add(x);
                }
            }
        }
        Arrays.sort(nums);
        return Arrays.equals(nums, list.stream().mapToInt(Integer::intValue).toArray()) && nums.length == list.size();
    }
 public static Map<Integer, Integer> createBinaryCountMap(int[] nums) {
        Map<Integer, Integer> calM = new HashMap<>();
        for (int i : nums) {
            int cnt = 0;
            for (char bit : Integer.toBinaryString(i).replace(' ', '0').toCharArray()) {
                if (bit == '1') {
                    cnt += 1;
                }
            }
            calM.put(i, cnt);
        }
        return calM;
    }
    
}