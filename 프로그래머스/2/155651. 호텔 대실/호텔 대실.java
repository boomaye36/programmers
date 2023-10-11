import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        Arrays.sort(book_time, (o1, o2) -> {
            if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });
        int[][] hotel = new int[book_time.length][2];
        int answer = 0;
        int idx = 0;
        for (String[] time : book_time){
            hotel[idx][0] = clock(time[0]);
            hotel[idx][1] = clock(time[1]) + 10;
            idx++;
        }
        for (int[] tmp : hotel){
            if (q.isEmpty()){
                q.add(tmp[1]);
                continue;
            }
            if(q.peek() <= tmp[0]){
                q.poll();
                q.add(tmp[1]);
            }else{
                q.add(tmp[1]);
            }
        }
        
        return q.size();
    }
    
    public int clock(String clock){
        String[] arr = clock.split(":");
        return 60 * Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
    }
}