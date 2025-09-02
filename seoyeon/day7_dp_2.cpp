#include <stdio.h>
#include <vector>
using namespace std;

//1. 홀수 짝수를 기준으로
int dp_9656() {
    int N;
    scanf("%d", &N);

    if (N % 2 == 0) {
        printf("SK");
    } else {
        printf("CY");
    }

    return 0;
}