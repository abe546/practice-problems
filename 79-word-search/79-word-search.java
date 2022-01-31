class Solution {
    private static final int[][] directions =
            {
                    {1, 0},
                    {0, 1},
                    {-1, 0},
                    {0, -1}
            };
    private boolean[][] ignore;

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0 && board.length != 0) {
            return false;
        }

        ignore = new boolean[board.length][board[0].length];

        Stack<List<Integer>> examine = new Stack();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<Integer> tmp = new LinkedList();
                    tmp.add(i);
                    tmp.add(j);
                    examine.push(tmp);
                }
            }
        }

        while (!examine.isEmpty()) {

            List<Integer> entry = examine.pop();
            int i = entry.get(0);
            int j = entry.get(1);

            if (explore(i, j, board, 0 + 1, word)) {
                return true;
            }


        }


        return false;
    }

    public boolean explore(int i, int j, char[][] board, int charIndex, String word) {

        if (charIndex >= word.length()) {
            return true;
        }

        if (ignore[i][j] == true) {
            return false;
        }

        //We will ignore any source/parent cells
        ignore[i][j] = true;

        boolean statement = false;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];


            if (x >= 0 && y >= 0 && y < board[0].length && x < board.length && board[x][y] == word.charAt(charIndex) && ignore[x][y] == false) {
                if (!statement) {
                    statement = explore(x, y, board, charIndex + 1, word);
                }

            }
        }

        //Undo ignore, as we should be able to examine this field again in the futre checks
        ignore[i][j] = false;

        return statement;

    }
}