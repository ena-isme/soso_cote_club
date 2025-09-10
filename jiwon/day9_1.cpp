//
//  1325.cpp
//  codingtest
//
//  Created by 신지원 on 9/10/25.
//

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

/*
int n,m;
vector<vector<bool>> computer;
vector<int> res;

void dfs(int num, int cur, int cnt, vector<bool> visited) {
    visited[cur] = true;
    for(int i=1;i<=n;i++) {
        if(computer[cur][i] && !visited[i]) {
            visited[i] = true; cnt++;
            dfs(num, i, cnt, visited);
        }
    }
    
    res[num] = max(res[num], cnt);
}

int main(int argc, const char * argv[]) {
    cin >> n >> m;
    computer = vector<vector<bool>> (n+1, vector<bool>(n+1, false));
    res = vector<int>(n+1);
    for(int i=0;i<m;i++) {
        int a,b; cin >> a >> b;
        computer[b][a] = true;
    }

    int max = 0;
    for(int i=1;i<=n;i++) {
        vector<bool> visited(n, false);
        dfs(i, i, 0, visited);
    }
    
    for(int i=1;i<=n;i++) {
        if(max < res[i]) {
            max = res[i];
        }
    }
    
    for(int i=1;i<=n;i++) {
        if(max == res[i]) cout << i << " ";
    }
    
    return 0;
}
*/

int main(int argc, const char * argv[]) {
    int n,m; cin >> n >> m;
    vector<vector<int>> computer(n+1);
    for(int i=0;i<m;i++) {
        int a,b; cin >> a >> b;
        computer[b].push_back(a);
    }
    
    vector<int> reach(n+1, 0);
    vector<int> visited(n+1, 0);
    int visitedMark = 0;
    
    for(int i=1;i<=n;i++) {
        visitedMark++;
        queue<int> q;
        q.push(i);
        visited[i] = visitedMark;
        
        int cnt=0;
        while(!q.empty()) {
            int c = q.front(); q.pop();
            for(int cc:computer[c]) {
                if(visited[cc] == visitedMark) continue;
                visited[cc] = visitedMark;
                cnt++;
                q.push(cc);
            }
        }
        
        reach[i] = cnt;
    }
    
    int maxCnt = *max_element(reach.begin()+1, reach.end());
    for(int i=1;i<=n;i++)
        if(reach[i] == maxCnt) cout << i << " ";
}
