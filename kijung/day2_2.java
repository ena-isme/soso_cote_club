import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[1] = true;
        method(1, 1, 1, 0);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void method(int start, int now, int count, int cost) {
        if (arr[now][start] != 0 && count == N) {
            result = Math.min(result, cost + arr[now][start]);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (arr[now][i] > 0 && !visited[i]) {
                visited[i] = true;
                method(start, i, count + 1, cost + arr[now][i]);
                visited[i] = false;
            }
        }
    }
}