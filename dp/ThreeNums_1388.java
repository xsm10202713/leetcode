package dp;

public class ThreeNums_1388 {
    public static void main(String[] args) {
        System.out.println(new ThreeNums_1388().maxSizeSlices(new int[] { 1, 2, 3, 4, 5, 6 }));
    }

    public int maxSizeSlices(int[] nums) {


        int[][][] dp = new int[nums.length / 3 + 1][nums.length][4];
        for (int i = 1; i <= nums.length / 3; i++) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j -1>i) {
                    dp[i][j][0] = Math.max(dp[i][j - 1][2], dp[i][j - 1][0]);
                    dp[i][j][1] = Math.max(dp[i][j - 1][1], dp[i][j - 1][3]);
                }else{
                    dp[i][j][0] = 0;
                }
           
                if ((j + 1) == i * 2) {
                    dp[i][j][1] = a;
                }
                if (j > 2 * i - 2) {
                    dp[i][j][2] = i > 0 ? dp[i - 1][j - 1][0] : 0 + nums[j];
                }
                if ((j + 1) > 2 * i - 2) {
                    dp[i][j][3] = i > 0 && j > 0 ? dp[i - 1][j - 1][1] : 0 + nums[j];
                }
                if (j == i * 2 - 2) {
                    dp[i][j][2] = b + nums[j];
                }
                if ((j + 1) == 2 * i - 2) {
                    dp[i][j][3] = a + b + nums[j];
                }
                for (int k = 0; k <= 3; k++) {
                    if (i != 0 && k == 0 && i == 1) {
                        System.out.println(dp[i][j][k]);
                    }
                }
                if (j % 2 == 0) {
                    a = a + nums[j];
                } else {
                    b = b + nums[j];
                }
            }
        }
        int max = Math.max(dp[nums.length / 3][nums.length - 1][0], dp[nums.length / 3 - 1][nums.length - 1][1]);
        return Math.max(dp[nums.length / 3][nums.length - 1][2], max);
    }

}
