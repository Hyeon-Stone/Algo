import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        // 입력
        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            System.out.println(twoPoints(word, 0, 0, word.length()-1));;
        }
    }

    private static int twoPoints(String word, int result, int start, int last) {
        if (result == 2) {
            return result;
        }

        while (start <= last) {
            if (word.charAt(start) == word.charAt(last)) {
                start++;
                last--;
            } else {
                result = Integer.min(twoPoints(word, result+1, start+1, last), twoPoints(word, result+1, start, last-1));
                break;
            }
        }

        return result;
    }
}