//
//  1697.cpp
//  codingtest
//
//  Created by 신지원 on 8/30/25.
//

#include <iostream>
#include <queue>
using namespace std;

#define MAX 200001

int n,k;
queue<int> q;
vector<int> v(MAX, -1);

void bfs() {
    q.push(n); v[n] = 0;

    while (!q.empty()) {
        int item = q.front(); q.pop();
        if(item == k) break;
        
        int dist[3] = {item-1, item+1, item*2};
        for(int i=0;i<3;i++) {
            if(dist[i] < 0 || dist[i] > 200000) continue;
            if(v[dist[i]] == -1) {
                v[dist[i]] = v[item] +1;
                q.push(dist[i]);
            }
        }
    }
    
    cout << v[k] << '\n';
}

int main(int argc, const char * argv[]) {
    
    cin >> n >> k;
    bfs();
    
    return 0;
}
