#include <stdio.h>
#include <vector>
using namespace std;

// 12865. 평범한 배낭
 
int main() {
    int N, K;
    scanf("%d %d", &N, &K);

    vector<pair<int, int>> ns;
    vector<int> dp(K + 1);

    for (int i = 0; i < N; i++) {
        int w, v;
        scanf("%d %d", &w, &v);
        ns.push_back(make_pair(w, v));
    }

    for (int i = 0; i < N; i++) {
		for (int j = K; j >= ns[i].first; j--) {
			dp[j] = max(dp[j], dp[j - ns[i].first] + ns[i].second);
		}
	}

    printf("%d", dp[K]);

    return 0;
}