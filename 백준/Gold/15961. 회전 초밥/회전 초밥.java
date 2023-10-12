import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
      int n =sc.nextInt();
      int d = sc.nextInt();
      int k = sc.nextInt();
      int c = sc.nextInt();
      int[] arr = new int[n];
      int[] sushi = new int[n];
      int max = 0;
      int cnt = 0;
      for (int i = 0; i < n; i++) sushi[i] = sc.nextInt();
      int[] check = new int[d+1];
      for (int i = 0; i < k; i++){
          if(check[sushi[i]] == 0) cnt++;
          check[sushi[i]]++;
      }
      max = cnt;
      int st = 1, end = k;
      while(true){
          if(check[sushi[st-1]] == 1) cnt--;
          check[sushi[st-1]]--;
          if(check[sushi[end]] == 0) cnt++;
          check[sushi[end]]++;

          if(check[c] == 0) max = Math.max(max, cnt+1);
          else max = Math.max(max, cnt);
          st++;
          end++;
          if(end == n) end = 0;
          if(st == n) break;


      }
        System.out.println(max);
    }
}
