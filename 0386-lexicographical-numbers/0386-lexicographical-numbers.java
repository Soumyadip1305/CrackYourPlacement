class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer>list=new ArrayList<>();

        for(int i = 1; i <=9; i++ ){
            add(list,String.valueOf(i),n);
        }

        return list;
    }

    private void add(List<Integer> list, String s, int n) {
        int cur = Integer.parseInt(s);
        if(cur > n) return ;
        list.add(cur);

        for (int i = 0; i <=9; i++) {
            add(list,s+String.valueOf(i),n);
    }
}
}