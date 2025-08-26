import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    static int N, M, result = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int rX = Integer.parseInt(st.nextToken());
        int rY = Integer.parseInt(st.nextToken());
        int rD = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        method(map, rX, rY, rD);

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    public static void method(int[][] map, int rX, int rY, int rD) {

        // 1.현재 칸을 청소한다.
        map[rX][rY] = -1;

        // 2.4칸 중 청소되지 않은 칸 확인 및 이동
        for (int i = 0; i < 4; i++) {
            rD = (rD + 3) % 4;
            int nextX = rX + dx[rD];
            int nextY = rY + dy[rD];
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M){
                if (map[nextX][nextY] == 0) {
                    result++;
                    method(map, nextX, nextY, rD);
                    return;
                }
            }
        }

        // 3.후진하기
        int backD = (rD + 2) % 4;
        int backX = rX + dx[backD];
        int backY = rY + dy[backD];

        if (backX >= 0 && backX < N && backY >= 0 && backY < M && map[backX][backY] != 1) {
            method(map, backX, backY, rD);
        }
    }
}