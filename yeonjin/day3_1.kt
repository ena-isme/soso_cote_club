/*
 * [문제 요약]
 * 각 지원자는 서류 심사 성적과 면접 성적 2가지 점수를 가짐.
 * 어떤 지원자 A가 다른 지원자 B보다 두 점수 모두 낮으면(=서류도 떨어지고 면접도 떨어짐) A는 선발X
 * 선발 가능한 지원자의 최대 인원을 구해라.
 *
 * [입력]
 * 첫 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 20)
 * 각 테스트 케이스마다
 * - 첫 줄에 지원자의 수 N (1 ≤ N ≤ 100,000)
 * - 이어서 N개의 줄에 지원자의 서류 성적, 면접 성적이 주어짐
 *     (1 ≤ 성적 ≤ N, 성적은 중복되지 않음 = 순위)
 *
 * [출력]
 * 각 테스트 케이스마다 선발 가능한 신입사원의 최대 인원 수를 출력.
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(t) {
        val n = br.readLine().toInt()
        val applicants = mutableListOf<Pair<Int, Int>>()

        repeat(n) {
            val st = StringTokenizer(br.readLine())
            val doc = st.nextToken().toInt()
            val interview = st.nextToken().toInt()
            applicants.add(doc to interview)
        }

        applicants.sortBy { it.first }

        var count = 1
        var minInterview = applicants[0].second

        for (i in 1 until n) {
            val interviewScore = applicants[i].second
            if (interviewScore < minInterview) {
                count++
                minInterview = interviewScore
            }
        }

        sb.append(count).append('\n')
    }

    print(sb.toString())
}
