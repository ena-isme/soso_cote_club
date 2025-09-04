import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int V, E, time = 1;
    static List<Integer>[] graph;
    static int[] discover;
    static boolean[] isCurVertax;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        discover = new int[V + 1];
        isCurVertax = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (discover[i] == 0) {
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 1; i <= V; i++) {
            if (isCurVertax[i]) {
                cnt++;
            }
        }
        sb.append(cnt).append("\n");

        for (int i = 1; i <= V; i++) {
            if (isCurVertax[i]) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static int dfs(int vertax, boolean isRoot) {
        discover[vertax] = time++;
        int ret = discover[vertax];
        int child = 0;

        for (int now : graph[vertax]) {
            if (discover[now] == 0) {
                child++;

                int low = dfs(now, false);

                if (!isRoot && low >= discover[vertax]) {
                    isCurVertax[vertax] = true;
                }
                ret = Math.min(ret, low);
            } else {
                ret = Math.min(ret, discover[now]);
            }
        }

        if (isRoot && child >= 2) {
            isCurVertax[vertax] = true;
        }

        return ret;
    }
}