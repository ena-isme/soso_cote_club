#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main () {
    int n;
    scanf("%d", &n);

    vector<int> v;

    for (int i = 0; i < n; i ++) {
        int k;
        scanf("%d", &k);
        v.push_back(k);
    }

    int x;
    scanf("%d", &x);

    // 1. 오름차순 정렬
    sort(v.begin(), v.end());

    // 2. 투포인터 계산
    int il = 0;
    int ir = n - 1;
    int count = 0;

    while(il < ir) {
        if (v[il] + v[ir] == x) {
            count ++;
            ir --;
        } else if (v[il] + v[ir] < x) {
            il ++;
        } else {
            ir --;
        } 
    }

    printf("%d", count);

    return 0;
}