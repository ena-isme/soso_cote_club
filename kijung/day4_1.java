import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.lang.StringBuilder;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int I = Integer.parseInt(br.readLine());

            int[][] map = new int[I][I];
            boolean[][] visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            visited[sX][sY] = true;
            BFS(sX, sY, eX, eY, map, visited);

            sb.append(map[eX][eY]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void BFS(int sX, int sY, int eX, int eY, int[][] map, boolean[][] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(sX, sY));
        while (!queue.isEmpty()) {
            Pair now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < map[0].length && nextY >= 0 && nextY < map[0].length
                        && !visited[nextX][nextY]) {
                    queue.offer(new Pair(nextX, nextY));
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }

            }
        }
    }

    static class Pair {

        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}