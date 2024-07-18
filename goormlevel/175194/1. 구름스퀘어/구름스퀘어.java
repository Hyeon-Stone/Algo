import java.io.*;
import java.util.*;
class Main {
	
	private static class Event implements Comparable<Event>{
		int start;
		int end;
		
		public Event(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Event other) {
			if (this.end == other.end) {
				return this.start - other.start;
			}
			
			return this.end - other.end;
		}
	}
	
	private static Queue<Event> queue = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue.offer(new Event(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		int answer = 0;
		int currentTime = 0;
		while(!queue.isEmpty()) {
			Event event = queue.poll();
			if (event.start > currentTime) {
				answer++;
				currentTime = event.end;
			}
		}
		
		System.out.println(answer);
	}
}