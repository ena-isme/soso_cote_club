import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;

            while (!stack.isEmpty() && stack.peek().height < height) {
                result += stack.pop().count;
            }

            if (stack.isEmpty()) {
                stack.push(new Pair(height, count));
            } else {
                if (stack.peek().height == height) {
                    Pair pair = stack.pop();
                    result += pair.count;
                    count = pair.count + 1;

                    if (!stack.isEmpty()) {
                        result += 1;
                    }
                    stack.push(new Pair(height, count));
                } else {
                    result++;
                    stack.push(new Pair(height, count));
                }
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    static class Pair {
        int height;
        int count;

        public Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
}