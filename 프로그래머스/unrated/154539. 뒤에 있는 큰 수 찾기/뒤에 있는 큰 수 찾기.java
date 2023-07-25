import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> st = new Stack<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && numbers[i] >= st.peek()) {
                st.pop();
            }
            if (!st.isEmpty()) {
                answer[i] = st.peek();
            }
            st.push(numbers[i]);
        }

        return answer;
    }
}