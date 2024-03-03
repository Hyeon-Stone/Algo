import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Solution {
    public boolean solution(String[] phone_book) {
        List<String> phoneBook = Arrays.stream(phone_book)
            .sorted()
            .collect(Collectors.toList());
        
        for (int i=0; i<phoneBook.size()-1; i++) {
            String number1 = phoneBook.get(i);
            String number2 = phoneBook.get(i+1);
            
            if (number2.startsWith(number1)) return false;
        }
        return true;
    }
}