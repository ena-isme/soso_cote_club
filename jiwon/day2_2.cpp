//
//  10971.cpp
//  codingtest
//
//  Created by 신지원 on 8/26/25.
//

#include <iostream>
#include <vector>
using namespace std;

int n, arr[10], cost=0, res=0;
bool visited[10];
vector<vector<int>> v;
       
void dfs(int start, int cur, int cost, int cnt) {
    if(cnt == n && v[cur][start]) {
        //최소비용 계산
        if(res > cost + v[cur][start] || res == 0) res = cost + v[cur][start];
        return;
    }
    
    for(int i=0;i<n;i++) {
        if(v[cur][i] && !visited[i]) {
            visited[i] = true;
            dfs(start, i, cost+v[cur][i], cnt+1);
            visited[i] = false;
        }
    }
}

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    cin >> n;
    v = vector<vector<int>>(n, vector<int>(n));
    for(int i=0;i<n;i++) {
        for(int j=0;j<n;j++) {
            cin >> v[i][j];
        }
    }
    
    //알고리즘
    visited[0] = true;
    dfs(0,0,0,1);
    cout << res << '\n';
    
    return 0;
}
