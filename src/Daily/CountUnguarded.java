package Daily;

import java.util.*;

public class CountUnguarded {
    private static final int UNGUARDED = 0;
    private static final int GUARDED = 1;
    private static final int GUARD = 2;
    private static final int WALL =3;
    static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for(int[] guard : guards ) {
            grid[guard[0]][guard[1]] = GUARD;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            markguarded(guard[0], guard[1], grid);
        }
        int ans=0;
        for (int[] row : grid) {
            for(int cell : row) {
                if(cell == UNGUARDED) ans++;
            }
        }
        return ans;
    }

    static void markguarded(int row, int col, int[][] grid) {
//        mark quarded by guard position (row,col)
        //        Upwards
        for (int r = row-1; r >=0 ; r--) {
            if(grid[r][col] == WALL || grid[r][col] == GUARD ) break;
            grid[r][col] = GUARDED;
        }
//        Downwards
        for (int r = row+1; r < grid.length; r++) {
            if(grid[r][col] == WALL || grid[r][col] == GUARD ) break;
            grid[r][col] = GUARDED;
        }
//          Leftwards
        for (int c = col-1; c >=0 ; c--) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
            grid[row][c] = GUARDED;
        }
        for (int c = col+1; c <grid[0].length ; c++) {
            if (grid[row][c] == WALL || grid[row][c] == GUARD) break;
            grid[row][c] = GUARDED;
        }
    }

    public static void main(String[] args) {
        int[][] guards= {{0,0},{1,1},{2,3}};
        int[][] walls= {{0,1}, {2,2},{1,4}};
        System.out.println(countUnguarded(4,6,guards,walls));
    }
}
