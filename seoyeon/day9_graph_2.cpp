#include <stdio.h>
#include <vector>
using namespace std;

// 11724. 연결 요소의 개수
vector<int> g[1001];
vector<bool> vs(1001);

void dfss(int s) {
     vs[s] = true;

    for (int v : g[s]) {
        if (!vs[v]) dfss(v);
    }
}

int baekjoon_11724() {
    // N: 정점 개수, M: 간선 개수
    int N, M;
    scanf("%d %d", &N, &M);

    for(int i = 0; i < M; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);
        g[a].push_back(b);
        g[b].push_back(a);
    }

    int count = 0;

    for (int i = 1; i <= N; i ++) {
        if (!vs[i]) {
            dfss(i);
            count ++;
        }
    }

    printf("%d", count);

    return 0;
}