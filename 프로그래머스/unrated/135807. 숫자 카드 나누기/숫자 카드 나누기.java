import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        for (int i = 0; i < arrayA.length; i++){
            boolean flag = true;
            if (gcdA >= gcdB){
               if (div(arrayB[i], gcdA)) {
                    return 0;
                }
                else if (!div(arrayB[i], gcdA)) answer = gcdA;
            }
            

            else{
                if (div(arrayA[i], gcdB)) {
                    return 0;
                }
                else if (!div(arrayA[i], gcdB)) answer = gcdB;
            }
        }         
        return answer;
    }
    
    public int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public boolean div(int a, int b){
        if (a % b == 0) return true;
        else return false;
    }
}