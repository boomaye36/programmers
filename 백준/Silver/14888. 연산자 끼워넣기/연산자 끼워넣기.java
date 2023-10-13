import java.util.Scanner;

public class Main {
    static int[] number;
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] oper = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
        number = new int[n];
        for (int i = 0; i < n; i++) number[i] = sc.nextInt();
        for (int i = 0; i < 4; i++) oper[i] = sc.nextInt();
        dfs(number[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
    static void dfs(int num, int level){
        if(level == n){
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        for (int i = 0; i < 4; i++){
            if (oper[i] > 0){
                oper[i]--;
                switch (i) {

                    case 0:	dfs(num + number[level], level + 1);	break;
                    case 1:	dfs(num - number[level], level + 1);	break;
                    case 2:	dfs(num * number[level], level + 1);	break;
                    case 3:	dfs(num / number[level], level + 1);	break;

                }
                oper[i]++;
            }
        }
    }
}
