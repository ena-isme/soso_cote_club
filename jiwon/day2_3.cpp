//
//  14503.cpp
//  codingtest
//
//  Created by 신지원 on 8/26/25.
//

#include <iostream>
#include <vector>
using namespace std;

/*
 로봇 청소기는 다음과 같이 작동한다.

 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    a. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    b. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
    a. 반시계 방향으로 90도 회전한다.
    b. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    c. 1번으로 돌아간다.
 */

int n,m,cnt=0;
int r,c,d;

// 북 동 남 서
int dx[4] = {-1, 0, 1, 0};
int dy[4] = {0, 1, 0, -1};

vector<vector<int>> room;

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    cin >> n >> m;
    cin >> r >> c >> d;
    
    room = vector<vector<int>>(n, vector<int>(m));
    for(int i=0;i<n;i++) {
        for(int j=0;j<m;j++) {
            cin >> room[i][j];
        }
    }
    
    //알고리즘
    while(1) {
        
        // 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
        if(room[r][c] == 0) {
            room[r][c] = 2;
            cnt++;
        }
        
        bool isMoved = false;
        for(int i=0;i<4;i++) {
            d = (d+3)%4;
            int nx = r + dx[d];
            int ny = c + dy[d];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            
            // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            //a. 반시계 방향으로 90도 회전한다.
            //b. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            if(room[nx][ny] == 0) {
                r = nx; c = ny;
                isMoved = true;
                break;
            }
        }
        
        // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        if(!isMoved) {
            
            //a. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
            //b. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
            int backD = (d+2)%4;
            int nx = r + dx[backD];
            int ny = c + dy[backD];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            
            if (room[nx][ny] == 1) break;
            r = nx; c = ny;
        }
    }
    
    cout << cnt << '\n';
    
    return 0;
}
