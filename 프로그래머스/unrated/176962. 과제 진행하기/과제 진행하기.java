import java.util.*;
class Solution {
    public class Subject implements Comparable<Subject>{
        String name;
        int start, dur;
        Subject(String name, int start, int dur){
            this.name = name;
            this.start = start;
            this.dur = dur;
        }
        
        @Override
        public int compareTo(Subject s){
            return this.start - s.start; //시작시간 오름차순 정렬
        }
    }
    
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Subject> q = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));
        int idx = 0;
        for (String [] tmp : plans){
            String sub = tmp[0];
            String start = tmp[1];
            int time = toMin(start);
            int dur = Integer.parseInt(tmp[2]);
            q.add(new Subject(sub, time, dur));
            
        }
        Subject s = q.poll();
        int now = s.start;
        
        Stack<Subject> st = new Stack<>();

        while (true){
            if (!q.isEmpty() && now + s.dur > q.peek().start){
                st.add(new Subject(s.name, s.start, now + s.dur - q.peek().start));
               // now = q.peek().start;
                s = q.poll();
               now = s.start;
            }
        
            else {
                answer[idx++] = s.name;
                now += s.dur;
                
                if (!q.isEmpty() && now == q.peek().start){ // 새로 시작해야 하는 과제
                    s = q.poll();
                }
                else if (!st.isEmpty()) s = st.pop(); // 멈췄던 과제
                else if (!q.isEmpty()){
                    s = q.poll();
                    now = s.start;
                }
                else break;
            }
        }
        return answer;
    }
    public int toMin (String start){
        String[] s = start.split(":");
        int h = Integer.parseInt(s[0]) * 60;
        int m = Integer.parseInt(s[1]);
        return h + m;
    }
}