import java.util.*;
class Solution {
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] wires) {

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) list[i] = new ArrayList<>();
        for (int i = 0; i < wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        
        int answer = 100;
        for (int i = 0; i < wires.length; i++){
            int a1 = bfs(wires[i][0], wires[i][1], n);
            int a2 = bfs(wires[i][1], wires[i][0], n);
            answer = Math.min(answer, Math.abs(a1 - a2));
        }
        return answer;
    }
    
    public static int bfs(int n1, int n2, int n){
        Queue<Integer> q = new LinkedList<>();
        boolean [] visit = new boolean[n+1];
        int cnt = 0;
        q.add(n1);
        visit[n1] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            cnt++;
            for (int x : list[tmp]){
                if (!visit[x] && x != n2){
                    q.add(x);
                    visit[x] = true;
                }
            }
        }
        return cnt;
    }
}