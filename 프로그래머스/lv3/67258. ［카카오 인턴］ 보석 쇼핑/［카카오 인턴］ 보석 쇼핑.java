import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int kind = new HashSet<>(Arrays.asList(gems)).size();
        int l = 0;
        int len = Integer.MAX_VALUE;
        HashMap<String, Integer> map = new HashMap<>();

        for (int r = 0; r < gems.length; r++){
            map.put(gems[r], map.getOrDefault(gems[r], 0) + 1);
            while(map.get(gems[l]) > 1){
                map.put(gems[l], map.get(gems[l]) - 1);
                l++;
            }
            if (r - l < len && map.size() == kind){
                len = r - l;
                answer[0] = l + 1;
                answer[1] = r + 1;
            } 
        }
        return answer;
    }
}


