#include <stdio.h>

long long fibo[1000001];

long long fibofunc(int k) {
    if (fibo[k] != 0) return fibo[k];
    if (k <= 1) return k;
    fibo[k] = ( fibofunc(k - 1) + fibofunc(k - 2) ) % 1000000007;
    return fibo[k];
}

int dp_15624() {
    int n;
    scanf("%d", &n);

    printf("%lld", fibofunc(n));

    return 0;
}