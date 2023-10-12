import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character>st = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '<'){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                flag = true;
                sb.append('<');
            }
            else if (s.charAt(i) == '>'){
                flag = false;
                sb.append('>');
            }
            else if(flag) sb.append(s.charAt(i));
            else if(s.charAt(i) == ' '){
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                sb.append(' ');
            }
            else {
                st.push(s.charAt(i));

        }
        }
        while(!st.isEmpty()) sb.append(st.pop());
        System.out.println(sb.toString());
    }
}
