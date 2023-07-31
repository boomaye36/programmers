import java.util.*;
class Solution {
    class Pos{
        int x, y, level;
        public Pos(int x, int y, int level){
            this.x = x;
            this.y = y;
            this.level = level;
        }
    }
    static int n, m;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] board) {
        int answer = 0;
        n = board.length; 
        m = board[0].length();
        Pos robot = null;
        Pos goal = null;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                char c = board[i].charAt(j);
                if (c == 'R') robot = new Pos(i, j, 0);
                else if (c == 'G') goal = new Pos(i, j, 0);
            }
            
        }
         answer = bfs(robot, goal, board);
        return answer;
    }
    public int bfs(Pos robot, Pos goal, String[] board){
        //System.out.println(n);
        Queue<Pos> q = new LinkedList<>();
        q.add(robot);
        visit = new boolean[n][m];
        visit[robot.x][robot.y] = true;
        
        while(!q.isEmpty()){
            Pos tmp = q.poll();
            if (tmp.x == goal.x && tmp.y == goal.y) return tmp.level;
            for (int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                while(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx].charAt(ny) != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                if (visit[nx][ny] || tmp.x == nx && tmp.y == ny) continue;
                visit[nx][ny] = true;
                q.add(new Pos(nx, ny, tmp.level + 1));
            }
        }
        return -1;
    }
}