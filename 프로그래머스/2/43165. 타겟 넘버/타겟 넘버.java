import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        for (Integer num : numbers) {
            Queue<Integer> temp = new LinkedList<>();
            while(!queue.isEmpty()) {
                Integer pop = queue.poll();
                temp.offer(pop + num);
                temp.offer(pop - num);
            }
            queue = temp;
        }
        
        return Collections.frequency(queue, target);
    }
}