import java.util.*;
class Solution {
    public long solution(int k, int d) {
//         long answer = 0;
//         int x = 0; 
//         int y = 0;
//         for (x = 0; x <= d; x += k){
//             y = 0;
//             while(dis(x, y) <= (double)d){
//                 y+=k;
//                 answer++;
//             }
//         }
//         return answer;
//     }
    
//     public double dis(int x, int y){
//         return Math.sqrt((long)x * x + (long)y * y);
//     }
        long answer = 0;
        
        for (long i = 0; i <= d/k; i++) {
            long x = i * k;
            long y = (long) Math.sqrt((long) Math.pow(d, 2) - (long) Math.pow(x, 2)) / k;
            
            answer += y + 1; // 0도 포함해주어야 하므로 +1
        }
        return answer;
    }

}