class Solution {
    static Map<Integer,List<Integer>>map;
    static void seive(int n){
        map=new HashMap<>();
        boolean[]isPrime=new boolean[n+1];
        for(int i=2;i<=n;i++)isPrime[i]=true;

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j]=false;
                }
            }
        }

        List<Integer> cur = new ArrayList<>();

        for(int i=1;i<=n;i++){
               map.put(i, new ArrayList<>(cur));
            if(isPrime[i]){
                cur.add(i);
            }
        }
    }
    public boolean primeSubOperation(int[] nums) {
        int maxi=Arrays.stream(nums).max().getAsInt();
        int n=nums.length;
        seive(maxi);

       // System.out.println(map);
        
        
        int prev=-1;

        

        for(int i=0;i<n;i++){

            List<Integer>curr=map.get(nums[i]);
            boolean flag=false;
            // if (curr == null) return false;
            
            //System.out.println(curr);
            for(int j=curr.size()-1;j>=0;j--){
                if(prev < nums[i]-curr.get(j)){
                    prev=nums[i]-curr.get(j);
                    flag=true;
                    break;
                }
            }
            
            if(!flag){
                if(nums[i] <= prev) return false;
                prev = nums[i];
            }
        }
        return true;
    }
}

/*

[5,8,3]
2 3 

prev=2


prev=-1
4,9,6,10   9-> 2 3 5 7  6-> 2 3 5

10-->  2 3 5 7
o(n)*log(log(n))

prev=1

prev<curr(9)-p(7)  2

prev=3
1 , 2, 3 , 5
*/