/*
 * [문제 요약]
 * L×L 체스판에서 나이트가 시작 위치에서 목표 위치로 이동하는 데 필요한 최소 이동 횟수를 구하는 문제.
 * 나이트는 체스 규칙대로 8가지 형태로만 이동
 * 한 번의 이동 비용은 모두 1
 *
 * [입력]
 * 첫 줄: 테스트 케이스 수 T
 * 각 테스트 케이스는 아래 순서로 주어진다.
 *  1) L                  // 체스판 한 변의 길이 (정수)
 *  2) sx sy              // 시작 좌표 (0 ≤ sx, sy < L)
 *  3) tx ty              // 목표 좌표 (0 ≤ tx, ty < L)
 *
 * [출력]
 * 각 테스트 케이스마다 한 줄에 최소 이동 횟수를 정수로 출력
 */

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.ArrayDeque

private val dx = intArrayOf(1, 2, 2, 1, -1, -2, -2, -1)
private val dy = intArrayOf(2, 1, -1, -2, -2, -1, 1, 2)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer("")
    fun next(): String {
        while (!st.hasMoreTokens()) st = StringTokenizer(br.readLine())
        return st.nextToken()
    }
    fun nextInt() = next().toInt()

    val t = nextInt()
    val sb = StringBuilder()

    repeat(t) {
        val L = nextInt()
        val sx = nextInt()
        val sy = nextInt()
        val tx = nextInt()
        val ty = nextInt()
        sb.append(knightMinMoves(L, sx, sy, tx, ty)).append('\n')
    }
    print(sb.toString())
}

private fun knightMinMoves(L: Int, sx: Int, sy: Int, tx: Int, ty: Int): Int {
    if (sx == tx && sy == ty) return 0

    val dist = Array(L) { IntArray(L) { -1 } }
    val q: ArrayDeque<IntArray> = ArrayDeque()

    dist[sx][sy] = 0
    q.add(intArrayOf(sx, sy))

    while (q.isNotEmpty()) {
        val cur = q.removeFirst()
        val x = cur[0]; val y = cur[1]

        for (d in 0 until 8) {
            val nx = x + dx[d]
            val ny = y + dy[d]
            if (nx !in 0 until L || ny !in 0 until L) continue
            if (dist[nx][ny] != -1) continue
            dist[nx][ny] = dist[x][y] + 1
            if (nx == tx && ny == ty) return dist[nx][ny]
            q.add(intArrayOf(nx, ny))
        }
    }
    return -1
}

