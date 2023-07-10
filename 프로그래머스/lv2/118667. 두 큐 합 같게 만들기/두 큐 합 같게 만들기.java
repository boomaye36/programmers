import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum = 0;
        for (int i = 0; i < queue1.length; i++){
            sum += queue1[i];
            sum += queue2[i];
        }
        if (sum % 2 == 1) return -1;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long s1 = 0, s2 = 0;
        for (int x : queue1) {
            q1.add(x);
            s1 += x;
        }
        for (int x : queue2) {
            q2.add(x);
            s2 += x;
        }
        sum /= 2;
        int cnt = 0;
        int p1 = 0, p2 = 0, limit = queue1.length*2;

        while (p1<=limit && p2<=limit) {
            if (s1 == sum) return p1 + p2;
            if (s1 > sum){
                s1 -= q1.peek();
                s2 += q1.peek();
                q2.add(q1.poll());
                p1++;
            }
            else { 
                s2 -= q2.peek();
                s1 += q2.peek();
                q1.add(q2.poll());
                p2++;
            }
        }
        return -1;
    }
}