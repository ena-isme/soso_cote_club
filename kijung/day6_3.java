import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String temp;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while((temp = br.readLine()) != null) {
            st = new StringTokenizer(temp);
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num == 0 ? 0 : (num < 0 ? -1 : 1);
            }

            tree = new int[N * 4];
            init(0, N - 1, 1);

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                String operate = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if ("C".equals(operate)) {
                    int num = b == 0 ? 0 : (b < 0 ? -1 : 1);
                    update(0, N - 1, 1, a - 1, num);
                } else {
                    int result = mul(0, N - 1, 1, a - 1, b - 1);
                    if (result < 0) {
                        sb.append("-");
                    } else if (result > 0) {
                        sb.append("+");
                    } else {
                        sb.append("0");
                    }
                }
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int init(int start, int end, int node) {
        if(start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;

        return tree[node] = init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1);
    }

    public static int mul(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return mul(start, mid, node * 2, left, right) * mul(mid + 1, end, (node * 2) + 1, left, right);

    }

    public static void update(int start, int end, int node, int index, int diff) {
        if(index < start || index > end) return;

        if (start == end) {
            tree[node] = diff;
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, (node * 2) + 1, index, diff);
        tree[node] = tree[node * 2] * tree[(node * 2) + 1];
    }
}