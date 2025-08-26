//
//  1021.cpp
//  codingtest
//
//  Created by 신지원 on 8/26/25.
//

#include <iostream>
#include <queue>
#include <deque>
using namespace std;

int n,m,cnt=0;
queue<int> target;
deque<int> dq;

int findIndex(int item) {
    for(int i=0;i<dq.size();i++) {
        if(item == dq[i]) return i;
    }
    return 0;
}

int main(int argc, const char * argv[]) {
    
    //문제 세팅
    cin >> n >> m;
    for(int i=0;i<m;i++) {
        int ex;
        cin >> ex;
        target.push(ex);
    }
    
    for(int i=1;i<=n;i++)
        dq.push_back(i);
    
    
    //알고리즘 처리
    int front, tail, t;
    while(!target.empty()) {
        front = dq.front(); tail = dq.back();
        t = target.front();
        
        if(front == t) {
            dq.pop_front();
            target.pop();
        } else {

            //앞이나 뒤에 해당 숫자가 없을 경우 index 위치 찾기
            int cur = findIndex(t);
            
            // 만약 인덱스가 앞쪽이 더 가깝다면
            if(cur <= dq.size()/2) {
                dq.push_back(dq.front());
                dq.pop_front();
            }
            // 만약 인덱스가 뒤쪽이 더 가깝다면
            else {
                dq.push_front(dq.back());
                dq.pop_back();
            }
            
            cnt++;
        }
    }
    
    cout << cnt << '\n';
   
    return 0;
}
