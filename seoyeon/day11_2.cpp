#include <stdio.h>
#include <vector>
using namespace std;

vector<int> road[5002];
vector<bool> locked(5002);
vector<int> visited(5002);

int homeCount = 0;

void dfs(int s) {
    visited[s] = true;

    for (int r : road[s]) {
        if (locked[r]) {
            continue;
        }

        if (!visited[r]) {
            dfs(r);

            homeCount ++;
        }
    }
}

int main() {
    int N, M, K;
    scanf("%d %d %d", &N, &M, &K);

    for (int i = 0; i < M; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);

        // 양방향 그래프
        road[a].push_back(b);
        road[b].push_back(a);
    }

    for (int i = 0; i < K; i ++) {
        int k;
        scanf("%d", &k);
        locked[k] = true;
    }

    dfs(1);

    printf("%d", homeCount);

    return 0;
}