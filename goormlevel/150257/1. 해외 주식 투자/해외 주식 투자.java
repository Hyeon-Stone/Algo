import java.io.*;
import java.util.*;
import java.lang.*;
class Main {
	
	private static class Stock implements Comparable<Stock>{
		int id;
		double cnt;
		int price;
		
		public Stock(int id, double cnt, int price) {
			this.id = id;
			this.cnt = cnt;
			this.price = price;
		}
		
		@Override
		public int compareTo(Stock other) {
			double thisPrice = Math.floor((this.cnt * this.price * 10)) / 10.0;
			double otherPrice = Math.floor((other.cnt * other.price * 10)) / 10.0;
			if (thisPrice == otherPrice) {
				return this.id - other.id;
			} else if  (thisPrice > otherPrice) {
				return -1;
			} else {
				return 1;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer N = Integer.parseInt(br.readLine());
		Queue<Stock> queue = new PriorityQueue<>();
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue.offer(new Stock(i, Double.parseDouble(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Stock stock = queue.poll();
			sb.append(stock.id + " ");
		}
		sb.deleteCharAt(sb.length() -1);
		System.out.println(sb.toString());
	}
}