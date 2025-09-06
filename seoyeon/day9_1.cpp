#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;

// 방향 그래프
vector<int> belief[10001];
vector<bool> visited(10001);

int dfs(int s) {
    visited[s] = true;
    int count = 1;

    for (int v : belief[s]) {
        if (!visited[v]) {
            count += dfs(v);
        }
    }

    return count;
}

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    for (int i = 0; i < M; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);
        // a -> 신뢰 -> b
        // b 해킹 시 a도 해킹 가능하다. => 간선 방향을 반대로.
        belief[b].push_back(a);
    }

    int maxCnt = 0;
    vector<int> result;

    for (int i = 1; i <= N; i ++) {
        for (int j = 1; j <= N; j ++) {
            visited[j] = false;
        }

        int cnt = dfs(i);
        
        if (cnt > maxCnt) {
            // 최댓값 갱신 -> 배열 비우고 새로 추가
            result.clear();
            result.push_back(i); 
            maxCnt = cnt;
        } else if (cnt == maxCnt) {
            // 최댓값 동일 -> 배열에 추가 
            result.push_back(i);
        }
    }

    // 오름차순 정렬
    sort(result.begin(), result.end());

    for (int k : result) {
        printf("%d ", k);
    }

    return 0;
}