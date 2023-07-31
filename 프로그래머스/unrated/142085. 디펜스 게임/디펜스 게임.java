import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
       for (int i = 0; i < enemy.length; i++){
           q.add(enemy[i]);
           if (k < q.size()){
               n -= q.poll();
           }
           if (n < 0) return i;
       }
        return enemy.length;
    }
}