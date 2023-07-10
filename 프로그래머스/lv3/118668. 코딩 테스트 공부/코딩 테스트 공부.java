import java.util.*;
class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        int maxA = 0, maxC = 0;
        for (int i = 0; i < problems.length; i++){
            maxA = Math.max(maxA, problems[i][0]);
            maxC = Math.max(maxC, problems[i][1]);
        }
        if (alp >= maxA && cop >= maxC) return 0;
        alp = Math.min(alp, maxA);
        cop = Math.min(cop, maxC);
        int[][] dp = new int[maxA + 5][maxC + 5];
        for (int i = alp; i <= maxA; i++){
            for (int j = cop; j <= maxC; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[alp][cop] = 0;
        for (int i = alp; i <= maxA; i++){
            for (int j = cop; j <= maxC; j++){
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + 1);
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j] + 1);
                
                for (int[] arr : problems){
                    if (i >= arr[0] && j >= arr[1]){
                        if (i + arr[2] > maxA && j + arr[3] > maxC) dp[maxA][maxC] = Math.min(dp[maxA][maxC], arr[4] + dp[i][j]);
                        else if (i + arr[2] > maxA) dp[maxA][j + arr[3]] = Math.min(dp[maxA][j + arr[3]], arr[4] + dp[i][j]);
                        else if (j + arr[3] > maxC) dp[i + arr[2]][maxC] = Math.min(dp[i + arr[2]][maxC], arr[4] + dp[i][j]);
                        else dp[i + arr[2]][j + arr[3]] = Math.min(dp[i + arr[2]][j + arr[3]], arr[4] + dp[i][j]);
                    }
                }
            }
        }
        return dp[maxA][maxC];
    }
}