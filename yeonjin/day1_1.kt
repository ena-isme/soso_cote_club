/*
 * [문제 요약]
 * 1부터 N까지 자연수 중에서 M개를 고른 수열을 모두 출력
 * 같은 수를 여러 번 골라도 되고(중복 허용), 수열은 '비내림차순'.
 * (즉, a1 ≤ a2 ≤ ... ≤ aM)
 *
 * [입력]
 * N M (1 ≤ M ≤ N ≤ 8)
 *
 * [출력]
 * 조건을 만족하는 모든 수열을 한 줄에 하나씩 공백으로 구분하여 출력.
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val seq = IntArray(m)
    val result = StringBuilder()

    fun backtrack(start: Int, depth: Int) {
        if (depth == m) {
            result.append(seq.joinToString(" "))
            result.append('\n')
            return
        }
        for (i in start..n) {
            seq[depth] = i
            backtrack(i, depth + 1)
        }
    }

    backtrack(1, 0)
    print(result)
}