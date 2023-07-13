import java.util.*;
class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
       while (true){
        if (s.equals("1")) break;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0') {
                zero++;
            }
        }
          s = s.replaceAll("0", "");

         s = Integer.toString(s.length(), 2);
         cnt++;
       }
        
        return new int[]{cnt, zero};
    }
}