#include <stdio.h>
#include <vector>
using namespace std;

int main() {
    int N;
    scanf("%d", &N);

    // 사람에 대한 J, L pair 배열
    vector<pair<int, int>> JL;  
    vector<int> dp(101);

    for (int i = 0 ; i < N; i ++) {
        int l;
        scanf("%d", &l);
        JL.push_back(make_pair(0, l));
    }

    for (int i = 0; i < N; i ++) {
        int j;
        scanf("%d", &j);
        JL[i].first = j;
    }

    // 얻는 기쁨을 기준으로 오름차순 정렬
    // 람다식 활용하는 방법을 까먹었음
    sort(JL.begin(), JL.end());

    // 세준이의 현재 기쁨, 체력
    int joy = 0;
    int lost = 100;

    for (int i = 0; i < N; i++) {
		for (int j = 100; j >= JL[i].second; j--) {
			dp[j] = max(dp[j], dp[j - JL[i].second] + JL[i].first);
		}
	}

    printf("%d", dp[99]);
 
    return 0;
}