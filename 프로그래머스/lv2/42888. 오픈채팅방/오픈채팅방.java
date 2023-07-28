import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (String s : record){
            String[] tmp = s.split(" ");
            if (tmp.length == 3) map.put(tmp[1], tmp[2]);
        }
        for (String s : record){
            String[] tmp = s.split(" ");
            String msg = tmp[0];
            if (msg.equals("Enter")){
                list.add(map.get(tmp[1]) + "님이 들어왔습니다.");
            }
            else if (msg.equals("Leave")){
                list.add(map.get(tmp[1]) + "님이 나갔습니다.");
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}