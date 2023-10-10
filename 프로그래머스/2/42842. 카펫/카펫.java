import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;

        // 가로 길이를 3부터 시작하여 전체 타일 수를 나누어가며 검사
        for (int width = 3; width <= sum / width; width++) {
            if (sum % width == 0) {
                int height = sum / width;

                // 주어진 brown과 yellow의 개수를 만족하는지 확인
                if ((width - 2) * (height - 2) == yellow) {
                    answer[0] = height;
                    answer[1] = width;
                    break;
                }
            }
        }

        return answer;
    }
}
