import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Pair>[] graph = new ArrayList[D + 1];
        for (int i = 0; i <= D; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (end <= D) {
                graph[start].add(new Pair(end, value));
            }
        }

        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < D; i++) {
            if (dp[i + 1] > dp[i] + 1) {
                dp[i + 1] = dp[i] + 1;
            }

            for (Pair pair: graph[i]) {
                if (dp[pair.node] > dp[i] + pair.value) {
                    dp[pair.node] = dp[i] + pair.value;
                }
            }
        }

        bw.write(dp[D] + "");
        bw.flush();
        bw.close();
    }

    static class Pair {
        int node, value;

        public Pair(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}