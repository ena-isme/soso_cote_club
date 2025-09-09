#include <stdio.h>
#include <vector>
using namespace std;

int main() {
    int N; 
    scanf("%d", &N);

    vector<int> value(N + 1);

    for (int i = 1; i <= N; i ++) {
        int a, b, c;
        scanf("%d %d %d", &a, &b, &c);
        value[i] = c;
    }

    vector<long long> dp(N + 1);

    dp[1] = value[1];
    dp[2] = max(value[1], value[2]);

    for (int i = 3; i <= N; i ++) {
        dp[i] = max(dp[i - 1], dp[i - 2] + value[i]);
    }

    printf("%lld", dp[N]);

    return 0;
}