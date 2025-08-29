import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 6];
        Pair[] arr = new Pair[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i] = new Pair(T, P);
        }

        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);

            Pair pair = arr[i];
            dp[i + pair.T] = Math.max(dp[i] + pair.P, dp[i + pair.T]);
        }

        bw.write(Math.max(dp[N], dp[N + 1]) + "");
        bw.flush();
        bw.close();
    }

    static class Pair {
        int T, P;

        public Pair(int T, int P) {
            this.T = T;
            this.P = P;
        }
    }
}