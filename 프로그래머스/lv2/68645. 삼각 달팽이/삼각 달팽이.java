import java.util.*;
class Solution {
    public int[] solution(int n) {
        int [][] snail = new int[n][n];
//         for (int i = 0; i < n; i++){
//             snail[i][0] = i+1;
//         }
        
        int x = -1, y = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++){
            for (int j = i; j < n; j++){
                if (i % 3 == 0) x++;
                else if (i % 3 == 1) y++;
                else {
                    y--;
                    x--;
            }
                snail[x][y] = cnt;
                cnt++;
        }
        }
        int[] answer = new int[(n*(n+1))/2];
        int idx = 0;
        for (int i = 0; i < snail.length; i++){
            for (int j = 0; j <= i; j++){
                answer[idx] = snail[i][j];
                idx++;
            }
        }
        return answer;
    }
}