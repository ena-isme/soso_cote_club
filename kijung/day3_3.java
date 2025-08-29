import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;

import java.lang.StringBuilder;

public class Main {

    static int V, E;
    static List<Integer>[] graph;

    static int[] disc, low;
    static boolean[] onStack;
    static Deque<Integer> stack;
    static int counter;
    static List<List<Integer>> scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        for (int i = 1;  i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        disc = new int[V + 1];
        low = new int[V + 1];
        onStack = new boolean[V + 1];
        stack = new ArrayDeque<>();
        scc = new ArrayList<>();
        counter = 0;

        for (int i = 1; i <= V; i++) {
            if (disc[i] == 0) {
                DFS(i);
            }
        }

        for (List<Integer> temp : scc) {
            Collections.sort(temp);
        }

        scc.sort(Comparator.comparingInt(o -> o.get(0)));

        StringBuilder sb = new StringBuilder();
        sb.append(scc.size()).append("\n");
        for (List<Integer> temp : scc) {
            for (int v : temp) {
                sb.append(v).append(" ");
            }
            sb.append(-1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void DFS(int u) {
        disc[u] = low[u] = ++counter;
        stack.push(u);
        onStack[u] = true;

        for (int v : graph[u]) {
            if (disc[v] == 0) {
                DFS(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (onStack[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> temp = new ArrayList<>();
            while (true) {
                int w = stack.pop();
                onStack[w] = false;
                temp.add(w);
                if (w == u) break;
            }
            scc.add(temp);
        }
    }
}