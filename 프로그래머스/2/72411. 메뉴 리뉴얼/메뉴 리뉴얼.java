import java.util.*;
class Solution {
    public static HashMap<String, Integer> map;
    public static int max;
    public String[] solution(String[] orders, int[] course) {
        
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>();
        for (int l : course){
            max = 0;
            map = new HashMap<>();
        for (String s : orders){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = new String(ch);
            check(0, -1, s, "", l);
        }
            for (String key : map.keySet()){
                int value = map.get(key);
                if(value > 1 && max == value) ans.add(key);
            }
        }
        Collections.sort(ans);
        answer = ans.toArray(new String[ans.size()]);
        return answer;
    }
    public void check(int level, int x, String order, String cur, int end){
        if (level == end){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            max = Math.max(max, map.get(cur));
        }
        for (int i = x + 1; i < order.length(); i++){
            check(level + 1, i, order, cur + order.charAt(i), end);
        }
    }
}