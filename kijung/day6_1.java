import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1];
        int unique = 0;
        for (int i = 0; i < k; i++) {
            if (count[belt[i]] == 0) {
                unique++;
            }
            count[belt[i]]++;
        }

        int result = unique + (count[c] == 0 ? 1 : 0);

        for (int i = 1; i < N; i++) {
            int remove = belt[i - 1];
            count[remove]--;
            if (count[remove] == 0) {
                unique--;
            }

            int add = belt[(i + k - 1) % N];
            if (count[add] == 0) {
                unique++;
            }
            count[add]++;

            result = Math.max(result, unique + (count[c] == 0 ? 1 : 0));
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}