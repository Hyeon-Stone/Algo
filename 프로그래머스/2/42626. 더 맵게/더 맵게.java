import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int scovil : scoville) {
            queue.add(scovil);
        }
        
        while(queue.peek() < K) {
            if (queue.size() == 1)
                return -1;
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return answer;
    }
}