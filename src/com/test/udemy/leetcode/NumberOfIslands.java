package com.test.udemy.leetcode;


/**
 * Leetcode - https://leetcode.com/problems/number-of-islands/
 *
 * This is solved using flood fill algorithm - We are using DFS approach here -
 * This solution is taken from here - https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
 *
 * Read abouth Flood fill - https://www.hackerearth.com/practice/algorithms/graphs/flood-fill-algorithm/tutorial/
 *
 * Also, read about the rest of the types of the solutions - i.e. DFS & BFS - https://leetcode.com/problems/number-of-islands/discuss/56338/Java-DFS-and-BFS-solution
 *
 * Read about and visualise DFS in matrix - https://stackoverflow.com/a/35754873
 * Read about and visualise BFS in matrix - https://algorithms.tutorialhorizon.com/breadth-first-search-bfs-in-2d-matrix-2d-array/
 *
 */
public class NumberOfIslands {
    int row;          // The height of the given grid
    int col;          // The width of the given grid
    char[][] orgGrid;     // The given grid, stored to reduce recursion memory usage

    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     *
     * This method approaches the problem as one of depth-first connected
     * components search
     * @param grid, the given grid.
     * @return the number of islands.
     */
    public int numIslands(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        orgGrid = grid;

        // Our count to return
        int islandCount = 0;

        // Dimensions of the given graph
        row = orgGrid.length;
        if (row == 0) return 0;
        col = orgGrid[0].length;

        // Iterate over the entire given grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (orgGrid[i][j] == '1') {
                    dfs(i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    /**
     * Marks the given site as visited, then checks adjacent sites.
     *
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     *
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     *
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(int i, int j) {
        // Check for invalid indices and for sites that aren't land
        if (i >= row || j >= col)
            return;
        if(i < 0 || j < 0)
            return;
        if(orgGrid[i][j] != '1')
            return;


        // Mark the site as visited
        orgGrid[i][j] = '0';

        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
