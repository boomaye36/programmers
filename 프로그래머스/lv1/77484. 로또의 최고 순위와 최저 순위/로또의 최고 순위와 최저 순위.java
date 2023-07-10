import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        for (int x : lottos) list1.add(x);
        for (int x : win_nums) list2.add(x);

        int cnt = 0;
        for (int x : list1) {
            if (list2.contains(x)) {
                cnt++;
            }
        }
        
        int zerocnt = 0;
        for (int x : list1) {
            if (x == 0) {
                zerocnt++;
            }
        }
        if (cnt == 0 && zerocnt == 0) return new int[]{6, 6};
        if (cnt == 0) {
            return new int[]{7 - zerocnt, 6};
        }
        
        int max = 7 - (cnt + zerocnt);
        int min = 7 - cnt;
        int[] answer = new int[]{max, min};
        return answer;
    }
}
