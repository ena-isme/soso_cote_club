import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean attached = false;
            for (int r = 0; r < 4; r++) {
                if (tryAttach(sticker, board, N, M)) {
                    attached = true;
                    break;
                }
                sticker = rotate(sticker);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result += board[i][j];
            }
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }

    private static boolean tryAttach(int[][] sticker, int[][] board, int N, int M) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int x = 0; x <= N - R; x++) {
            for (int y = 0; y <= M - C; y++) {
                if (canAttach(sticker, board, x, y)) {
                    attach(sticker, board, x, y);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean canAttach(int[][] sticker, int[][] board, int x, int y) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1 && board[x + i][y + j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void attach(int[][] sticker, int[][] board, int x, int y) {
        int R = sticker.length;
        int C = sticker[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] == 1) {
                    board[x + i][y + j] = 1;
                }
            }
        }
    }

    private static int[][] rotate(int[][] sticker) {
        int R = sticker.length;
        int C = sticker[0].length;
        int[][] rotated = new int[C][R];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                rotated[j][R - 1 - i] = sticker[i][j];
            }
        }
        return rotated;
    }
}