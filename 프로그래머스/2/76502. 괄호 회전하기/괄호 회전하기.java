import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++){
            if(isRight(s)) answer++;
            s = rotate(s);
        }
        return answer;
    }

    static boolean isRight(String s){
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{')
                st.add(s.charAt(i));
            else {
                if (st.isEmpty())
                    return false;
                char top = st.pop();
                if (s.charAt(i) == ']' && top != '[')
                    return false;
                if (s.charAt(i) == ')' && top != '(')
                    return false;
                if (s.charAt(i) == '}' && top != '{')
                    return false;
            }
        }
        return st.isEmpty();
    }

    static String rotate(String s){
        return s.substring(1) + s.charAt(0);
    }
}
