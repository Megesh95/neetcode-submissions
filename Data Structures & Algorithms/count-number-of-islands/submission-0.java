class Solution {
    class Pair{
        int u,v;
        Pair(int u,int v){
            this.u=u;
            this.v=v;
        }
    }
    void bfs(char[][] grid,int i,int j,int[][]vis){
        vis[i][j]=1;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(i,j));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!q.isEmpty()){
            Pair n=q.poll();
            int u=n.u;
            int v=n.v;
            for(int idx=0;idx<4;idx++){
                int nr=u+dr[idx];
                int nc=v+dc[idx];
                if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]=='1'&&vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.offer(new Pair(nr,nc));
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        
        int[][] vis=new int[grid.length][grid[0].length];
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    cnt++;
                    bfs(grid,i,j,vis);
                }
            }
        }
        return cnt;
    }
}
