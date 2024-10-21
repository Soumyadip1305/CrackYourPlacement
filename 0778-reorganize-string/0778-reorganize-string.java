class Solution {
        static class Pair{
        char ch;
        int cnt;
        Pair(char ch,int cnt){
            this.ch=ch;
            this.cnt=cnt;
        }
    }
    public String reorganizeString(String s) {
        int[]cnt=new int[26];
        for (char it:s.toCharArray()){
            cnt[it-'a']++;
        }
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((a,b)->Integer.compare(b.cnt,a.cnt));
        // I will store the freq of each character and set prev for not getting adj
        for (int i=0;i<26;i++){
            if (cnt[i]>0){
                pq.offer(new Pair((char) ('a'+i),cnt[i]));
            }
        }
        //System.out.println(pq.peek().cnt);
        char prev='*';
        StringBuilder sb=new StringBuilder();
        while (!pq.isEmpty()){
            Pair curr=pq.poll();
            char ch=curr.ch;
            if (prev!=ch){
                prev=ch;
                curr.cnt--;
                sb.append(ch);
                if (curr.cnt>0)pq.add(curr);
            }else {
                if (pq.isEmpty())return "";
                Pair curr2=pq.poll();
                char c=curr2.ch;
                prev=c;
                sb.append(c);
                curr2.cnt--;

                if (curr2.cnt>0)pq.add(curr2);
                pq.add(curr);
            }
        }
        //System.out.println(Arrays.toString(cnt));
        return sb.toString();
    }
}