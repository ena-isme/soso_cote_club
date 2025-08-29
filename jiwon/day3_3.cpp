//
//  2150.cpp
//  codingtest
//
//  Created by 신지원 on 8/27/25.
//

#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

int v,e;
vector<vector<int>> adj, adjRev, res;
vector<bool> visited, visitedRev;
stack<int> st;

bool cmp(const vector<int>&a, const vector<int>&b) {
    return a[0] < b[0];
}

void dfs(int cur) {
    visited[cur] = true;
    
    //인접노드 모두 방문 처리
    for(int i: adj[cur])
        if(!visited[i]) dfs(i);
    st.push(cur);
}

void dfsRev(int cur, vector<int>& scc) {
    visitedRev[cur] = true;
    scc.push_back(cur);
    
    //인접노드 모두 방문 처리 + 뭉텅이 처리
    for(int i: adjRev[cur]) {
        if(!visitedRev[i]) dfsRev(i, scc);
    }
}

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    cin >> v >> e;
    adj.resize(v+1); adjRev.resize(v+1);
    visited.resize(v+1, false); visitedRev.resize(v+1, false);
    for(int i=0;i<e;i++) {
        int a,b;
        cin >> a >> b;
        adj[a].push_back(b);
        adjRev[b].push_back(a);
    }
    
    //정방향로 뭉텅이 묶어주기
    for(int i=1;i<v;i++)
        if(!visited[i]) dfs(i);
    
    //묶어준 뭉텅이가 역방향으로도 가능한지 체크
    while(!st.empty()) {
        int item = st.top(); st.pop();
        if(!visitedRev[item]) {
            vector<int> scc;
            dfsRev(item, scc);
            sort(scc.begin(), scc.end());
            res.push_back(scc);
        }
    }
    
    cout << res.size() << '\n';
    sort(res.begin(), res.end(), cmp);
    for(auto &scc: res) {
        for(int i:scc) cout << i << " ";
        cout << "-1\n";
    }
    
    return 0;
}
