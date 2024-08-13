class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      /* Set<List<Integer>>ans=new HashSet<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ans,new ArrayList<>());
        return new ArrayList<>(ans);*/
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void solve(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = ind; i < candidates.length; i++) {
            if (i > ind && candidates[i] == candidates[i - 1]) {
                continue; // skip duplicates
            }
            if (candidates[i] > target) {
                break; // no need to continue if the current candidate exceeds the target
            }
            list.add(candidates[i]);
            solve(i + 1, candidates, target - candidates[i], ans, list);
            list.remove(list.size() - 1);
        }
//        // pick
//        if (target >= candidates[ind]) {
//            list.add(candidates[ind]);
//            solve(ind + 1, candidates, target - candidates[ind], ans, list);
//            list.remove(list.size() - 1);
//        }
//        // not pick
//        solve(ind + 1, candidates, target, ans, list);
    }
}