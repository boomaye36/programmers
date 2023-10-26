import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] arr = new int[n][m];
        int [][] arrSum = new int[n+1][m+1];
        for (int i = 0; i < n; i++){
            for (int j = 0;  j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++){
            for (int j = 1;  j <= m; j++){
                arrSum[i][j] = arr[i-1][j-1] + arrSum[i-1][j] + arrSum[i][j-1] - arrSum[i-1][j-1];
            }
        }
        int k = sc.nextInt();
        for (int I = 0; I < k; I++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
//            for (int l = i; l <= x; l++){
//                for (int t = j; t <= y; t++) sum += arr[l][t];
//            }
            int sum = arrSum[x][y] - arrSum[x][j-1] - arrSum[i-1][y] + arrSum[i-1][j-1];
            System.out.println(sum);

        }
    }
}
