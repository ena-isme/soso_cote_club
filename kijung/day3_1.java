import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.lang.StringBuilder;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Pair[] pairs = new Pair[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int M = Integer.parseInt(st.nextToken());
                pairs[i] = new Pair(S, M);
            }

            Arrays.sort(pairs);

            int count = 1;
            int min = pairs[0].M;

            for (int i = 1; i < N; i++) {
                if (pairs[i].M < min) {
                    count++;
                    min = pairs[i].M;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static class Pair implements Comparable<Pair> {
        int S, M;

        public Pair(int S, int M) {
            this.S = S;
            this.M = M;
        }

        @Override
        public int compareTo(Pair o) {
            return S - o.S;
        }
    }
}