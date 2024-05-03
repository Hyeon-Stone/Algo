import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    static class Node {
        String word;
        Integer count;

        public Node(String word, Integer count) {
            this.word = word;
            this.count = count;
        }
        
        public String getWord() {
            return this.word;
        }
        
        public Integer getCount() {
            return this.count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        
        List<String> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));
        
        while(!queue.isEmpty()) {
            Node pollNode = queue.poll();
            String pollWord = pollNode.getWord();
            Integer pollCount = pollNode.getCount();
            
            if (pollWord.equals(target)) {
                return pollCount;
            }
                
            for (String word : words) {
                if (!Arrays.asList(visited).contains(word) && checkOneWord(pollWord, word)) {
                    visited.add(word);
                    queue.offer(new Node(word, pollCount+1));
                }
            }
        }
        
        return 0;
    }
    
    private Boolean checkOneWord(String word1, String word2) {
        int checkCount = 0;
        for (int i =0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                checkCount++;
            }   
        }
        
        return checkCount == 1;
    }
}