import java.util.*;
class Solution {
    public int solution(String word) {
        String str = "AEIOU";
        int[] dis = {781, 156, 31, 6, 1};
        int idx, answer = word.length();
        for (int i = 0; i < word.length(); i++){
            idx = str.indexOf(word.charAt(i));
            answer += dis[i] * idx;
        }
        return answer;
    }
}