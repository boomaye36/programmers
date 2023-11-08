import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] visit = new boolean[988];

        for (int i = 0; i < n; i++){
            int num = sc.nextInt();
            int st = sc.nextInt();
            int ball = sc.nextInt();
            int a = num / 100;
            int b = num % 100 / 10;
            int c = num % 100 % 10;

            for (int j = 123; j <= 987; j++){

                int a1 = j / 100;
                int b1 = j % 100 / 10;
                int c1 = j % 100 % 10;
                if (a1 == 0 || b1 == 0 || c1 == 0 || a1 == b1 || a1 == c1 || b1 == c1){
                    visit[j] = true;
                    continue;
                }
                if (visit[j]) continue;
                int st1 = 0;
                int ball1 = 0;
                if (a == a1) st1++;
                if(b == b1) st1++;
                if( c == c1) st1++;
                if (a1 == b || a1 == c) ball1++;
                if( b1 == a || b1 == c) ball1++;
                if( c1 == a || c1 == b) ball1++;
                if (st != st1 || ball != ball1) visit[j] = true;

            }

        }
        int cnt = 0;
        for (int j = 123; j<= 987; j++) {
            if (!visit[j]) cnt++;
        }
        System.out.println(cnt);
    }
}
