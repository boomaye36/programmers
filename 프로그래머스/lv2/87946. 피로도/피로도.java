import java.util.*;
class Solution {
    static int answer;
    static boolean[] visit;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visit = new boolean[dungeons.length];
        //Arrays.sort(dungeons, (o1, o2)-> Integer.compare(o1[1]-o1[0], o2[1]-o2[0]));
        dfs(dungeons, 0, k);
        return answer;
    }
    public void dfs(int[][] dungeons,int depth, int k){
        for (int i = 0; i < dungeons.length; i++){
            if (visit[i] || k < dungeons[i][0]) continue;
            visit[i] = true;
            dfs(dungeons, depth + 1, k - dungeons[i][1]);
            visit[i] = false;
        }
            answer = Math.max(answer, depth);
        
    }
}