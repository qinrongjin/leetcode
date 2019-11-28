package cn.tiny77.algorithm.h01.t40.n036;

class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] map = new int[30][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    int pos = j / 3 * 3 + i / 3;
                    if (map[i][value] == 1 || map[10 + j][value] == 1 || map[20 + pos][value] == 1) {
                        return false;
                    } else {
                        map[i][value] = 1;
                        map[10 + j][value] = 1;
                        map[20 + pos][value] = 1;
                    }
                }
            }
        }
        return true;
    }

}