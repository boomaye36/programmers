class Solution {
    static boolean[] visit;
    static int ans=0;
    public int solution(int k, int[][] dungeons) {
        
        visit = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return ans;
    }
    public void dfs(int k, int[][] dungeons,int level){
        for (int i = 0; i < dungeons.length; i++){
            if(!visit[i] && k >= dungeons[i][0]){
                visit[i] = true;
                 dfs(k - dungeons[i][1], dungeons, level+1);
                visit[i] = false;
            }
        }
        ans = Math.max(ans, level);
    }
}