import java.util.*;
class Solution {
    public int solution(int n) {
        String tmp = Integer.toString(n, 3);
        String reverse = "";
        for (int i = 1; i <= tmp.length(); i++){
            reverse += tmp.charAt(tmp.length() - i);
        }
        
        int answer = Integer.parseInt(reverse, 3);
        return answer;
    }
}