import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = Integer.MIN_VALUE;
        
        int n = sequence.length;
        
        List<long[]> dp = new ArrayList<>();
        dp.add(new long[n]);
        dp.add(new long[n]);
        
        dp.get(0)[0] = pulse(0, 0, sequence);
        dp.get(1)[0] = pulse(1, 0, sequence);
        answer = Math.max(dp.get(0)[0], dp.get(1)[0]);
        for (int i = 1; i < n; i++){
            for (int k = 0; k < 2; k++){
                long cal = pulse(k, i, sequence);
                dp.get(k)[i] = Math.max(cal, dp.get(k)[i-1] + cal);
            }
            answer = Math.max(answer, Math.max(dp.get(0)[i], dp.get(1)[i]));
        }
        
        return answer;
    }
    
    private long pulse(int k, int i ,int[] sequence){
        long t;
        if (i % 2 == 0) t = (k == 0) ? sequence[i] * -1 : sequence[i];
        else t = (k == 0) ? sequence[i] : sequence[i] * -1;
        return t;
    }
}