import java.util.*;
class Pos{
    int x, y;
    int level;
    public Pos(int x,int y,int level){
        this.x = x;
        this.y = y;
        this.level = level;
    }
}
class Solution {
    static char[][] map;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
       Pos start = null;
           Pos end = null;
           Pos lever = null;
        for(int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if(map[i][j] == 'S')  start = new Pos(i, j, 0);
                else if(map[i][j] == 'L') lever = new Pos(i, j, 0);
                else if(map[i][j] == 'E')  end = new Pos(i, j, 0);
            }
        }
       int tmp = bfs(start.x, start.y, maps.length, maps[0].length(), lever.x, lever.y);
        if(tmp == -1) return -1;
        visit = new boolean[map.length][map[0].length];

        int sol = bfs(lever.x, lever.y, maps.length, maps[0].length(), end.x, end.y);
        if(sol == -1) return -1;

        
        return tmp + sol;
    }
    public int bfs(int startX, int startY, int x, int y, int endX, int endY){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(startX, startY, 0));
        visit[startX][startY] = true;
        while(!q.isEmpty()){
        Pos now = q.poll();
        int level = now.level;
        if (now.x == endX && now.y == endY) return level;
        for (int i = 0; i < 4; i++){
            int nextX = now.x + dx[i];
            int nextY = now.y + dy[i];
            if(nextX < 0 || nextY < 0 || nextX >= x || nextY >= y) continue;
            if(!visit[nextX][nextY] && map[nextX][nextY] != 'X'){
                q.add(new Pos(nextX, nextY, level + 1));
                visit[nextX][nextY] = true;
            }
        }
        }
            
        return -1;
    }
}