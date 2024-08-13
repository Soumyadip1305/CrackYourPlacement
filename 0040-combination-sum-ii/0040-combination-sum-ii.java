class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       Set<List<Integer>>ans=new HashSet<>();
        Arrays.sort(candidates);
        solve(0,candidates,target,ans,new ArrayList<>());
        return new ArrayList<>(ans);
    }

    private static void solve(int ind, int[] candidates, int target, Set<List<Integer>> ans,List<Integer>list) {
        if (ind==candidates.length){
            if (target==0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        // pick
        if (target>=candidates[ind]){
            list.add(candidates[ind]);
            solve(ind+1,candidates,target-candidates[ind],ans,list);
            list.remove(list.size() - 1);
        }
        while (ind + 1 < candidates.length && candidates[ind] == candidates[ind + 1]) {
        ind++;
    }
        // not pick
        solve(ind+1,candidates,target,ans,list);  
    }
}