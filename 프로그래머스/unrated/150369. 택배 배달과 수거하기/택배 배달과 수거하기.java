import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Stack<Integer> d = new Stack<>();
        Stack<Integer> p = new Stack<>();
        
        long answer = 0;
        for (int i = 0; i < n; i++){
            d.push(deliveries[i]);
            p.push(pickups[i]);
        }
        while (!d.isEmpty() || !p.isEmpty()){
            while (!d.isEmpty() && d.peek() == 0) d.pop();
            while (!p.isEmpty() && p.peek() == 0) p.pop();
            answer += 2 * Math.max(d.size(), p.size());
            
            int dtarget = 0;
            while (!d.isEmpty()){
                int currentd = d.pop();
                if (dtarget + currentd <= cap) dtarget += currentd;
                else{
                    d.push(dtarget + currentd - cap);
                    break;
                } 
            }
            int ptarget = 0;
            while (!p.isEmpty()){
                int currentp = p.pop();
                if (currentp + ptarget <= cap) ptarget += currentp;
                else {
                    p.push(ptarget + currentp - cap);
                    break;
                }
            }
        }
        return answer;
    }
}