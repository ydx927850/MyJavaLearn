package algorithm.graphProblem;

import sun.java2d.windows.GDIRenderer;

/**
 * 岛屿数量
 */
public class NumsIslands {
    public int numIslands(char[][] grid){
        //遍历整个图，如果发现一个点为陆地，那么就以此为根进行感染，将四周的岛屿都访问
        int count = 0;
        if(grid.length==0){
            return count;
        }
        int row = grid.length;
        int column = grid[0].length;
        char[][] visit = new char[row][column];
        for(int i=0;i<row;i++){
            for (int j=0;j<column;j++){
                if(visit[i][j] != '1' && grid[i][j] == '1' ){
                    //没有访问过并且是陆地，第一次给计数加1
                    count++;
                    //将和这个陆地相邻的都访问
                    FS(grid,visit,i,j);
                }
            }
        }
        return count;
    }

    private void FS(char[][] grid, char[][] visit, int i, int j) {
        if (i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1){
            return;
        }
        if(grid[i][j] == '0'){
            //发现是海洋就直接返回
            return;
        }
        if(visit[i][j] == '1'){
            //访问过了也直接返回
            return;
        }
        //没有访问过
        visit[i][j] = '1';
        FS(grid,visit,i+1,j);
        FS(grid,visit,i,j+1);
        FS(grid,visit,i-1,j);
        FS(grid,visit,i,j-1);
    }
}
