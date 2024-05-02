import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    public boolean solution(String[] phone_book) {
        List<String> phoneBookList = Arrays.stream(phone_book)
            .sorted()
            .collect(Collectors.toList());
            
        for (int i = 0; i<phoneBookList.size()-1; i++) {
            String frontPhone = phoneBookList.get(i);
            String backPhone = phoneBookList.get(i+1);
            
            if (backPhone.startsWith(frontPhone)) return false;
        }
        return true;
    }
}