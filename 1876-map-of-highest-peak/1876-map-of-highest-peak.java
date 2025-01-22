class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int M = isWater.length, N = isWater[0].length;

         int[][]vis = new int[M][N];
         int[] d = {0, 1, 0, -1, 0};

         Queue<int[]>q = new LinkedList<>();

         for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(isWater[i][j] == 1){
                    vis[i][j] = 1;
                    isWater[i][j] = 0;
                    q.offer(new int[]{0, i , j });
                }

            }
         }

         while(!q.isEmpty()){
            int []t = q.poll();

            for(int i = 0; i < 4; i++){
                int nrow = t[1] + d[i];
                int ncol = t[2] + d[i + 1];

                if(isValid(nrow, ncol, M, N) && vis[nrow][ncol] == 0){

                    vis[nrow][ncol] = 1;

                    isWater[nrow][ncol] = t[0] + 1;

                    q.offer(new int[]{t[0] + 1, nrow, ncol});
                }
            }

         }

         return isWater;


    }

    boolean isValid(int r, int c, int M, int N){
        return (r < 0 || c < 0 || r == M || c == N ) ? false : true;
    }
}