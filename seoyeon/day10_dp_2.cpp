#include <stdio.h>
#include <vector>
using namespace std;

int main() {
    int T;
    scanf("%d", &T);

    for (int i = 0; i < T; i ++) {
        int N;
        scanf("%d", &N);

        vector<int> arr(N + 1);
        for (int j = 1; j <= N; j ++) {
            int a;
            scanf("%d", &a);
            arr[j] = a;
        }

        vector<int> dp(N + 1);

        // dp 점화식 세우기
        // 새로 배열 만들기 VS 기존 배열에 추가
        for (int j = 1; j <= N; j ++) {
            dp[j] = max(arr[j], dp[j - 1] + arr[j]);
        }

        // dp 배열 내 최댓값 찾기
        int temp = dp[1];
        for (int j = 2; j <= N; j ++) {
            if(temp < dp[j]) temp = dp[j];
        }

        printf("%d\n", temp);
    }

    return 0;
}