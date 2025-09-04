#include <stdio.h>
#include <vector>
using namespace std;

int dp_2748() {
    int N;
    scanf("%d", &N);
    vector<long long> dp(N+1);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= N; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    printf("%lld", dp[N]);
}
