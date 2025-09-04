#include <stdio.h>
#include <vector>
#include <deque>
#include <algorithm>
using namespace std;

int main() {
    int N, d, k, c;
    scanf("%d %d %d %d", &N, &d, &k, &c);

    deque<int> de; // 벨트 위에 있는 초밥 번호 배열

    for (int i = 0; i < N; i ++) {
        int temp;
        scanf("%d", &temp);
        de.push_back(temp);
    }

    int maxCount = 0; // 초밥 가짓수의 최댓값

    // 1. 구성할 수 있는 초밥 가짓수 구하기 
    for(int i = 0; i < N; i ++) {
        int count = 0; // 먹을 수 있는 초밥 가짓수
        vector<int> v; // 조합 내 초밥 번호 배열
        vector<int> sushi(d+1); // 초밥 종류를 관리하는 배열

        for(int i = 0; i < k; i ++) {
            v.push_back(de[i]);
        }
        
        // 2. 조합에 있는 초밥 종류 수 구하기
        for (int i = 0; i < k; i ++) {
            // 처음 추가된 경우 -> 종류 1 증가
            if (sushi[v[i]] == 0) count ++;
            sushi[v[i]] ++;
        }

        // 3. 무료 초밥 포함 여부 확인하기
        if (sushi[c] == 0) {
            count ++;
        }

        if (count > maxCount) {
            maxCount = count;
        }

        de.push_back(de.front());
        de.pop_front();
    }

    printf("%d", maxCount);

    return 0;
}