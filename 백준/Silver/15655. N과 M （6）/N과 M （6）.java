import java.io.*;
import java.util.*;

public class Main {
    private static int n;
    private static int m;
    private static int[] arr;
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
        permutation(new int[m], new boolean[n], 0,0);
    }

    private static void permutation(int[] out, boolean[] visited, int start, int depth) {
        if (depth == m) {
            for (int a : out) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(out, visited, i+1, depth+1);
                visited[i] = false;
            }
        }
    }

}