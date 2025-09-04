#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int day7_1() {
    int N, M;
    scanf("%d %d", &N, &M);

    vector<int> v;
    
    for(int i = 0; i < N; i ++) {
        int temp;
        scanf("%d", &temp);
        v.push_back(temp);
    }   

    int team = 0; // 만들 수 있는 최대 팀수

    // 1. N에 대한 조건
    // 2명 이상일때부터 팀 조함 가능
    if (N < 2) {
        printf("%d", team);
        return 0;
    }

    // 2. 능력치 기준 오름차순 정렬
    sort(v.begin(), v.end());

    int left = 0, right = N - 1;

    while(left < right) {
        if (v[left] + v[right] >= M) {
            team ++;
            left ++;
            right --;
        } else {
            left ++;
        }
    }

    printf("%d", team);

    return 0;
}
