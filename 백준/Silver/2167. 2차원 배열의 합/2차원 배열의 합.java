import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0;  j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        for (int I = 0; I < k; I++){
            int sum = 0;
            int i = sc.nextInt()-1;
            int j = sc.nextInt()-1;
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            for (int l = i; l <= x; l++){
                for (int t = j; t <= y; t++) sum += arr[l][t];
            }
            System.out.println(sum);

        }
    }
}
