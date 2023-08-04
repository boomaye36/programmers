import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
       
            for(String s : skill_trees){
                 Stack<Character> st = new Stack<>();
                for (int i = skill.length() - 1; i >= 0; i--) st.add(skill.charAt(i));
                boolean flag = true;
                for (int i = 0; i < s.length(); i++){
                   if (st.contains(s.charAt(i))){
                       if (s.charAt(i) == st.peek()){
                           st.pop();
                       }
                       else flag = false;
                   } 
                }
                if (flag) answer++;
            }
        return answer;
    }
}