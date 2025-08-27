//http://boj.kr/8834c4d446a04461b03850e072529c08

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for (int j = customer; j < C + 101; j++) {
                if (dp[j - customer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - customer] + cost);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            result = Math.min(result, dp[i]);
        }

        bw.write(result + "");
        bw.flush();
    }
}