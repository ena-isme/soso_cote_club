//
//  2531.cpp
//  codingtest
//
//  Created by 신지원 on 9/02/25.
//

#include <iostream>
#include <vector>
#include <deque>
using namespace std;

int main(int argc, const char * argv[]) {
    
    //문제세팅
    int n,d,k,c;
    cin >> n >> d >> k >> c;
    vector<int> chobab(n);
    vector<int> freq(d+1);
    deque<int> q;
    int cur = 0, res = 0;
    for(int i=0;i<n;i++) cin >> chobab[i];
    
    //초기 큐를 길이 K까지 채우기
    for(int i=0;i<k;i++) {
        if(freq[chobab[i]] == 0) cur++;
        freq[chobab[i]]++;
        q.push_back(chobab[i]);
    }
    res = cur + (freq[c] == 0 ? 1 : 0);
    
    //k+1 부터 돌아돌아 n+k 까지 돌기
    for(int i=k;i<n+k;i++) {
        
        //맨앞 접시 빼기
        freq[q.front()]--;
        if(freq[q.front()] == 0) cur--;
        q.pop_front();
        
        //맨뒤 새로운 접시 넣기
        int index= i%n;
        if(freq[chobab[index]] == 0) cur++;
        freq[chobab[index]]++;
        q.push_back(chobab[index]);
        
        //종류계산해서 맥심값으로 넣어주기
        int calcurate = cur + (freq[c] == 0 ? 1 : 0);
        res = (res >= calcurate ? res : calcurate);
    }
    
    cout << res << '\n';
    
    return 0;
}
