class 주식가격 {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans[i]++;
                if (prices[i] > prices[j])
                    break;

            }
        }

        return ans;
    }
}