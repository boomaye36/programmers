import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
//         Queue<Integer> q = new LinkedList<>();
//         int[] num = new int[order.length];
//         for (int i = 0; i < order.length; i++) num[i] = i+1;
//         for (int i = 1; i <= num.length; i++){
//             st.add(order[num.length-i]);
//             q.add(num[i-1]);
//         }
        
//         while (!q.isEmpty()){
//             q.remove();
//             int x = st.pop();
//             if (st.isEmpty()) break;
//             if (st.peek() + 1 == x || st.peek() > x){
//                 answer++;
//                // System.out.println.(answer);
//             }
//             else if (st.peek() < x && q.remove() == st.peek()){
//                 answer++;
//             }
//             else break;
//         }
//         return answer+1;
        int idx = 0;
        for (int i = 1; i <= order.length; i++){
            if (order[idx] != i) st.push(i);
            else{
                idx++;
                answer++;
            }
            while(!st.isEmpty() && st.peek() == order[idx]){
                st.pop();
                answer++;
                idx++;
            }
        }
        return answer;
    }
}