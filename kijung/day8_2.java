import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Comparator;

import java.lang.StringBuilder;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();

            int Q = Integer.parseInt(br.readLine());
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if ("I".equals(op)) {
                    maxQueue.offer(n);
                    minQueue.offer(n);
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (1 == n) {
                        remove(maxQueue, map);
                    } else {
                        remove(minQueue, map);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int max = get(maxQueue, map);
                int min = get(minQueue, map);
                sb.append(max).append(" ").append(min).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void remove(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (map.getOrDefault(value, 0) > 0) {
                map.put(value, map.get(value) - 1);
                if (map.get(value) == 0) {
                    map.remove(value);
                }
                break;
            }
        }
    }

    private static int get(PriorityQueue<Integer> queue, HashMap<Integer, Integer> map) {
        while (!queue.isEmpty() && map.getOrDefault(queue.peek(), 0) == 0) {
            queue.poll();
        }

        return queue.peek();
    }
}