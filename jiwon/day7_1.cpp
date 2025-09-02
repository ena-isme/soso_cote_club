//
//  26091.cpp
//  codingtest
//
//  Created by 신지원 on 9/02/25.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    int n,m; cin >> n >> m;
    vector<int> p(n);
    for(int i=0;i<n;i++) cin >> p[i];
    int res=0;
    
    //능력치 순으로 정렬
    sort(p.begin(), p.end());
    
    //투포인터
    int start = 0, end = n-1;
    while(start < end) {
        //포인터의 합이 최소 합보다 같거나 클 경우 포인터 조정
        if(p[start] + p[end] >=m) {
            res++;
            start++; end--;
        } else {
            start++;
        }
    }
    
    cout << res << '\n';
    
    return 0;
}
