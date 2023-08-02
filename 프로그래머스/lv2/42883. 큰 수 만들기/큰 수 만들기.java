import java.util.*;

class Solution {
    public String solution(String number, int k) {
//         char[] c = number.toCharArray();
//         Arrays.sort(c);

//         String tmp = new String(c);
//        // System.out.println(tmp);
//         char[] desc = tmp.toCharArray();
//         ArrayList<Character> list = new ArrayList<>();
//         for (char ch : desc) list.add(ch);
//         for (int i = 0; i < k; i++){
//             list.remove(i);
//         }
//         String s = "";
//         for (char ch : list) s += new String(ch);
        
        
//         return s;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max = 0;
        for(int i=0; i<number.length() - k; i++) {
            max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
