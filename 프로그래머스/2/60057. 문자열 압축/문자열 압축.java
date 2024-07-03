import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            Integer len = compress(s, length);
            min = Math.min(len, min);
        }
        return min;
    }
    
    private List<String> tokenize(String s, Integer length) {
        List<String> tokenList = new ArrayList<>();
        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > s.length()) {
                endIndex = s.length();
            }
            
            tokenList.add(s.substring(startIndex, endIndex));
        }
        
        return tokenList;
    }
    
    private Integer compress(String s, Integer length) {
        StringBuilder sb = new StringBuilder();
        
        String last = "";
        Integer count = 0;
        
        for (String token : tokenize(s, length)) {
            if (token.equals(last)) {
                count++;
                continue;
            }
            
            if (count > 1) {
                sb.append(count);
            }
            sb.append(last);
            last = token;
            count = 1;
        }
        
        if (count > 1) {
            sb.append(count);
        }
        sb.append(last);
        
        return sb.length();
    }
}