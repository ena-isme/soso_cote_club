#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;

// dp구만..

int main() {
    int N; // 근무 일수
    scanf("%d", &N);

    vector<pair<int, int>> v(N + 1); 

    for(int i = 1; i <= N; i++) {
        int t, p;
        scanf("%d %d", &t, &p);
        v[i] = make_pair(t, p);
    }

    vector<int> dp(N + 2);

    for (int i = N; i >= 1; i--) {
        if (i + v[i].first > N + 1) {
            // 근무 일수 초과시 -> 상담 불가
            dp[i] = dp[i + 1];
        } else {
            // 내일의 dp VS 오늘 근무의 이익 + 오늘 근무가 끝나고 다음 근무의 dp 
            dp[i] = max(dp[i + 1], dp[i + v[i].first] + v[i].second);
        }
    }

    printf("%d", dp[1]);

    return 0;
}