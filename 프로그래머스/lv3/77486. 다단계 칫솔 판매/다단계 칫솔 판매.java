import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> memberMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < enroll.length; i++){
            memberMap.put(enroll[i], referral[i]);
            indexMap.put(enroll[i], i);
        }
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < seller.length; i++){
            // if (memberMap.get(seller[i]) != "-"){
            //     result[indexMap.get(seller[i])] = amount[i] * 100 
            // }
            String person = seller[i];
            int surplus = 100 * amount[i];
            
            while (!person.equals("-")){
                int parentsurplus = surplus / 10;
                int mine = surplus - parentsurplus;
                answer[indexMap.get(person)] += mine;
                person = memberMap.get(person);
                surplus /= 10;
                if (surplus < 1) break;
            }
        }
        return answer;
    }
}