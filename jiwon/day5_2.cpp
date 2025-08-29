//
//  17144.cpp
//  codingtest
//
//  Created by 신지원 on 8/27/25.
//

#include <iostream>
#include <vector>
using namespace std;

int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    int r,c,t;
    cin >> r >> c >> t;
    vector<vector<int>> home(r, vector<int>(c));
    vector<vector<int>> next(r, vector<int>(c));
    int airEnd = 0;
    for(int i=0;i<r;i++)
        for(int j=0;j<c;j++) {
            cin >> home[i][j];
            if(home[i][j] == -1) airEnd = i;
        }
    
    while(t--) {
        
        for(int i=0;i<r;i++)
            fill(next[i].begin(), next[i].end(), 0);
        
        //1. 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                
                if(home[i][j] > 0) {
                    int menzi = home[i][j]/5;
                    int menziCnt = 0;
                    for(int k=0;k<4;k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                        if(home[nx][ny] == -1) continue;
                        next[nx][ny] += menzi;
                        menziCnt++;
                    }
                    
                    home[i][j] -= menzi * menziCnt;
                }
            }
        }
        
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                home[i][j] += next[i][j];
            }
        }
        
        //2. 공기청정기가 작동한다.
        int airx1 = airEnd-1, airx2 = airEnd;
        
        //0열: 공기청정기에서부터 상하 끝까지 공기청정기로 한칸씩 땡기기
        for(int i=airx1-1;i>0;i--) home[i][0] = home[i-1][0];
        for(int i=airx2+1;i<r-1;i++) home[i][0] = home[i+1][0];
        
        //0행 & R행: 0열부터 C열까지 0열로 한칸씩 땡기기
        for(int i=0;i<c-1;i++) {
            home[0][i] = home[0][i+1];
            home[r-1][i] = home[r-1][i+1];
        }
        
        //C열: 상하 끝부터 공기청정기 행까지 한칸씩 땡기기
        for(int i=0;i<airx1;i++) home[i][c-1] = home[i+1][c-1];
        for(int i=r-1;i>airx2;i--) home[i][c-1] = home[i-1][c-1];
        
        //공기청정기 행: C열부터 0열까지 한칸씩 땡기기
        for(int i=c-1;i>1;i--) {
            home[airx1][i] = home[airx1][i-1];
            home[airx2][i] = home[airx2][i-1];
        }
        
        home[airx1][1] = home[airx2][1] = 0;
        home[airx1][0] = home[airx2][0] = -1;
    }
    
    //남아있는 미세먼지의 양 출력
    int rest = 0;
    for(int i=0;i<r;i++)
        for(int j=0;j<c;j++)
            if(home[i][j] > 0) rest += home[i][j];
    cout << rest << '\n';
   
    return 0;
}
