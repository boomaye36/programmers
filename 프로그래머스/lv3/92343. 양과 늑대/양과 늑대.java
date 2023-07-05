import java.util.*;
class Solution {
    public static int maxsheep;
    public static int[] Info;
    public static boolean[][][] visited;
    public static ArrayList<Integer>[] connect;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Info = info;
        connect = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) connect[i] = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            connect[a].add(b); //a 노드에 연결되 있는 것
            connect[b].add(a); // b 노드에 연결되 있는 것
        }
        maxsheep = 0;
        visited = new boolean[info.length][info.length + 1][info.length + 1];
        dfs(0, 0, 0);
        answer = maxsheep;
        return answer;
    }
    public static void dfs(int sheep, int wolf, int state){
        if (Info[state] == 0) sheep++;
        else if (Info[state] == 1) wolf++;
        if (wolf >= sheep) return;
        
        maxsheep = Math.max(maxsheep, sheep);
        for (int i = 0; i < connect[state].size(); i++){
            int next = connect[state].get(i);
            int tmp = Info[state];
            if (!visited[next][sheep][wolf]){ // 방문하지 않은곳이면 
                Info[state] = -1; //양도아니고 늑대도 아님
                visited[state][sheep][wolf] = true; 
                dfs(sheep, wolf, next); //한단계 내려감
                Info[state] = tmp; // 원래값 복원
                visited[state][sheep][wolf] = false; // 올라갔으므로 방문 안함
            }
        }
    }
}