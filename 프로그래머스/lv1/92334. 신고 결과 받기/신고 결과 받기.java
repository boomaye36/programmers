import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        int[] answer = new int[id_list.length];
        for (String id : id_list){
            reportMap.put(id, new HashSet<String>());
            count.put(id, 0);
        }
        for (String s : report){
            String[] arr = s.split(" ");
            if (!reportMap.get(arr[0]).contains(arr[1])){
                int cnt = count.get(arr[1]);
                count.put(arr[1], cnt + 1);
                reportMap.get(arr[0]).add(arr[1]);
                
            }
        }
        for (int i = 0; i < id_list.length; i++){
            int cnt = 0;
            for (String id : reportMap.get(id_list[i])){
                if (count.get(id) >= k) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}