#include <stdio.h>
#include <vector>
using namespace std;

int main() {
    int N, D;
    scanf("%d %d", &N, &D);

    vector<pair<int, int>> shortcut[10001];
    // 도착지점을 기준 -> 도착지점 = pair(시작지점, 길이)

    for (int i = 0; i < N; i ++) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        shortcut[b].push_back(make_pair(a, c));
    }

    vector<int> dp(D + 1);

    for (int i = 1; i <= D; i ++) {
        // 고속도로
        dp[i] = dp[i - 1] + 1;

        // 지름길이 있을 경우 
        for (auto [a, b] : shortcut[i]) {
            dp[i] = min(dp[i], dp[a] + b);
        }
    }

    printf("%d", dp[D]);

    return 0;
}