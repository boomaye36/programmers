import java.util.*;
class Solution {
     public static int solution(int storey) {
//         // 층마다 필요한 마법의 돌의 최소 개수를 저장할 배열
//         ArrayList<Integer> tmp = new ArrayList<>();
//         int x = 1;
//         while(x <= storey){
//             tmp.add(x);
//             tmp.add(x * -1);
//             x *= 10;
//         }
//         int[] dp = new int[storey + 100000000];
 
//           for (int i = storey-1; i >= 0; i--) {
//             dp[i] = dp[i+1] + 1;

//           }
//          for (int i = storey; i < dp.length - 1; i++) dp[i + 1] = dp[i] + 1;

//         // 0층까지의 필요한 마법의 돌의 최소 개수를 계산
//         for (int i = storey-1; i >= 0; i--) {

//             // 버튼의 값을 하나씩 누르면서 최소 개수를 갱신
//             for (int button : tmp) {
//                if (i + button >= 0 ){
//                dp[i] = Math.min(dp[i] , dp[i + button]+1);
//                }
//             }
//         }

//         return dp[0];
         int answer = 0;
         String s = Integer.toString(storey);
         int[] tmp = new int[s.length()];
         for (int i = 0; i < s.length(); i++){
             tmp[i] = s.charAt(i) - '0';
         }
         for (int x : tmp) System.out.println("tmp" + x);
         for (int i = tmp.length-1; i >= 0; i--){
             if (tmp[i] > 5) {
                 answer += (10 - tmp[i]);
                 if (i == 0) answer++;
                 else tmp[i-1]++;
                 System.out.println(answer);
             }
             
             else if (i >= 1 && tmp[i] == 5 && tmp[i-1] >= 5){
                 answer+=5;
                 tmp[i-1]++;
             }
             else {
                 answer += tmp[i];
             }
         }
         return answer;
    }
}