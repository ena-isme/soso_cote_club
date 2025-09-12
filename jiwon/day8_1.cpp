//
//  1535.cpp
//  codingtest
//
//  Created by 신지원 on 9/10/25.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n; cin >> n;
    int bad[n]; int good[n];
    for(int j=0;j<n;j++) cin >> bad[j];
    for(int j=0;j<n;j++) cin >> good[j];
    
    int dp[100];
    fill(dp, dp + 100, 0);
    for(int i=0;i<n;i++)
        for(int j=99;j>=bad[i];j--)
            dp[j] = max(dp[j], dp[j - bad[i]] + good[i]);
    
    cout << dp[99] << '\n';
    
    return 0;
}
