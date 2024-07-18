import java.io.*;
import java.util.*;
class Main {
	
	private static class Block{
		int x;
		int y;
		int score;
		
		public Block(int x, int y, int score) {
			this.x = x;
			this.y = y;
			this.score = score;
		}
	}
	
	private static Stack<Block> stack = new Stack<>();
	private static int x = 0;
	private static int y = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer input = Integer.parseInt(br.readLine());
		char[] direction = br.readLine().toCharArray();
		stack.push(new Block(x,y,1));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < input; i++) {
			if (direction[i] == 'R') {
				x++;
			} else if (direction[i] == 'L') {
				x--;
			} else if (direction[i] == 'U') {
				y--;
			} else {
				y++;
			}
			
			search();
			stack.push(new Block(x,y,Integer.parseInt(st.nextToken())));
		}
		
		System.out.println(getScore());
	}
	
	private static void search() {
		Stack<Block> tempStack = new Stack<>();
		
		while(!stack.isEmpty()) {
			Block before = stack.pop();
			tempStack.push(before);
			if (before.x == x && before.y == y) {
				return;
			}
		}
		
		while(!tempStack.isEmpty()) {
			Block temp = tempStack.pop();
			stack.push(temp);
		}
		return;
	}
	
	private static Integer getScore() {
		int sum = 0;
		while(!stack.isEmpty()) {
			Block before = stack.pop();
			sum += before.score;
		}
		return sum;
	}
}