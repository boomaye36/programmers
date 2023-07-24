import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int size = book_time.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(book_time, (a, b) -> (toMin(a[0]) - toMin(b[0])));
        
        int idx = 0;
        int time = 0;
        int cnt = 0;
        
        while (idx != size){
            q.add(toMin(book_time[idx][1]) + 10);
            time = toMin(book_time[idx][0]);
            cnt++;
            idx++;
            while(time >= q.peek()){
                q.poll();
                cnt--;
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
    
    public int toMin (String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]); // 분으로 변환하는 함수
    }
}