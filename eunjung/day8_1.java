import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class day8_1 {

    public static int N;
    public static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        // dp[i][h] = i번째 사람부터 볼 때, 체력이 h 남아있을 때 얻을 수 있는 최대 기쁨
        int[][] dp = new int[N + 1][101];

        // 뒤에서부터 채우기 (bottom-up)
        for (int i = N - 1; i >= 0; i--) {
            Person p = people.get(i);
            for (int h = 1; h <= 100; h++) { // 체력 0은 죽음이므로 제외
                // 인사하지 않는 경우
                dp[i][h] = dp[i + 1][h];
                // 인사하는 경우 (체력이 남아 있어야 함)
                if (h - p.health > 0) {
                    dp[i][h] = Math.max(dp[i][h],
                            dp[i + 1][h - p.health] + p.joy);
                }
            }
        }

        // 처음: 0번째 사람부터, 체력 100
        System.out.println(dp[0][100]);
    }

    private static void input() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        StringTokenizer stHealth = new StringTokenizer(bf.readLine());
        StringTokenizer stJoy = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(stHealth.nextToken());
            int j = Integer.parseInt(stJoy.nextToken());
            people.add(new Person(h, j));
        }
    }
}

class Person {
    public int health;
    public int joy;

    public Person(int health, int joy) {
        this.health = health;
        this.joy = joy;
    }
}
