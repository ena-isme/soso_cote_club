#include <stdio.h>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

// 1260. DFS와 BFS

int N, M, V;
vector<int> graph[1001];
vector<bool> visited(1001);    

// 1. DFS: 깊이 우선 탐색

void dfs(int s) {
    // 매개변수 s: 시작 정점
    // 1. 시작정점에 대한 방문여부 true
    visited[s] = true;

    printf("%d ", s);

    // 조건: s-i 정점이 연결 && 정점 i를 방문 X
    for (int v : graph[s]) {
        if (visited[v] == false) {
            dfs(v);
        }
    }
}       

// 2. BFS: 넓이 우선 탐색 
// queue를 활용해보자

void bfs(int s) {
    queue<int> q;
    q.push(s);
    visited[s] = true;

    // queue가 비워질 때까지 진행
    while(!q.empty()) {
        int f = q.front();
        q.pop();
        printf("%d ", f);

        for (int v : graph[f]) {
            if (visited[v] == false) {
                visited[v] = true;
                q.push(v);
            }
        }
    }
}

int baekjoon_1260() {
    scanf("%d %d %d", &N, &M, &V);

    for (int i = 0; i < M; i ++) {
        int a, b;
        scanf("%d %d", &a, &b);

        // a-b 정점이 연결되어있음을 의미
        graph[a].push_back(b);
        graph[b].push_back(a);
    }

    // 작은 번호부터 방문 -> 오름차순 정렬
    for (int i = 1; i <= N; i++) {
        sort(graph[i].begin(), graph[i].end());
    }

    for (int i = 1; i <= N; i ++) {
        visited[i] = false;
    }

    dfs(V);

    printf("\n");

    for (int i = 1; i <= N; i ++) {
        visited[i] = false;
    }

    bfs(V);

    printf("\n");

    return 0;
}