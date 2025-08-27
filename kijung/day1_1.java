//http://boj.kr/8b513be94bd74fa1aa717a7fcad9a8aa

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.lang.StringBuilder;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        StringBuilder sb = new StringBuilder();
        method(1, 0, N, M, arr, sb);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void method(int at, int depth, int N, int M, int[] arr, StringBuilder sb) {
        if (M == depth) {
            for (int value : arr) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            method(i, depth + 1, N, M, arr, sb);
        }
    }
}