import java.io.BufferedReader
import java.io.InputStreamReader

/*
n -> 접시 개수
d -> 초밥 가짓
k -> 연속해서 먹는 접시의 수
c -> 쿠폰 번호
 */
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }

    val belt = IntArray(n) { br.readLine().toInt() }

    val count = IntArray(d + 1)
    var sushiType = 0
    val window: ArrayDeque<Int> = ArrayDeque()

    repeat(k) { i ->
        val sushi = belt[i]
        window.addLast(sushi)
        if (count[sushi] == 0) sushiType++
        count[sushi]++
    }

    var maxType = if (count[c] == 0) sushiType + 1 else sushiType

    for (i in k..<n + k - 1) {
        val removed = window.removeFirst()
        count[removed]--
        if (count[removed] == 0) sushiType--

        val addSushi = belt[i % n]
        window.addLast(addSushi)
        if (count[addSushi] == 0) sushiType++
        count[addSushi]++

        val totalType = if (count[c] == 0) sushiType + 1 else sushiType
        if (totalType > maxType) maxType = totalType
    }

    println(maxType)
}
