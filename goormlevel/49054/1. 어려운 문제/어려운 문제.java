import java.io.*;
import java.math.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long input = Long.parseLong(br.readLine());
		BigInteger sum = factorial(input);
		while (true) {
			if (sum.compareTo(BigInteger.valueOf(10)) == -1) {
				System.out.println(sum.toString());
				return;
			}
			sum = third(sum);
		}
	}
	
	private static BigInteger third(BigInteger num) {
		BigInteger sum = BigInteger.valueOf(0);
		 while(num.compareTo(BigInteger.valueOf(0)) != 0){
				//num을 10으로 나눈 나머지를 sum에 더한다.
			 sum = sum.add(num.remainder(BigInteger.valueOf(10)));
				//num을 10으로 나눈 값을 다시 num에 저장한다.
				num = num.divide(BigInteger.valueOf(10));
			}
		return sum;
	}
	
	public static BigInteger factorial(long num) {
		if(num <= 1) {
			return BigInteger.ONE;
		} else {
			if (num % 10 == 0) {
				return factorial(num-1);
			} 
			return factorial(num-1).multiply(new BigInteger("" + num));
		}
	}
}

       