import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int ans1 = 1000000;
        int ans2 = 1000000;
        int right = 0;
        int left = 0;
        int sum = 0;
        int len = 1000000;

//        for (int i = left; i < sequence.length; i++){
//            sum = sequence[i];
//            if (sum == k) return new int[]{i, i};
//            if (sum > k) continue;
//            if (i == sequence.length-1)right = i;
//            else right = i+1;
           
//            while(right < sequence.length ){
//                sum += sequence[right];

//                if (sum > k){
//                   // right = i + 1;
//                    break;
//                }
//                if (sum == k){
//                    if (len > right - i){
//                        len = right - i;
//                        ans1 = i;
//                        ans2 = right;
//                       // System.out.println("ans1" + ans1 + "ans2" + ans2);
//                    }
//                 ans1 = Math.min(ans1, i);
//                 ans2 = Math.min(ans2, right);
//                // right = i + 1;
//                    break;
//                }
//                 right++;
               
//            }
//        }
        for (right = 0; right < sequence.length; right++){
            sum += sequence[right];
            while(sum > k){
                sum -= sequence[left];
                left++;
            }
            
               if (sum == k){
                   if (len > right - left){
                       len = right - left;
                       ans1 = left;
                       ans2 = right;
                      // System.out.println("ans1" + ans1 + "ans2" + ans2);
                   }
                   else if (len == right - left){
                     ans1 = Math.min(ans1, left);
                     ans2 = Math.min(ans2, right);
                   }
               } 
        }
        return new int[]{ans1, ans2};
    }
}