package Daily;

import java.util.*;

public class MinimumTime{
    private final static int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    static int minimumTime(int[][] grid) {
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        boolean[][] visited = new boolean[m][n];

        pq.offer(new int[]{0, 0, 0}); // {current_time, row, col}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentTime = current[0], row = current[1], col = current[2];

            if (row == m - 1 && col == n - 1) {
                return currentTime;
            }

            if (visited[row][col]) continue;
            visited[row][col] = true;

            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n || visited[newRow][newCol]) {
                    continue;
                }

                int waitTime = ((grid[newRow][newCol] - currentTime) % 2 == 0) ? 1 : 0;
                int nextTime = Math.max(
                        grid[newRow][newCol] + waitTime,
                        currentTime + 1
                );

                pq.offer(new int[]{nextTime, newRow, newCol});
            }
        }

        return -1; // If the bottom-right cell is unreachable
    }

    private static boolean isValid(int newR, int newC, int[][] grid) {
        return newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,3,2},{5,1,2,5},{4,3,8,6}};
        System.out.println(minimumTime(grid));
    }

}
