class Solution {
    public int solution(int n) {
        int answer = 0;
        String three = Integer.toString(n, 3);
        String reversedThree = new StringBuilder(three).reverse().toString();
        return Integer.valueOf(reversedThree, 3);
    }
}