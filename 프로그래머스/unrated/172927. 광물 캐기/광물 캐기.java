import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static int total = 0;
    static int[] visit;
    
    public int solution(int[] picks, String[] minerals) {
        visit = new int[picks.length];
        for (int pick : picks) total += pick;
        
        for (int i = 0; i < 3; i++){
            if (picks[i] == visit[i]) continue;
            
            visit[i]++;
            dfs(1, 0, i, 0, picks, minerals);
            visit[i]--;
        }
        return answer;
    }
    
    private void dfs(int cnt, int startIdx, int pickIdx, int sum, int[] picks, String[] minerals){
        if (answer <= sum || startIdx >= minerals.length) return;
        
        int add = 0;
        
        for (int i = startIdx; i < startIdx + 5; i++){
            if (i >= minerals.length) break;
            
            String mineral = minerals[i];
            
            if (pickIdx == 0) add += 1;
            else if (pickIdx == 1) add += mineral.equals("diamond") ? 5 : 1;
            else if (mineral.equals("diamond")) add += 25;
            else add+= mineral.equals("iron") ? 5 : 1;
        }
    
    if (cnt >= total || startIdx + 5 >= minerals.length){
        answer = Math.min(answer, sum + add);
        return;
    }
    for (int i = 0; i < picks.length; i++){
        if (picks[i] == 0 || picks[i] == visit[i]) continue;
        visit[i]++;
        dfs(cnt + 1, startIdx + 5, i, sum + add, picks, minerals);
        visit[i]--;
    }
}
}