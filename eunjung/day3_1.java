import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// baekjoon 1946
public class day3_1 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] rank = new int[n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rank[a-1] = b;
            }

            int count = 1;
            int bestInterview = rank[0];
            for(int i=1; i<n; i++) {
                if (bestInterview > rank[i]) {
                    count++;
                    bestInterview = rank[i];
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}