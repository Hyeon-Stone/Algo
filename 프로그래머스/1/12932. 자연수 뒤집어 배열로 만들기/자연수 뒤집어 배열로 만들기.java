import java.util.Arrays;
class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        String reversedString = new StringBuilder(str).reverse().toString();
        return Arrays.stream(reversedString.split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}