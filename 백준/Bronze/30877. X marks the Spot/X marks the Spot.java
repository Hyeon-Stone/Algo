import java.io.*;
import java.util.*;
import java.lang.StringBuilder;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        String NString = bufferReader.readLine();
        int N = Integer.parseInt(NString);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String line = bufferReader.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String S = st.nextToken();
            String T = st.nextToken();
            String t = "";
            for(int j = 0; j < S.length(); j++) {
                char c = S.charAt(j);
                if (c == 'x' || c == 'X') {
                    t = String.valueOf(T.charAt(j)).toUpperCase();
                    break;
                }
            }
            stringBuilder.append(t);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(stringBuilder.toString());
        bw.flush();
        bw.close();
    }
}
