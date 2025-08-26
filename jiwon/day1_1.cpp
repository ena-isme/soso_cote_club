//
//  15652.cpp
//  codingtest
//
//  Created by 신지원 on 8/25/25.
//

#include <iostream>
using namespace std;

int n, m, arr[8];;

void dfs(int pos, int start) {
    if(pos == m) {
        for(int i=0;i<m;i++) cout << arr[i] << " ";
        cout << "\n";
        return;
    } else {
        for(int i=start;i<=n;i++) {
            arr[pos] = i;
            dfs(pos+1, i);
        }
    }
}

int main(int argc, const char * argv[]) {
    
    cin >> n >> m;
    dfs(0,1);
    
    return 0;
}
