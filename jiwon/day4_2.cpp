//
//  18808.cpp
//  codingtest
//
//  Created by 신지원 on 9/11/25.
//

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int main(int argc, const char * argv[]) {
    int n,m,k; cin >> n >> m >> k;
    vector<vector<int>> laptop(n,vector<int>(m));
    queue<vector<vector<int>>> q;
    queue<pair<int, int>> index;
    for(int i=0;i<k;i++) {
        int r,c; cin >> r >> c;
        index.push({r,c});
        vector<vector<int>> sticker(r,vector<int>(c));
        for(int j=0;j<r;j++)
            for(int k=0;k<c;k++)
                cin >> sticker[j][k];
        q.push(sticker);
    }
    
    while(!q.empty()) {
        auto sticker = q.front(); q.pop();
        auto [r, c] = index.front(); index.pop();
        
        bool placed = false;
        for(int l=0;l<4 && !placed;l++) {
            
            //스티커 가로 세로 체크
            if(r <= n && c<= m) {
                
                //노트북
                for(int i=0;i<=n-r && !placed;i++) {
                    for(int j=0;j<=m-c && !placed;j++) {
                        bool isAble = true;
                        
                        //스티커 위치
                        for(int ik=0;ik<r && isAble;ik++) {
                            for(int im=0;im<c;im++) {
                                if(sticker[ik][im] == 1 && laptop[i+ik][j+im] == 1) {
                                    isAble = false;
                                    break;
                                }
                            }
                        }
                        
                        //성공시 laptop 저장
                        if(isAble) {
                            for(int ik=0;ik<r;ik++)
                                for(int im=0;im<c;im++)
                                    if(sticker[ik][im] == 1) laptop[i+ik][j+im] = 1;
                            placed = true;
                        }
                    }
                }
            }
            
            if(!placed) {
                vector<vector<int>> ex(c, vector<int>(r));
                for(int i=0;i<r;i++)
                    for(int j=0;j<c;j++)
                        ex[j][r-1-i] = sticker[i][j];
                sticker = ex;
                swap(r,c);
            }
        }
    }
    
    int res = 0;
    for(auto& row:laptop)
        for(int v:row) res += v;
    cout << res << '\n';
}
