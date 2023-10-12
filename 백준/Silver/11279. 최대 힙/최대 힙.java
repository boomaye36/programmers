import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            int x = sc.nextInt();
            if (x == 0) {
                if (q.isEmpty()) sb.append(0).append("\n");
                else  sb.append(q.poll()).append("\n");
            }
            else q.add(x);
        }
        System.out.println(sb.toString());
    }
}
