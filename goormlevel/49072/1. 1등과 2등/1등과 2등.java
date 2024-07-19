import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int index = input.indexOf("12");
	 	if(input.length()==1){
			 System.out.println("No");
			 return;
		}
		
		if (index != -1) {
			input = input.substring(0, index) + input.substring(index+2, input.length());
		}
		
		index = input.indexOf("21");
		
		if (index == -1) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}