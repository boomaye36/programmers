import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todaygetDay = getDay(today);
        HashMap<String, String> map = new HashMap<>();
        for (String term : terms){
            String[] words = term.split(" ");
            String cate = words[0];
            String month = words[1];
            
            map.put(cate, month);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 1;
        for (String privacy : privacies){
            String[] pri = privacy.split(" ");
            String date = pri[0];
            String cate = pri[1];
            int limit = Integer.parseInt(map.get(cate));
            
            int limitcount = getDay(date) + limit * 28;
            if (todaygetDay >= limitcount) list.add(idx);
            idx++;
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        

        return answer;
    }
    private int getDay(String date){
    String[] datearr = date.split("\\.");
    int y = Integer.parseInt(datearr[0]);
    int m = Integer.parseInt(datearr[1]);
    int d = Integer.parseInt(datearr[2]);
    return (y * (12 * 28)) + m * 28 + d;
}
}


