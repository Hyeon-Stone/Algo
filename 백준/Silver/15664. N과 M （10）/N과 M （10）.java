import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int n;
    private static int m;
    private static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        permutation(new int[m], 0, 0);
        System.out.println(sb);
    }

    private static void permutation(int[] out, int start, int depth) {
        if (depth == m) {
            for (int a : out) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for (int i = start; i < arr.length; i++) {
            int now = arr[i];
            if (before != now) {
                out[depth] = arr[i];
                before = now;
                permutation(out, i+1,depth+1);
            }
        }
    }

}