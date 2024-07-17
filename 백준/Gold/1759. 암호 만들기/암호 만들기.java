import java.io.*;
import java.util.*;

public class Main {
    private static int l;
    private static int c;
    private static String[] alpha;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        alpha = new String[c];
        for (int i = 0; i < c; i++) {
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);
        for (int i = 0; i < alpha.length; i++) {
            visited = new boolean[c];
            visited[i] = true;
            dfs(i, alpha[i]);
        }

    }

    private static void dfs(int start, String word) {
        if (word.length() == l) {
            int ja = 0;
            int mo = 0;
            for (char c : word.toCharArray()) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    mo++;
                }else {
                    ja++;
                }
            }
            if (mo >= 1 && ja >=2) {
                System.out.println(word);
            }
        }

        for (int i = start; i <alpha.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, word+alpha[i]);
                visited[i] = false;
            }
        }
    }
}