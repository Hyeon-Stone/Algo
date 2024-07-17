import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited;
    private static int r = 6;
    private static int n;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                if (n == 0) {
                    break;
                }

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(st.nextToken());
                }
                visited = new boolean[47];
                comb(arr, 0, 0);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    private static void comb(int[] arr, int start, int depth) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[arr[i]]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < arr.length; i++) {
            if (!visited[arr[i]]) {
                visited[arr[i]] = true;
                comb(arr, i+1, depth+1);
                visited[arr[i]] = false;
            }
        }
    }
}