class Solution {

    private static final int[][] directions =
            { //row column
                    {0, 1},    // Move right in matrix
                    {0, -1},  // Move left in matrix
                    {1, 0},  // Move down in matrix
                    {-1, 0} // Move up in matrix
            };
    private int visited = 0;
    private boolean[][] ignore;

    public int orangesRotting(int[][] grid) {

        if (grid.length == 0) {
            return 0;
        }

        ignore = new boolean[grid.length][grid[0].length];

        int notEmpty = 0;

        Queue<List<List<Integer>>> queue = new LinkedBlockingQueue();

        scanArrayForAllRottenTomatoes(queue, grid);

        int days = 0;


        List<List<Integer>> indexes = new LinkedList();


        while (!queue.isEmpty()) {
            System.out.println("LIST OF LIST : " + queue.peek());
            indexes = new LinkedList();
            for (List<Integer> index : queue.poll()) {


                //Wipe list of indexes


                explore(index.get(0), index.get(1), grid, indexes);
            }
            System.out.println("LIST OF LIST 2 : " + indexes);

            if (!indexes.isEmpty()) {
                queue.add(indexes);
                days++;
            }

        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }


        return days;

    }

    public void explore(int i, int j, int[][] matrix, List<List<Integer>> indexes) {

        visited++;
        ignore[i][j] = true;

        System.out.println("I : " + i + " J : " + j + " grid : " + matrix[i][j]);

        for (int[] dir : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length
                    && matrix[x][y] == 1) {
                System.out.println("X : " + x + " Y : " + y + " grid : " + matrix[x][y]);
                matrix[x][y] = 2; //Convert to be rotten
                List<Integer> tmp = new LinkedList();
                tmp.add(x);
                tmp.add(y);

                indexes.add(tmp);
                System.out.println("INDEXES : " + indexes);
            }
        }
    }

    public void scanArrayForAllRottenTomatoes(Queue<List<List<Integer>>> queue,
                                              int[][] grid) {
        List<List<Integer>> indexes = new LinkedList();
        List<Integer> index = new LinkedList();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    index = new LinkedList();
                    index.add(i);
                    index.add(j);

                    indexes.add(index);
                }
            }
        }

        queue.add(indexes);
    }
}