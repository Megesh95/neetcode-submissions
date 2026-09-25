class Solution {
    class Pair {
        int u, v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            int s=q.size();
            for (int i = 0; i < s; i++) {
                Pair node = q.poll();
                int u = node.u;
                int v = node.v;

                for (int k = 0; k < 4; k++) {
                    int nr = u + dr[k];
                    int nc = v + dc[k];
                    if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length
                        && grid[nr][nc] != -1 && vis[nr][nc] == 0) {
                        vis[nr][nc] = 1;
                        q.offer(new Pair(nr, nc));
                        grid[nr][nc] = Math.min(grid[nr][nc], step + 1);
                    }
                }
            }
            step++;
        }
    }
}
