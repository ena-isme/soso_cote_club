//
//  7562.cpp
//  codingtest
//
//  Created by 신지원 on 8/27/25.
//

#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

#define MAX 300
#define DIST 8
int l;
int knightX, knightY;
int targetX, targetY;
vector<vector<bool>> chess;

int dx[DIST] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dy[DIST] = {1, 2, 2, 1, -1, -2, -2, -1};

void bfs(int x, int y) {
    queue<tuple<int,int,int>> q;
    q.push({x,y,0});
    chess[x][y] = true;
    
    while(!q.empty()) {
        auto [qx,qy,cnt] = q.front(); q.pop();
        
        if(qx == targetX && qy == targetY) {
            cout << cnt << '\n';
            return;
        }
        for(int i=0;i<DIST;i++) {
            int nx = qx + dx[i];
            int ny = qy + dy[i];
            
            if(nx < 0 || nx >=l || ny < 0 || ny >= l) continue;
            if(!chess[nx][ny]) {
                chess[nx][ny] = true;
                q.push({nx, ny, cnt+1});
            }
        }
    }
}

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    int t;
    cin >> t;
    
    while(t--) {
        
        //조건 초기화
        cin >> l;
        chess.assign(l, vector<bool>(l));
        cin >> knightX >> knightY;
        cin >> targetX >> targetY;
        
        //알고리즘
        bfs(knightX, knightY);
    }
    return 0;
}
