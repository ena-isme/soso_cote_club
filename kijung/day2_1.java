import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenzier;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        int result = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            int index = deque.indexOf(target);
            int mid = deque.size() / 2;

            if (index <= mid) {
                while (deque.peek() != target) {
                    left(deque);
                    result++;
                }
            } else {
                while (deque.peek() != target) {
                    right(deque);
                    result++;
                }
            }

            deque.removeFirst();
        }

        bw.write(result + "");
    }

    public static void left(Deque<Integer> deque) {
        deque.addLast(deque.pollFirst());
    }

    public static void right(Deque<Integer> deque) {
        deque.addFirst(deque.pollLast());
    }
}