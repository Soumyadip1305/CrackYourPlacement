class Solution {
    static int[]d = {0, 1, 0, -1, 0};

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int[][]mat = new int[n*3][n*3];
        
        int len = n * 3,count = 0,last = -999;

        for(int i = 0; i < len; i+=3){

      

             for(int cur = 0; cur < n; cur++ ){

                 char ch = grid[i/3].charAt(cur);

                 if( ch == ' ' ) {
                    continue;
                 } 
                    

                 if(ch == '/'){
                    mat[i][ (cur * 3 ) +  2] = 1;
                    mat[i  + 1][(cur * 3 ) +  1] = 1;
                    mat[i + 2][(cur * 3 )  ] = 1;
           
                 }
                 else{
 
                    mat[i][(cur * 3 ) ] = 1;
                    mat[i+1][(cur * 3 ) + 1] =1;
                    mat[i + 2][(cur * 3 )  + 2] =1;

                 }


             }
        }
       

        //calculating regions

        for(int i = 0; i < len; i++){
            for(int j = 0; j < len ;j++){
                if(mat[i][ j] == 0 && exploreAll(i, j, mat) == 1){
                    count ++;
                }
            }
        }

     

        return count;

    }

    int exploreAll(int r, int c, int[][]mat){
      
       int n = mat.length;

       if( r < 0 || c < 0 || r == n || c== n || mat[r][c] == 1) return 1;
        
       mat[r][c] = 1;

       int res= 1;

       for(int i = 0; i < 4; i ++){
         res &= exploreAll(r + d[i] , c + d[i + 1], mat);
       }

       return res;

    }

    // void display(int[][]grid){
    //     int n = grid.length;

    //     for(int i = 0;i<n;i++){
    //         for(int j = 0; j < n;j++){
    //             System.out.print(grid[i][ j] + " ");
    //         }
    //         System.out.println();
    //     }
    // }
}