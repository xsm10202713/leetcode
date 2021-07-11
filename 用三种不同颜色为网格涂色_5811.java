/**
 * 用三种不同颜色为网格涂色_5811
 */
public class 用三种不同颜色为网格涂色_5811 {

    /*
 * @lc app=leetcode.cn id=5811 lang=java
 *
 * [5811] 用三种不同颜色为网格涂色
 */

// @lc code=start
class Solution {
    public int colorTheGrid(int m, int n) {
        double[][][] res = new double[m][n][3];
        double sum = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    for (int k = 0; k < 3; k++) {
                        res[i][j][k] = 1 / 3;
                    }
                }
                if (i == 0 && j != 0) {
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            if (k != h) {
                                res[i][j][k] = res[i][j][k] + res[i][j - 1][h] * 0.5;
                            }
                        }
                    }
                }
                if (i == 0 && j != 0) {
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            if (k != h) {
                                res[i][j][k] = res[i][j][k] + res[i][j - 1][h] * 0.5;
                            }
                        }
                    }
                }
                if (i != 0 && j == 0) {
                    for (int k = 0; k< 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            if (k != h) {
                                res[i][j][k] = res[i][j][k] + res[i - 1][j][h] * 0.5;
                            }
                        }
                    }
                }
                if (i == 0 && j != 0) {
                    for (int k = 0;k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            if (k != h) {
                                res[i][j][k] = res[i][j][k] + res[i][j - 1][h] * 0.5;
                            }
                        }
                    }
                }
                if (i != 0 && j != 0) {
                    res[i][j][0] = res[i - 1][j][1] * res[i][j - 1][2] + res[i - 1][j][2] * res[i][j - 1][1];
                    res[i][j][1] = res[i - 1][j][0] * res[i][j - 1][2] + res[i - 1][j][2] * res[i][j - 1][0];
                    res[i][j][2] = res[i - 1][j][1] * res[i][j - 1][0] + res[i - 1][j][0] * res[i][j - 1][1];
                    for (int k = 0; k< 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            if (k != h) {
                                res[i][j][k] = res[i][j][k] + res[i - 1][j][h] * res[i][j - 1][h] * 0.5;
                            }
                        }
                    }
                }
                sum = sum * (res[i][j][0] + res[i][j][1] + res[i][j][2]);

            }
        }
        return (int) sum;
    }
}
// @lc code=end

}