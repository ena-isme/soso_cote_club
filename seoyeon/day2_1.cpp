#include <stdio.h>
#include <iostream>
#include <deque>
#include <vector>
using namespace std;

int main() {
     int M, N;
     cin >> M >> N;

     deque<int> de; // 저장된 수의 덱
     vector<int> vec; // 뽑아내려고 하는 수의 배열
     int count = 0; // 최소 횟수

     for(int i = 1; i <= M; i++) {
        de.push_back(i);
     }

     for(int i = 0; i < N; i++) {
        int k;
        cin >> k;
        vec.push_back(k);
     }

     for(int v : vec) {
        int num = 0;

        // 뽑아내려고 하는 수의 인덱스 찾기
        for(int i = 0; i < de.size(); i++) {
            if (v == de[i]) {
                num = i;
                break;
            }
        }

        int left = num; // 왼쪽 회전
        int right = de.size() - num; // 오른쪽 회전 
        
        if (left <= right) {
            // left가 작거나 같을 때 -> 왼쪽으로 한 칸 이동
            // 맨 앞의 수와 뽑고자 하는 수가 같아질 때까지 회전 진행
            while (de.front() != v) {
                de.push_back(de.front());
                de.pop_front();
                count ++;
            }
        } else {
            // right가 더 작을 때 -> 오른쪽으로 한 칸 이동 
            // 맨 앞의 수와 뽑고자 하는 수가 같아질 때까지 회전 진행
            while (de.front() != v) {
                de.push_front(de.back());
                de.pop_back();
                count ++;
            }
        }

        // 뽑아내고자 하는 수 제거
        de.pop_front();
     }

     cout << count;
    return 0;
}
