import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        for (int i = 0; i < len; i++){
            char tmp = s.charAt(0);
            s = s.substring(1) + tmp;
            if (isTrue(s)) answer++;
        }
        return answer;
    }
    
    public boolean isTrue(String s){
        Stack<Character> st = new Stack<>();
       for (int i = 0; i < s.length(); i++){
           char c = s.charAt(i);
           if (c == '[' || c == '{' || c == '(') st.push(c);
           else {
               if (st.isEmpty()) return false;
               char top = st.pop();
               if (c == ']' && top != '[' || c == ')' && top != '(' || c == '}' && top != '{') return false;
           }
       }
        return st.isEmpty();
    }
}