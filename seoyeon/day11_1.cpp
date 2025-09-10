#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int N;
    scanf("%d", &N);

    vector<long long> a(N);
    vector<long long> b(N);

    for (int i = 0; i < N; i ++) {
        long long temp;
        scanf("%lld", &temp);
        a[i] = temp;
    }

    for (int i = 0; i < N; i ++) {
        long long temp;
        scanf("%lld", &temp);
        b[i] = temp;
    }

    // 각 배열을 오름차순 정렬
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());

    int count = 0;
    vector<long long> resultA(100001);
    vector<long long> resultB(100001);

    int indexA = 0, indexB = 0; // 정렬된 배열을 가리키는 포인터
    int sA = 0, sB = 0; // 투포인터 중 시작포인터
    int eA = N - 1, eB = N - 1; // 투포인터 중 끝포인터

    while ((indexA < N) && (indexB < N)) {
            if (a[indexA] == b[indexB]) {
                resultA[sA] = a[indexA];
                resultB[sB] = b[indexB];

                indexA ++;
                indexB ++;
                sA ++;
                sB ++;
                count ++;
            } else if (a[indexA] < b[indexB]) {
                resultA[eA] = a[indexA];

                eA --;
                indexA ++;
            } else {
                resultB[eB] = b[indexB];

                eB --;
                indexB ++;
            }
    }

    // 나머지 채워지지 않은 배열을 뒤에서부터 채운다. 
    while (indexA < N) {
        resultA[eA] = a[indexA];
        eA --;
        indexA ++;
    }

    while (indexB < N) {
        resultB[eB] = b[indexB];
        eB --;
        indexB ++;
    }

    printf("%d\n", count);

    for (int i = 0; i < N; i ++) {
        printf("%lld ", resultA[i]);
    }

    printf("\n");

    for (int i = 0; i < N; i ++) {
        printf("%lld ", resultB[i]);
    }

    return 0;
}