import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Integer> map = new HashMap<>();
        TreeMap<String, Integer> tree = new TreeMap<>();
        //ArrayList<Integer> car = new ArrayList<>();
        for (String s : records){
           // s = s.replaceAll("\"", "");
            String[] rec = s.split(" ");
            if (rec[2].equals("IN")){
                map.put(rec[1], convert(rec[0]));
                if (!tree.containsKey(rec[1])) tree.put(rec[1], 0);
               
        } else {
                
                    tree.put(rec[1], tree.get(rec[1]) + convert(rec[0]) - map.get(rec[1]));
                
                    map.remove(rec[1]);
            }
        
        }
        if (!map.isEmpty()){
            for (String s : map.keySet()){
                tree.put(s, tree.get(s) + 1439 - map.get(s));
              //  map.remove(s);
            }
        }
        int idx = 0;
        int[] answer = new int[tree.size()];
         for (int val : tree.values()) {
             //System.out.println(val);
            
            answer[idx] = fees[1];
            if (val > fees[0]) {
                answer[idx] += Math.ceil((val - fees[0]) / (double) fees[2]) * fees[3];
            }
            idx++;
        }
        return answer;
    }
    public int convert(String time){
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}