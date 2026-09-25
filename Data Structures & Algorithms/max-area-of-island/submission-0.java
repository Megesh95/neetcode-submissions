class Solution {
    class Pair{
        int u,v;
        Pair(int u,int v){
            this.u=u;
            this.v=v;
        }
    }

    int bfs(int[][] grid,int i,int j,int[][]vis){
        int cnt=1;
        vis[i][j]=1;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(i,j));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};

        while(!q.isEmpty()){
            Pair p=q.poll();
            int u=p.u;
            int v=p.v;
            for(int k=0;k<4;k++){
                int nr=u+dr[k];
                int nc=v+dc[k];
                if(nr>=0&&nc>=0&&nr<grid.length&&nc<grid[0].length&&grid[nr][nc]==1&&vis[nr][nc]==0){
                    vis[nr][nc]=1;
                    q.offer(new Pair(nr,nc));
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&vis[i][j]==0){
                    int mx=bfs(grid,i,j,vis);
                    cnt=Math.max(cnt,mx);
                }
            }
        }
        return cnt;
    }
}
