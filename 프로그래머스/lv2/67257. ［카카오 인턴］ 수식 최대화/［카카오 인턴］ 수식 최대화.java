import java.util.*;
class Solution {
    static char[] op = {'-', '*', '+'};
    static long answer = 0;
    public void swap(int a, int b){
        char k = op[a];
        op[a] = op[b];
        op[b] = k;
    }
    public long cal(ArrayList<Long> list, ArrayList<Character> c_list){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < c_list.size(); j++){
                if (c_list.get(j) == op[i]){
                    switch(op[i]){
                        case '-' :
                            list.add(j, list.remove(j) - list.remove(j));
                            break;
                        case '*':
                            list.add(j, list.remove(j) * list.remove(j));
                            break;  
                        case '+':
                            list.add(j, list.remove(j) + list.remove(j));
                            break;
                    }
                    //System.out.println(list);
                    c_list.remove(j--);
                }
            }
        }
        return Math.abs(list.get(0));
    }
    public void count(ArrayList<Long> list, ArrayList<Character> c_list, int level){
        if (level == 3){
            long tmp = cal((ArrayList<Long>)list.clone(), (ArrayList<Character>)c_list.clone());
            answer = Math.max(answer, tmp);
            return;
        }
        for (int i = level; i < 3; i++){
            swap(i, level);
            count(list, c_list, level+1);
            swap(i, level);
        }
    }
    public long solution(String expression) {
        //String[] noString = expression.split("\\+|-|\\*");
       // for (String tmp : str) System.out.println(tmp);
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Character> c_list = new ArrayList<>();
        String num = "";
        for (int i = 0; i < expression.length(); i++){
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') num += expression.charAt(i);
            else {
                list.add(Long.parseLong(num));
                num = "";
                c_list.add(expression.charAt(i));
            }
        }
        list.add(Long.parseLong(num));
        count(list, c_list, 0);
        return answer;
    }
}