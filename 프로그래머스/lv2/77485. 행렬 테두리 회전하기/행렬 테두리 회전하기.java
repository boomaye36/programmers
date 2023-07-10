import java.util.*;
class Solution {
    public static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows + 1][columns + 1];
        int cnt = 1;
        for (int i = 1; i <= rows; i++){
            for (int j = 1; j <= columns; j++){
                arr[i][j] = cnt;
                cnt++;
            }
        }
        for (int i = 0; i < queries.length; i++) answer[i] = solve(queries[i]);
        
        return answer;
    }
    public static int solve(int[] query){
        int r1 = query[0];
        int c1 = query[1];
        int r2 = query[2];
        int c2 = query[3];
        
        int first = arr[r1][c1];
        int min = first;
        for (int i = r1; i < r2; i++){ //좌
            arr[i][c1] = arr[i + 1][c1];
            min = Math.min(min, arr[i][c1]);
        }
        for (int i = c1; i < c2; i++){ //하
            arr[r2][i] = arr[r2][i + 1];
            min = Math.min(min, arr[r2][i]);
        }
         for (int i = r2; i > r1; i--){ //우
            arr[i][c2] = arr[i - 1][c2];
            min = Math.min(min, arr[i][c2]);
        }
        for (int i = c2; i > c1; i--){ //상
            arr[r1][i] = arr[r1][i - 1];
            min = Math.min(min, arr[r1][i]);    
        }
        arr[r1][c1 + 1] = first;
        return min;
    }
}