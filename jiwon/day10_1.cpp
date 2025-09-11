//
//  1446.cpp
//  codingtest
//
//  Created by 신지원 on 9/11/25.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    int n,d;
    cin >> n >> d;
    
    vector<vector<pair<int, int>>> road(d+1);
    for(int i=0;i<n;i++) {
        int start, dest, cost;
        cin >> start >> dest >> cost;
        if((dest-start <= cost) || dest > d) continue;
        road[start].push_back({dest,cost});
    }
    
    vector<int> dp(d+1, 0);
    for(int i=0;i<=d;i++) dp[i] = i;
    for(int i=0;i<d;i++) {
        dp[i+1] = min(dp[i+1], dp[i]+1);
        for(auto [dest, cost] : road[i])
            dp[dest] = min(dp[dest], dp[i] + cost);
    }
    
    cout << dp[d] << '\n';
}
