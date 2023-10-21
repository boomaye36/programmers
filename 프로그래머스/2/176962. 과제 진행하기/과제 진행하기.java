import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        Stack<String[]> st = new Stack<>();
        ArrayList<String> list = new ArrayList<>();
        Arrays.sort(plans, (o1, o2) -> toTime(o1[1]) - toTime(o2[1]));
        for (int i = 0; i < plans.length-1; i++){
            String now[] = plans[i];
            String[] next = plans[i+1];
            int nowTime = toTime(now[1]) + Integer.parseInt(now[2]);
            int nextTime = toTime(next[1]);
            if (nowTime == nextTime){
                list.add(now[0]);
            }
            else if (nowTime < nextTime){
                list.add(now[0]);
                int gap = nextTime - nowTime;
                
                while(!st.isEmpty()){
                    String[] tmp = st.peek();
                    int time = Integer.parseInt(tmp[1]);
                    if (time > gap){
                        st.pop();
                        st.push(new String[]{tmp[0], String.valueOf(time - gap)});
                        break;
                    }
                    else {
                        
                        String[] result = st.pop();
                        list.add(result[0]);  
                        gap -= Integer.parseInt(result[1]);
                        //System.out.println(result[0] +" : " gap);
                        if (gap <= 0) break;
                    }
                    
                }
                
            }
            
            else{
                st.push(new String[]{now[0], String.valueOf(nowTime - nextTime)});
            }
            if (i == plans.length - 2) list.add(next[0]);
            
        }
       // System.out.println(st);
        while(!st.isEmpty()){
            String str[] = st.pop();
            list.add(str[0]);
        }
        answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    public int toTime(String s){
        String[] tmp = s.split(":");
        return Integer.parseInt(tmp[0]) * 60 + Integer.parseInt(tmp[1]);
    }
}