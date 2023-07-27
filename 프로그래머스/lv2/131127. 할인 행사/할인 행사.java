import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> def = new HashMap<>();

        for (int i = 0; i < number.length; i++){
            def.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++){
            HashMap<String, Integer> mart = new HashMap<>();
            boolean flag = true;
            for (int k = i; k < i + 10; k++){
                mart.put(discount[k], mart.getOrDefault(discount[k], 0) + 1);
            }
            for (String key : def.keySet()){
                if (def.get(key) != mart.get(key)){
                    flag = false;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}