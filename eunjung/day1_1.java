import java.io.IOException;
import java.util.Scanner;

// baekjoon 15652
public class day1_1 {

    public static StringBuilder sb = new StringBuilder();
    public static int n;
    public static int m;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        arr = new int[m];

        dfs(1,0);

        System.out.println(sb);
    }

    private static void dfs(int k,int depth) {
        if(depth == m) {
            for(int i : arr)
                sb.append(i).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = k; i < n + 1; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }

}