import java.util.*;
class Solution {
    public int solution(int[] topping) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int x : topping){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < topping.length; i++){
            set1.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) map.remove(topping[i]);
            if (map.size() == set1.size()) answer++;
        }
        return answer;
    }
}