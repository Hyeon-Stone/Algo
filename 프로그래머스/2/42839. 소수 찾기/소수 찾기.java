import java.util.*;
class Solution {
    
    static Set<Integer> numberSet = new HashSet<>();
    static boolean[] checkList = new boolean[7];
    int answer = 0;
    public int solution(String numbers) {
        
        for (int i =0; i < numbers.length(); i++) {
            dfs(numbers, "", i+1);
        }
        
        return answer;
    }
    
    private void dfs(String numbers, String number, int size) {
        if (number.length() == size) {
            Integer num = Integer.parseInt(number);
            if (!numberSet.contains(num)) {
                if (isPrime(num)) {
                    answer +=1;   
                }
                numberSet.add(num);   
            }
        }
        
        for (int i = 0; i < numbers.length(); i ++) {
            if (!checkList[i]) {
                checkList[i] = true;
                dfs(numbers, number + numbers.charAt(i), size);
                checkList[i] = false;
            }
        }
    }
    
    private boolean isPrime(Integer num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2;  (i * i) <= num; i ++) {
            if(num % i == 0) 
                return false;
        }
        return true;
    }
}