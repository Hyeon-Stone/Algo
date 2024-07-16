import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int n;
    private static int m;
    private static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        // 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int sum = arr[i];
            int cnt = 1;
            if (sum >= m) {
                answer = Math.min(1, answer);
                break;
            }
            for (int j = i+1; j < n; j++) {
                cnt++;
                if (sum + arr[j] >= m) {
                    answer = Math.min(cnt, answer);
                    break;
                }

                sum += arr[j];
            }

        }
        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        System.out.println(answer);
    }
}