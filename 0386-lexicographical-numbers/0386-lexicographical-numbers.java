class Solution {
    public List<Integer> lexicalOrder(int n) {
         List<Integer> res = new ArrayList<>();

       String s = String.valueOf(n);
       int len = s.length();

       for(int i = 1; i <=9; i++ ){
           add(res,String.valueOf(i),n);
       } 

       return res;

    }

    void add(List<Integer> res, String s,int n){
     
         int cur = Integer.parseInt(s);

         if(cur > n) return ;

         res.add(cur);

        for(int i = 0; i <= 9; i++){
            add(res, s + String.valueOf(i),n);
        }
    }
}