import java.util.*;
class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i <= r2; i++){
            int circle1 = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
            int circle2 = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
            
            answer += circle2 - circle1 + 1;
        }
        return answer * 4;
    }
}