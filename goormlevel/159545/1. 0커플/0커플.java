import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer input = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> friendList = new ArrayList<>();
		for (int i = 0; i < input; i++) {
			Integer friend = Integer.parseInt(st.nextToken());
			if (friendList.contains(friend * -1)) {
				friendList.remove(Integer.valueOf(friend*-1));
			} else {
				friendList.add(friend);
			}
		}
		System.out.println(friendList.stream().mapToInt(i -> i).sum());
	}
}