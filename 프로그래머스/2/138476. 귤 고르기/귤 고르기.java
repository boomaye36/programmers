import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();
        for (int x : tangerine){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(list, (int[] o1, int[] o2) -> {
           return o2[1] - o1[1]; 
        });
        
        int answer = 0;
        int idx = 0;
        for(int i = 0; i < list.size(); i++){
            if (idx >= k) break;
            idx += list.get(i)[1];
            answer ++;
        }
        return answer;
    }
}