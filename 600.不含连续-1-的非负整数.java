/*
 * @lc app=leetcode.cn id=600 lang=java
 *
 * [600] 不含连续1的非负整数
 */

// @lc code=start
class Solution {

    public static void main(String[] args) {
        int a=new Solution().findIntegers(5);
    }
    public int findIntegers(int n) {
        String s = Integer.toBinaryString(n);
        int m = s.length();
        int[] dp = new int[m + 1];
        // int[] dp1 = new int[m + 1];
        // int[] dp2 = new int[m + 1];

        // for (int i = 0; i <= m; i++) {
        //     if (i == 0) {
        //         dp1[i] = m;
        //         dp2[i] = 1;
        //     } else {
        //         dp1[i] = dp1[i - 1] * ((m - i) == 0 ? 1 : (m - i));
        //         dp2[i] = dp2[i - 1] * i;
        //     }
        // }
        for (int i = 1; i <=m; i++) {
            int sum = i;
            int start=i;
            for (int j = 1; j <=(i + 1) / 2; j++) {
                start=start* (i - j) / (j + 1);
                sum = sum +start;
            }
            dp[i] = sum;

        System.out.println(dp[i]);
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '1') {
                for(int j=0;j<i;j++){
                    sum=sum+j>0?dp[j-1]:1;
                }
            }
        }

        return sum;

    }
    
}

// @lc code=end

