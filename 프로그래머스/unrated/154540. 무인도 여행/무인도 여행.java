import java.util.*;
class Pos{
    int x, y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] visit;
    public static char[][] island;
    public int[] solution(String[] maps) {
        island = new char[maps.length][maps[0].length()];
        visit = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                island[i][j] = maps[i].charAt(j);
            }
        }
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (island[i][j] != 'X' && !visit[i][j]){
                    arr.add(bfs(new Pos(i, j)));
                }
            }
        }
        if (arr.isEmpty()) return new int[]{-1};
        int[] answer = new int[arr.size()];
       Collections.sort(arr);
       for (int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        return answer;
    }
    
    public static int bfs(Pos start){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visit[start.x][start.y] = true;
        int sum = 0;
        while (!q.isEmpty()){
            Pos tmp = q.poll();
            sum += island[tmp.x][tmp.y] - '0';
            for (int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < island.length && ny >= 0 && ny < island[0].length){
                    if (!visit[nx][ny] && island[nx][ny] != 'X'){
                    visit[nx][ny] = true;
                    q.add(new Pos(nx, ny));
                    }
                }
            }
        }
        return sum;
    }
}