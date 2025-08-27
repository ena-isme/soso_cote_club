//
//  1946.cpp
//  codingtest
//
//  Created by 신지원 on 8/27/25.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const vector<int>& a, const vector<int>& b) {
    return a[0] < b[0];
}

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    int t; cin >> t;
    
    while(t--) {
        int cnt=0;
        int n; cin >> n;
        vector<vector<int>> rank(n, vector<int>(2));
        for(int i=0;i<n;i++)
            cin >> rank[i][0] >> rank[i][1];
        
        //서류 [0] 기준으로 sort 후
        //면접성적이 더 작을 때만 카운트 세도록 함
        sort(rank.begin(), rank.end(), cmp);
        int min = n+1;
        for(int i=0;i<n;i++) {
            if(rank[i][1] < min) {
                min = rank[i][1];
                cnt++;
            }
        }
        
        cout << cnt << '\n';
    }
    
    return 0;
}
