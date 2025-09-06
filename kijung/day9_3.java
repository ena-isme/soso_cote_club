import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String temp;

        while (!"0".equals(temp = br.readLine())) {
            Stack<Integer> stack = new Stack<>();
            st = new StringTokenizer(temp);
            int N = Integer.parseInt(st.nextToken());
            long[] arr = new long[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            long max = 0;

            for (int i = 0; i < N; i++) {
                while ((!stack.isEmpty()) && arr[stack.peek()] >= arr[i]) {
                    long height = arr[stack.pop()];
                    long width = (stack.isEmpty()) ? i : (i - stack.peek() - 1);
                    max = Math.max(max, height * width);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                long height = arr[stack.pop()];
                long width = (stack.isEmpty()) ? N : (N - stack.peek() - 1);
                max = Math.max(max, height * width);
            }

            sb.append(max).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}