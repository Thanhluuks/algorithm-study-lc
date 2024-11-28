package Daily;

import java.util.*;

public class MinimumObstacles {
    static int[][] directions = new int[][] {{0,1},{1,0}, {-1,0}, {0,-1}};
    static int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] minCost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }
        minCost[0][0] = 0;
        queue.add(new int[]{minCost[0][0], 0, 0});
        while (!queue.isEmpty()) {
            int[] cel = queue.poll();
            int cost = cel[0];
            int r = cel[1];
            int c = cel[2];
            if (r == m-1 && c == n-1) {
                return cost;
            }
            for(int[] direct: directions ) {
                int newR = r + direct[0];
                int newC = c + direct[1];
                if(isValid(grid,newR,newC) && minCost[newR][newC] == Integer.MAX_VALUE) {
                    minCost[newR][newC] = cost + grid[newR][newC];
                    int[] newCell = new int[] {minCost[newR][newC],newR, newC};
                    if (grid[newR][newC] == 0) {
                        queue.addFirst(newCell);
                    } else queue.addLast(newCell);
                }
            }
        }

        return minCost[m-1][n-1];
    }
    static boolean isValid(int[][] grid, int r, int c) {
        return (r >= 0 && c >= 0 && r < grid.length && c <grid[0].length);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{0,1,1},{1,1,0},{1,1,0}};
        System.out.println(minimumObstacles(grid));
    }
}
