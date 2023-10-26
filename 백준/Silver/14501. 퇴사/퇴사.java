import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] day = new int[n];
        int [] pay = new int[n];
        int [] dp = new int[n+1];
        for (int i = 0; i < n; i++){
            day[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++){
            if (i + day[i] <= n){
                dp[i + day[i]] = Math.max(dp[i + day[i]], dp[i] + pay[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }
        System.out.println(dp[n]);
    }
}
