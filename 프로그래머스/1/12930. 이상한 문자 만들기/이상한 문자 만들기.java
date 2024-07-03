import java.util.List;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        boolean toUpper = true;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
           if (!Character.isAlphabetic(c)) {
                sb.append(c);
                toUpper = true;
                continue;
            }

            if (toUpper) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
            
            toUpper = !toUpper;
        }

        return sb.toString();
    }
}