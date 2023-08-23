import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        int len = s.length();
        int cnt = 1;
        for (int i = 1; i <= len / 2; i++){
            StringBuilder result = new StringBuilder();
            String part = s.substring(0, i);
            for (int j = i; j <= s.length(); j += i){
                int endIdx = Math.min(j + i, s.length());
                String compare = s.substring(j, endIdx);
                if (part.equals(compare)) cnt++;
                else{
                    if (cnt >= 2){
                        result.append(cnt);
                    }
                    result.append(part);
                    part = compare;
                    cnt = 1;
                }
            }
            result.append(part);
            //System.out.println(result);
            answer = Math.min(answer, result.length());
        }
        return answer;
    }
}