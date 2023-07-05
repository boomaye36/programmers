import java.util.*;
import java.io.*;
class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        while (n != 0){
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();
        String[] slist = sb.toString().split("0");
        
        //System.out.println(mod);
        for (String s : slist){
            if (s.equals("")) continue;
            if (isPrime(Long.parseLong(s))) answer++;
        }
        return answer;
    }
    
    public boolean isPrime(long n){
        if (n == 1) return false;
        long a = (long)Math.sqrt(n) + 1;
        for (int x = 2; x < a; x++){
            if (n % x == 0) return false; 
        }
        return true;
    }
    
}