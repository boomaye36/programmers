import java.util.*;
class Solution {
    public static ArrayList<int[]> list = new ArrayList<int[]>();
    public static int maxdiff = -1;
    public static int[] ryan;
    public static int[] peach;
    public int[] solution(int n, int[] info) {
        int[] answer = new int[n];
       
        ryan = new int[11];
        peach = info;
        dfs(n, 0, 0);
        if (maxdiff == -1) return new int[]{-1};
        Collections.sort(list, (o1, o2) ->{
           for (int i = 10; i >= 0; i--){
               if (o1[i] != o2[i]) return o2[i] - o1[i];
               
           }
            return 0;
        });
        return list.get(0);
    }
    
    public static void dfs(int n, int depth, int start){
        if (depth == n){
            int psum = 0;
            int rsum = 0;
            for (int i = 0; i <= 10; i++){
                if (ryan[i] == 0 && peach[i] == 0) continue;
                if (peach[i] >= ryan[i]) psum += 10 - i;
                else if (peach[i] < ryan[i]) rsum += 10 - i;
            }
            if (rsum > psum){
                int diff = rsum - psum;
                if (maxdiff < diff){
                    maxdiff = diff;
                    list.clear();
                    list.add(ryan.clone());
                }
                else if (maxdiff == diff){
                    list.add(ryan.clone());
                }
            }
            return;
        }
        for (int i = start; i < 11; i++){
            ryan[i]++;
            dfs(n, depth + 1, i);
            ryan[i]--;
        }
    }
}