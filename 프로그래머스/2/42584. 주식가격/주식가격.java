class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i=0; i<prices.length-1; i++) {
            Integer currnetPrice = prices[i];
                for (int j=i+1; j<prices.length; j++) {
                    answer[i] += 1;
                    if (currnetPrice > prices[j]) {
                        break;
                    }
                }
        }
        return answer;
    }
}