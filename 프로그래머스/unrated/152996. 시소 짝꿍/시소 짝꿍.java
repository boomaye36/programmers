import java.util.*;
class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i : weights){
            double a = (double)i * 1.0;
            double b = (double)i * 2/3;
            double c = (double)i * 1/2;
            double d = (double)i * 3/4;
            if (map.containsKey(a)) answer += map.get(a);
            if (map.containsKey(b)) answer += map.get(b);
            if (map.containsKey(c)) answer += map.get(c);
            if (map.containsKey(d)) answer += map.get(d);

            map.put((double)i, map.getOrDefault((double)i, 0) + 1);
        }
        return answer;
    }
}