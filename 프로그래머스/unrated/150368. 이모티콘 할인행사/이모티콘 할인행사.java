class Solution {
    static int maxsub;
    static int maxsale;
    static int[] sale = {10, 20, 30, 40};
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        emo(0, emoticons.length, new int[emoticons.length], users, emoticons);
        answer[0] = maxsub;
        answer[1] = maxsale;
        return answer;
    }
    static void emo(int cnt, int emolen, int[] input, int[][]users, int[] emoticons){
        if (cnt == emolen){
            int subnum = 0;
            int price = 0;
            for (int[] user : users){
                int discountrate = user[0];
                int userprice = user[1];
                int sum = 0;
                for (int i = 0; i < input.length; i++){
                    if (input[i] >= discountrate){
                        sum += emoticons[i] * (100 - input[i]) / 100;
                    }
                }
                if (sum >= userprice) subnum++;
                else price += sum;
            }
            if (maxsub < subnum){
                maxsub = subnum;
                maxsale = price;
            }
            else if (maxsub == subnum){
                maxsale = Math.max(maxsale, price);
            }
            return;
        }
        for (int i = 0; i < 4; i++){
            input[cnt] = sale[i];
            emo(cnt+1, emolen, input, users, emoticons);
        }
    }
}