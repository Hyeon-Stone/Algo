class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            }
            
            int offset = Character.isUpperCase(c) ? 'A' : 'a';
            int position = c - offset;
            position = (position + n) % 26;
            sb.append((char) (offset + position));
        }
        
        return sb.toString();
    }
}