//
//  1106.cpp
//  codingtest
//
//  Created by 신지원 on 9/10/25.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    
    //세팅
    int c, n;
    cin >> c >> n;
    vector<int> cost(n);
    vector<int> customer(n);
    vector<int> dp(c + 1, 1e9);
    for(int i=0;i<n;i++)
        cin >> cost[i] >> customer[i];

    //알고리즘
    dp[0] = 0;
    for(int i=0;i<c+1;i++) {
        for(int j=0;j<n;j++) {
            int rest = i - customer[j];
            if(rest < 0) rest = 0;
            dp[i] = min(dp[i], dp[rest] + cost[j]);
        }
    }
    
    cout << dp[c] << '\n';
    
    return 0;
}
