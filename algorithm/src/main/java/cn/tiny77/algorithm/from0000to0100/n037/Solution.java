package cn.tiny77.algorithm.from0000to0100.n037;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        char[] c = new char[1];
        System.out.printf(c[0] + "");
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(display(board));
        new Solution().solveSudoku(board);
        System.out.println(display(board));
    }

    public static String display(char[][] board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 9; i ++) {
            stringBuilder.append("\n");
            for (int j = 0; j < 9; j ++) {
                stringBuilder.append(board[i][j]).append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void solveSudoku(char[][] board) {
        List<Integer> iN = new ArrayList<>(81);
        List<Integer> jN = new ArrayList<>(81);
        int[][] map = new int[30][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    int value = board[i][j] - '1';
                    int p0 = i;
                    int p1 = 10 + j;
                    int p2 = j / 3 * 3 + i / 3 + 20;
                    map[p0][value] = 1;
                    map[p1][value] = 1;
                    map[p2][value] = 1;
                } else {
                    iN.add(i);
                    jN.add(j);
                }
            }
        }
        char[] ipt = new char[iN.size()];
        int pos = 0;
        while (pos < iN.size()) {
            int i = iN.get(pos);
            int j = jN.get(pos);
            int p0 = i;
            int p1 = 10 + j;
            int p2 = j / 3 * 3 + i / 3 + 20;
            boolean flag = false;
            for (int v = 0; v < 9; v++) {
                if (map[p0][v] == 0 && map[p1][v] == 0 && map[p2][v] == 0) {
                    ipt[pos] = (char) ('1' + v);
                    board[i][j] = ipt[pos];
                    map[p0][v] = 1;
                    map[p1][v] = 1;
                    map[p2][v] = 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                boolean flag2 = true;
                while(flag2) {
                    pos -= 1;
                    i = iN.get(pos);
                    j = jN.get(pos);
                    p0 = i;
                    p1 = 10 + j;
                    p2 = j / 3 * 3 + i / 3 + 20;
                    int v = ipt[pos] - '1';
                    map[p0][v] = 0;
                    map[p1][v] = 0;
                    map[p2][v] = 0;
                    if (ipt[pos] != '9') {
                        for (v += 1; v < 9; v++) {
                            if (map[p0][v] == 0 && map[p1][v] == 0 && map[p2][v] == 0) {
                                ipt[pos] = (char) ('1' + v);
                                board[i][j] = ipt[pos];
                                map[p0][v] = 1;
                                map[p1][v] = 1;
                                map[p2][v] = 1;
                                flag2 = false;
                                break;
                            }
                        }
                    }
                }
            }
            pos ++;
        }
    }
}