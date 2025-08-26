import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// baekjoon 1021
public class day2_1 {
    public static int N, M;
    public static int count = 0;
    public static LinkedList<Integer> deq = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            deq.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            // ...
        }

        System.out.println(count);
    }

}