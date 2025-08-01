class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1); // First element in each row is always 1

            for (int j = 1; j < i; j++) {
                List<Integer> prev = ans.get(i - 1);
                int num = prev.get(j - 1) + prev.get(j);
                row.add(num);
            }

            if (i > 0) {
                row.add(1); // Last element in each row is always 1, except for the first row
            }

            ans.add(row);
        }

        return ans; 
    }
}