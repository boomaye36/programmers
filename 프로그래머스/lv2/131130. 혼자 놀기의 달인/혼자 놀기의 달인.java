import java.util.*;
class Solution {
    public static int size;
    public static boolean[] visit;
    public int solution(int[] cards) {
        ArrayList<Integer> list = new ArrayList<>();
        visit = new boolean[cards.length+1];
        for (int i = 0; i < cards.length; i++){
            size = 0;
            dfs(cards, i);
            list.add(size);
        }
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
        // for (int x : cards) list.add(x);
        // int idx = 0;
        // int cnt = 0;
        // ArrayList<Integer> tmp = new ArrayList<>();
        // while(!list.isEmpty()){
        //     list.remove(Integer.valueOf(cards[idx]));
        //     idx =cards[idx]-1;
        //     cnt++;
        //     if (!list.contains(cards[idx])){
        //         tmp.add(cnt);
        //         cnt = 0;
        //     }
        // }
        // for (int x : tmp) System.out.println(x);
        // Collections.sort(tmp, Collections.reverseOrder());
        // return tmp.get(0) * tmp.get(1);
    }
    public static void dfs(int[] cards,int x){
        if (!visit[x]){
            visit[x] = true;
            size++;
            dfs(cards, cards[x] - 1);
        }
    }
}