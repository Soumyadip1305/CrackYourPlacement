class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int cnt=0;
        HashMap<String ,Integer>map=new HashMap<>();
        for (int i=0;i<n;i++){
            map.put(words[i],i);
        }

        for (int i = 0; i < n; i++) {
            String curr= words[i].charAt(1)+""+words[i].charAt(0);
           // System.out.println(curr);
            if (map.containsKey(curr)&&map.get(curr)>i){
                cnt++;
            }
        }
        return cnt;
    }
}