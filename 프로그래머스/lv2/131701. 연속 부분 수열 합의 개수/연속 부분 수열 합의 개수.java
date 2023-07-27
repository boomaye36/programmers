import java.util.*;
class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int idx = 0;
        int sum = 0;
        int[] ele = new int[elements.length * 2];
        for (int i = 0; i < ele.length; i++){
            if (i >= elements.length){
                ele[i] = elements[i-elements.length];
            }
            else ele[i] = elements[i];
        }
        while (true){
            if (idx == elements.length){
                for (int i = 0; i < elements.length; i++) sum += elements[i];
                set.add(sum);
                break;
            }
            for (int i = 0; i < elements.length; i++){
                for (int j = 0; j <= idx; j++){
                    sum += ele[i+j];
                }
                set.add(sum);
                sum = 0;
            }
            idx++;

        }
        return set.size();
    }
}