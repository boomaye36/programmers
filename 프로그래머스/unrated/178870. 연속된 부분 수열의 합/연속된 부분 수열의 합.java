import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = 0; 
        int start = 0;
        int end = 0;
        int ans1 = Integer.MAX_VALUE;
        int ans2 = Integer.MAX_VALUE;
        int length = 1000000;
        for (end = 0; end < sequence.length; end++){
            sum += sequence[end];
            while (sum > k){
                sum -= sequence[start];
                start++;
            }
            if (sum == k){
               
                if (length > end - start){
                    length = end - start;
                     ans1 = start;
                     ans2 = end;
                }
                else if (length == end - start){
                    ans1 = Math.min(ans1, start);
                    ans2 = Math.min(ans2, end);
                    //break;
                }
            }
        }
        return new int[]{ans1, ans2};
    }
}