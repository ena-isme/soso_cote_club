/*
 * [문제 요약]
 * N일 동안 상담
 * i일에 시작하는 상담은 T[i]일, 보상은 P[i]
 * 상담은 겹치게 X, N+1일 이후에 끝나는 상담은 수행 X
 * 얻을 수 있는 보상의 최댓값
 *
 * [입력]
 * 첫 줄: N (1 ≤ N ≤ 15)
 * 다음 N줄: T[i] P[i] (1 ≤ T[i] ≤ 5, 1 ≤ P[i] ≤ 1,000)
 *
 * [출력]
 * 가능한 보상의 최댓값(정수)
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

private val br = BufferedReader(InputStreamReader(System.`in`))
private var st: StringTokenizer? = null

fun main() {
    val n = nextInt()

    val t = IntArray(n + 2)
    val p = IntArray(n + 2)
    val dp = IntArray(n + 2)

    for (i in 1..n) {
        t[i] = nextInt()
        p[i] = nextInt()
    }

    for (i in n downTo 1) {
        val finish = i + t[i]
        dp[i] = if (finish <= n + 1) {
            max(p[i] + dp[finish], dp[i + 1])
        } else {
            dp[i + 1]
        }
    }

    println(dp[1])
}

private fun nextInt(): Int {
    while (st == null || !st!!.hasMoreTokens()) {
        st = StringTokenizer(br.readLine())
    }
    return st!!.nextToken().toInt()
}