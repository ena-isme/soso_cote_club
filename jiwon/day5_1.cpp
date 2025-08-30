//
//  14501.cpp
//  codingtest
//
//  Created by 신지원 on 8/29/25.
//

#include <iostream>
#include <vector>
using namespace std;

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    int n; cin >> n;
    vector<vector<int>> counsel(n+2,vector<int>(2));
    vector<int> dp(n+2, 0);
    for(int i=1;i<n+1;i++)
        cin >> counsel[i][0] >> counsel[i][1];
    
    //알고리즘
    for(int i=1;i<n+1;i++) {
        
        //미래가 더 크다면 오늘 건너뛰기
        dp[i+1] = max(dp[i+1], dp[i]);
        
        //해당 날짜에서 끝나는 날에 값 더해주기
        int end = i+counsel[i][0];
        if(end <= n+1)
            dp[end] = max(dp[end], dp[i] + counsel[i][1]);
    }
    
    cout << dp[n+1] << '\n';
    return 0;
}
