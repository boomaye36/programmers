import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    static int n, m ;
    static int[] nums, perms;
    static boolean[] visit;
    static LinkedHashSet<String> ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         m = sc.nextInt();
         nums = new int[n];
         perms = new int[m];
         visit = new boolean[n];
         ans = new LinkedHashSet<>();
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
            Arrays.sort(nums);
            perm(0);
            ans.forEach(System.out::println);


    }
    static void perm(int cnt){
        if (cnt == m){
            StringBuilder sb = new StringBuilder();
            for (int p : perms) sb.append(p).append(" ");
            ans.add(sb.toString());
            return;
        }
        for(int i = 0; i < n; i++){
            if(visit[i]) continue;
            visit[i] = true;
            perms[cnt] = nums[i];
            perm(cnt+1);
            visit[i] = false;
        }
    }
}
